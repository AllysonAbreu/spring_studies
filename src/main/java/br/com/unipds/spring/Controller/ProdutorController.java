package br.com.unipds.spring.Controller;

import br.com.unipds.spring.Model.Produto;
import ch.qos.logback.core.util.StringUtil;
import io.micrometer.common.util.StringUtils;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

@RestController
public class ProdutorController {

    private final ArrayList<Produto> database;

    public ProdutorController() {
        database = new ArrayList<>() {{
            add(new Produto(1, "Computador", 1500.0));
            add(new Produto(2, "Mouse", 50.0));
            add(new Produto(3, "Teclado", 100));
            add(new Produto(4, "Monitor", 500.0));
            add(new Produto(5, "Impressora", 350.0));
        }};
    }

    @GetMapping("/produtos")
    public ArrayList<Produto> recuperarTodos() {
        return database;
    }


    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> recuperarPeloId(@PathVariable int id) {
        Produto produto = database.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        if(Objects.nonNull(produto)) {
            return ResponseEntity.ok(produto);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/sort")
    public ResponseEntity<List<Produto>> recuperarOrdenado(@RequestParam(name = "order", required = false) String order) {
        if(StringUtils.isBlank(order)) {
            return ResponseEntity.ok(database);
        } else if(order.equals("asc")) {
            List<Produto> list = database.stream().sorted(Comparator.comparing(Produto::getPreco)).toList();
            return ResponseEntity.ok(list);
        } else if (order.equals("desc")) {
            List<Produto> list = database.stream().sorted(Comparator.comparing(Produto::getPreco).reversed()).toList();
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto p) {
        boolean add = database.add(p);

        if(add) {
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> alterarDados(@PathVariable int id, @RequestBody Produto p) {
        int posicao = IntStream.range(0, database.size())
                .filter(i -> database.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

        if(posicao >=0) {
            database.set(posicao, p);
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Produto> apagarProduto(@PathVariable int id) {
        int posicao = IntStream.range(0, database.size())
                .filter(i -> database.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

        if(posicao >= 0) {
            Produto produto = database.get(posicao);
            database.remove(posicao);
            return ResponseEntity.ok(produto);
        }

        return ResponseEntity.notFound().build();
    }
}
