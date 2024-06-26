package com.example.gerenciador_cadeia_suprimento_medicamentos.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServicosDto( @NotBlank(message = "É obrigatório informar o nome do serviço")
                           String nome,

                          @NotBlank(message = "É obrigatório informar a descrição do serviço")
                          String descricao
) {
}
