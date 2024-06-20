package com.example.gerenciador_cadeia_suprimento_medicamentos.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="fornecedor")
public class FornecedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="fornecedor_id")
    private Long id;

    @Column(name="nome_fornecedor")
    private String nome;

    @Column(name="cnpj_fornecedor")
    private String cnpj;

    @Column(name="endereco_id")
    private Long enderecoId;

    @Column(name="telefone")
    private String telefone;

}
