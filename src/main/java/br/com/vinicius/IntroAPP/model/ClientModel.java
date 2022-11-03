package br.com.vinicius.IntroAPP.model;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "The ID")
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    @Getter @Setter
    @ApiModelProperty(notes = "The client's  full name")
    private String name;

    @Column(nullable = false, length = 1)
    @Getter @Setter
    @ApiModelProperty(notes = "Gender - just one character (M or F)")
    private String gender;

    @Column(nullable = false, length = 50)
    @Getter @Setter
    @ApiModelProperty(notes = "The city of the client")
    private String city;

    //Attributes V2
    @Column(nullable = true, length = 100)
    @Getter @Setter
    @ApiModelProperty(notes = "A valid email address")
    private String email;

    //..relationship with ProfessionModel
    @ManyToOne
    @JoinColumn(name = "profession_id")
    @Getter @Setter
    private ProfessionModel profession;


}
