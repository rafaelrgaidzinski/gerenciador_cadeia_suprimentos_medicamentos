package com.example.gerenciador_cadeia_suprimento_medicamentos.dtos;

import jakarta.validation.constraints.NotBlank;

public record InsumosDto(@NotBlank(message = "É obrigatório informar o nome do insumo")
                         String nome,

                         @NotBlank(message = "É obrigatório informar o código de barra do insumo")
                         String codigoBarra,

                         String descricao,

                         @NotBlank(message = "É obrigatório informar a unidade do insumo")
                         String unidade
) {
}
