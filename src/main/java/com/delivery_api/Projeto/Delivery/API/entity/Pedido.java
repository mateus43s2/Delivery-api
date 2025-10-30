package com.delivery_api.Projeto.Delivery.API.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero_pedido;

    private String status;

    private DecimalFormat valor_total;

    private String observacoes;

    private Long cliente_id;

    private Long restaurante_id;

    private String itens;

    @Column(name = "data_pedido")
    private LocalDateTime data_pedido;

}
