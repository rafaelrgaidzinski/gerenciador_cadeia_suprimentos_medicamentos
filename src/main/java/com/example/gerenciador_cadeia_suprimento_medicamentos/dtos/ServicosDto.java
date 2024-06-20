package com.example.gerenciador_cadeia_suprimento_medicamentos.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServicosDto( @NotBlank(message = "É obrigatório informar o nome do serviço")
                           String nome,

                          String descricao,

                          @NotNull(message = "É obrigatório informar o valor do serviço")
                          @Min(value = 1, message = "O valor deve ser maior do que zero")
                          Double valor
) {
}
