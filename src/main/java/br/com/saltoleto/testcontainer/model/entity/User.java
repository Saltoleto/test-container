package br.com.saltoleto.testcontainer.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Data
@Table("users")
public class User implements Serializable {
    @Id
    private Long id;
    private String username;
    private String email;
}
