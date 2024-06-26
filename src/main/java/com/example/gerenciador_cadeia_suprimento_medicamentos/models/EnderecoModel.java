package com.example.gerenciador_cadeia_suprimento_medicamentos.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="enderecos")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="endereco_id")
    private Long id;

    @Column(name="logradouro")
    private String logradouro;

    @Column(name="numero")
    private Integer numero;

    @Column(name="bairro")
    private String bairro;

    @Column(name="cidade")
    private String cidade;

    @Column(name="estado")
    private String estado;

    @Column(name="cep")
    private String cep;

}