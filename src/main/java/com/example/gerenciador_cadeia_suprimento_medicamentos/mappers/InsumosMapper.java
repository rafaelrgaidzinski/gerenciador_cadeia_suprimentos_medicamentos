package com.example.gerenciador_cadeia_suprimento_medicamentos.mappers;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.InsumosDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.InsumosModel;
import org.springframework.stereotype.Component;

@Component
public class InsumosMapper {

    public InsumosDto toInsumoDto (InsumosModel insumosModel) {
        return new InsumosDto(
                insumosModel.getNome(),
                insumosModel.getDescricao(),
                insumosModel.getUnidade(),
                insumosModel.getQuantidadeAtual()
        );
    }

    public InsumosModel toEntity (InsumosDto insumosDto) {
        return new InsumosModel(
                null,
                insumosDto.nome(),
                insumosDto.descricao(),
                insumosDto.unidade(),
                0.0
        );
    }

}
