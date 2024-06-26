package com.example.gerenciador_cadeia_suprimento_medicamentos.services;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.ServicosDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.mappers.ServicosMapper;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.ServicosModel;
import com.example.gerenciador_cadeia_suprimento_medicamentos.repositories.ServicosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ServicosService {

    @Autowired
    ServicosRepository servicosRepository;

    @Autowired
    ServicosMapper servicosMapper;

    @Transactional
    public ServicosDto save(ServicosDto servicosDto) {
        ServicosModel servicosModel = servicosMapper.toEntity(servicosDto);
        return servicosMapper.toServicoDto(servicosRepository.save(servicosModel));
    }

    @Transactional
    public void delete(ServicosDto servicosDto) {
        ServicosModel servicosModel = servicosMapper.toEntity(servicosDto);
        servicosRepository.delete(servicosModel);
    }

    public List<ServicosDto> findAllPageable(Integer pagina,
                                            Integer resultados,
                                            List<String> ordenacao
    ) {
        List<Sort.Order> orderList = ordenacao.stream().map((ordem) -> {
            return new Sort.Order(Sort.Direction.DESC, ordem);
        }).toList();

        Pageable pageable = PageRequest.of(pagina,resultados, Sort.by(orderList));
        Page<ServicosModel> servicosModelPage = servicosRepository.findAll(pageable);
        return servicosModelPage.map(servicosMapper::toServicoDto).toList();
    }

    public Optional<ServicosDto> findServicoById(Long id) {

        Optional<ServicosModel> servicosModelOptional = servicosRepository.findById(id);
        if (servicosModelOptional.isEmpty()){
            return Optional.empty();
        }
        ServicosModel servicosModel = new ServicosModel();
        BeanUtils.copyProperties(servicosModelOptional.get(), servicosModel);
        return Optional.ofNullable(servicosMapper.toServicoDto(servicosModel));
    }


    public Optional<List<ServicosDto>> findByNome(String nome) {

        Optional<List<ServicosModel>> optionalServicosModelList = Optional.ofNullable(servicosRepository.findByNome(nome));
        if (optionalServicosModelList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(optionalServicosModelList.stream().flatMap(Collection::stream).map(servicosMapper::toServicoDto).toList());
    }
}
