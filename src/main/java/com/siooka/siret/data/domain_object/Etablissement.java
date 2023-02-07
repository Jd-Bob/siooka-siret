package com.siooka.siret.data.domain_object;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "etablissment")
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String siren;
    private String nic;
    private String siret;

    @Column(name = "date_creation_tablissement")
    private Date dateCreationEtablissement;

    private String activite;

    private String address;
}
