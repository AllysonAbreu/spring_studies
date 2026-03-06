package br.com.unipds.spring.security;

import br.com.unipds.spring.dto.MyToken;
import br.com.unipds.spring.dto.UserLoginDTO;
import br.com.unipds.spring.model.UserD;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Collections;
import java.util.Date;

public class TokenUtill {

    public static final String EMISSOR = "3b82d937-4489-46cd-ad62-1899d14037f2";
    public static final long EXPIRATION = 60 * 60 * 1000;
    public static final String SECRET_KEY = "01234567890123456789012345678901";

    public static MyToken enconder(UserD user) {
        try{
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            String token = Jwts.builder()
                    .subject(user.getUsername())
                    .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                    .issuer(EMISSOR)
                    .signWith(key)
                    .compact();

            return new MyToken(token);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static Authentication decode(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        System.out.println("Request header: "+header);

        if (header != null) {
            String token = header.replace("Bearer ", "");
            SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            JwtParser parser = Jwts.parser().verifyWith(key).build();
            Claims claims = (Claims) parser.parse(token).getPayload();

            String subject = claims.getSubject();
            String issuer = claims.getIssuer();
            Date expiration = claims.getExpiration();

            if ( issuer.equals(EMISSOR) && subject.length() > 0 && expiration.equals(new Date(System.currentTimeMillis()))) {
                return new UsernamePasswordAuthenticationToken(
                        "valido",
                        null,
                        Collections.emptyList());
            }
        }
        return null;
    }
}
