package com.example.gerenciador_cadeia_suprimento_medicamentos.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="insumos")
public class InsumosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="insumo_id")
    private Long id;

    @Column(name="nome_insumo")
    private String nome;

    @Column(name="codigo_barra")
    private String codigoBarra;

    @Column(name="descricao")
    private String descricao;

    @Column(name="unidade")
    private String unidade;

    @Column(name="quantidade_inicial")
    private Double quantidadeInicial;

    @Column(name="quantidade_atual")
    private Double quantidadeAtual;

}
