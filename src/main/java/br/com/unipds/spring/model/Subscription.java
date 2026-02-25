package br.com.unipds.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_subscription")
public class Subscription {

    @Id
    private SubscrtionID id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "lvel")
    private Integer level;

    @Column(name = "unique_id", nullable = false, length = 45)
    private String uniqueID;

    public SubscrtionID getId() {
        return id;
    }

    public void setId(SubscrtionID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }
}
