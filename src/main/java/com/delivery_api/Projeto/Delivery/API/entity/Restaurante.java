package com.delivery_api.Projeto.Delivery.API.entity;

import jakarta.persistence.*;
import lombok.*;
import java.text.DecimalFormat;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurantes")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_restaurante;

    private String nome;

    private String categoria;

    private String endereco;

    private String telefone;

    private DecimalFormat taxa_entrega;

    private DecimalFormat avaliacao;

    @Column(nullable = true)
    private Boolean ativo;

    public void inativar() {
        this.ativo = false;
    }
}
