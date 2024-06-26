package com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.FornecedorDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FornecedorRequestDto(@NotBlank(message = "É obrigatório informar o nome do fornecedor")
                                    String nome,

                                    @NotBlank(message = "É obrigatório informar o cnpj do fornecedor")
                                    String cnpj,

                                    @NotBlank(message = "É obrigatório informar o telefone do fornecedor")
                                    String telefone,

                                    @NotNull(message = "É obrigatório informar o id do endereco do fornecedor")
                                    Long enderecoId
) {

}
