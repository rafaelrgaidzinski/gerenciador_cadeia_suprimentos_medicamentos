package com.example.gerenciador_cadeia_suprimento_medicamentos.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InsumosDto(@NotBlank(message = "É obrigatório informar o nome do insumo")
                         String nome,

                         String descricao,

                         @NotBlank(message = "É obrigatório informar a unidade do insumo")
                         String unidade,

                         @NotNull(message = "O valor não pode ser nulo")
                         @Min(value = 0, message = "O valor mínimo é zero")
                         Double quantidadeAtual
) {
}
