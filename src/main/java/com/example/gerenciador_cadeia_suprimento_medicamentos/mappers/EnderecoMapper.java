package com.example.gerenciador_cadeia_suprimento_medicamentos.mappers;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.EnderecoDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.EnderecoModel;

public class EnderecoMapper {

    public EnderecoDto toEnderecoDto (EnderecoModel enderecoModel) {
        return new EnderecoDto(
                enderecoModel.getLogradouro(),
                enderecoModel.getNumero(),
                enderecoModel.getBairro(),
                enderecoModel.getCidade(),
                enderecoModel.getEstado(),
                enderecoModel.getCep()
        );
    }

    public EnderecoModel toEntity (EnderecoDto enderecoDto) {
        return new EnderecoModel(
                null,
                enderecoDto.logradouro(),
                enderecoDto.numero(),
                enderecoDto.bairro(),
                enderecoDto.cidade(),
                enderecoDto.estado(),
                enderecoDto.cep()
        );
    }
}



