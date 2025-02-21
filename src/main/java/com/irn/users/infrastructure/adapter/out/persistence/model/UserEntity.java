package com.irn.users.infrastructure.adapter.out.persistence.model;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    //name is concatenation of title + first + last
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String gender;
    @Column
    private String picture;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String country;

}
