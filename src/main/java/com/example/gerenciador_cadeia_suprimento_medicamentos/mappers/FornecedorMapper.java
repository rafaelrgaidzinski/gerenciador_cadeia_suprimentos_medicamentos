package com.example.gerenciador_cadeia_suprimento_medicamentos.mappers;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.FornecedorDto.FornecedorRequestDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.FornecedorDto.FornecedorResponseDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.FornecedorModel;

public class FornecedorMapper {

    public FornecedorRequestDto toFornecedorRequestDto (FornecedorModel fornecedorModel) {
        return new FornecedorRequestDto(
                fornecedorModel.getNome(),
                fornecedorModel.getCnpj(),
                fornecedorModel.getEnderecoId(),
                fornecedorModel.getTelefone()
        );
    }

    public FornecedorResponseDto toFornecedorResponseDto (FornecedorModel fornecedorModel) {
        return new FornecedorResponseDto(
                fornecedorModel.getNome(),
                fornecedorModel.getCnpj(),
                fornecedorModel.getTelefone()
        );
    }

    public FornecedorModel toEntity (FornecedorRequestDto fornecedorRequestDto) {
        return new FornecedorModel(
                null,
                fornecedorRequestDto.nome(),
                fornecedorRequestDto.cnpj(),
                fornecedorRequestDto.enderecoId(),
                fornecedorRequestDto.telefone()
        );
    }

}
