package com.example.gerenciador_cadeia_suprimento_medicamentos.mappers;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.InsumosDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.InsumosModel;

public class InsumosMapper {

    public InsumosDto toInsumoDto (InsumosModel insumosModel) {
        return new InsumosDto(
                insumosModel.getNome(),
                insumosModel.getCodigoBarra(),
                insumosModel.getDescricao(),
                insumosModel.getUnidade()
        );
    }

    public InsumosModel toEntity (InsumosDto insumosDto) {
        return new InsumosModel(
                null,
                insumosDto.nome(),
                insumosDto.codigoBarra(),
                insumosDto.descricao(),
                insumosDto.unidade(),
                0.0,
                0.0
        );
    }

}
