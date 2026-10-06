package br.com.nexa_mobility.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tab_seguros")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SeguroEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private int numeroApolice;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private double valorPremio;

    @Column(nullable = false)
    private String dataFim;

    @Column(nullable = false)
    private String status;

}
