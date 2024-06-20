package com.example.gerenciador_cadeia_suprimento_medicamentos.mappers;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.EnderecoDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.ServicosDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.EnderecoModel;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.ServicosModel;

public class ServicosMapper {

    public ServicosDto toServicoDto (ServicosModel servicosModel) {
        return new ServicosDto(
                servicosModel.getNome(),
                servicosModel.getDescricao(),
                servicosModel.getValor()
        );
    }

    public ServicosModel toEntity (ServicosDto servicosDto) {
        return new ServicosModel(
                null,
                servicosDto.nome(),
                servicosDto.descricao(),
                servicosDto.valor()
        );
    }
}
