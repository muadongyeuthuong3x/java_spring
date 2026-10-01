package com.cwm.studentMagement.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;;

@Getter
@Setter
@Entity
@Table (name = "users")
public class Users {
    
    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private Long id;

    @Column(nullable = false , unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active;
}
