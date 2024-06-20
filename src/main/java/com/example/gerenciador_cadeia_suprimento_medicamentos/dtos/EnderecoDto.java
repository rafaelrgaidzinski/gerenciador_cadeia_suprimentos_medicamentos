package com.example.gerenciador_cadeia_suprimento_medicamentos.dtos;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDto(@NotBlank(message = "É obrigatório informar o logradouro")
                          String logradouro,

                          Integer numero,

                          @NotBlank(message = "É obrigatório informar o bairro")
                          String bairro,

                          @NotBlank(message = "É obrigatório informar a cidade")
                          String cidade,

                          @NotBlank(message = "É obrigatório informar o estado")
                          String estado,

                          @NotBlank(message = "É obrigatório informar o cep")
                          String cep
) {
}
