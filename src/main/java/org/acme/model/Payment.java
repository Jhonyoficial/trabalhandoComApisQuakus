package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "payment")
public class Payment extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_pagamento")
    @SequenceGenerator(sequenceName = "id_token", name = "id_token", allocationSize = 1)
    @Column(name = "id_pagamento")
    private Integer id;

    @Column(name = "ds_receipt", length = 4000)
    private String receipt;

    @Column(name = "ds_digitable")
    private String digitable;

    @Column(name = "nm_amount")
    private Double amount;

    @CreationTimestamp
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
}
