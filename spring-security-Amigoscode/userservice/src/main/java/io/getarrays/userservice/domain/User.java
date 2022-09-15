package io.getarrays.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "myUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, username, password;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();



}
