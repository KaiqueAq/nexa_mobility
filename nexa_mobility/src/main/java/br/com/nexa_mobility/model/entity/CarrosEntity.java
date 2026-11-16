package br.com.nexa_mobility.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_carros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarrosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String ano;
    @Column(nullable = false)
    private String placa;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private String numeroportas;
}


