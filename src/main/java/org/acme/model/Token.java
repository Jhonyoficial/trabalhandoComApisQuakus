package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "token")
@Data
public class Token  extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_token")
    @SequenceGenerator(name = "id_token", sequenceName = "id_token", allocationSize = 1)
    @Column(name = "id_token")
    private  Integer idToken;

    @Column(name = "token", length = 700)
    private String dsToken;

}
