package br.com.vinicius.IntroAPP.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Data

public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    @Getter @Setter
    private String name;

    @Column(nullable = false, length = 1)
    @Getter @Setter
    private String gender;

    @Column(nullable = false, length = 50)
    @Getter @Setter
    private String city;
}
