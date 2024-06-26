package com.example.gerenciador_cadeia_suprimento_medicamentos.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="servicos")
public class ServicosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "servico_id")
    private Long id;

    @Column(name = "nome_servico")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

}