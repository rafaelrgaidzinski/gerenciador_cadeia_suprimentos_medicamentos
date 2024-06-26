package com.example.gerenciador_cadeia_suprimento_medicamentos.mappers;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.EnderecoDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.ServicosDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.EnderecoModel;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.ServicosModel;
import org.springframework.stereotype.Component;

@Component
public class ServicosMapper {

    public ServicosDto toServicoDto (ServicosModel servicosModel) {
        return new ServicosDto(
                servicosModel.getNome(),
                servicosModel.getDescricao()
        );
    }

    public ServicosModel toEntity (ServicosDto servicosDto) {
        return new ServicosModel(
                null,
                servicosDto.nome(),
                servicosDto.descricao()
        );
    }
}
