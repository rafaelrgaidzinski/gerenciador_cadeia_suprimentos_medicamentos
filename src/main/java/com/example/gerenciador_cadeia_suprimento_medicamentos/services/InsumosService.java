package com.example.gerenciador_cadeia_suprimento_medicamentos.services;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.InsumosDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.mappers.InsumosMapper;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.InsumosModel;
import com.example.gerenciador_cadeia_suprimento_medicamentos.repositories.InsumosRepository;
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
public class InsumosService {

    @Autowired
    InsumosRepository insumosRepository;

    @Autowired
    InsumosMapper insumosMapper;

    @Transactional
    public InsumosDto save(InsumosDto insumosDto) {
        InsumosModel insumosModel = insumosMapper.toEntity(insumosDto);
        return insumosMapper.toInsumoDto(insumosRepository.save(insumosModel));
    }

    @Transactional
    public void delete(InsumosDto insumosDto) {
        InsumosModel insumosModel = insumosMapper.toEntity(insumosDto);
        insumosRepository.delete(insumosModel);
    }

    public List<InsumosDto> findAllPageable(Integer pagina,
                                            Integer resultados,
                                            List<String> ordenacao
    ) {
        List<Sort.Order> orderList = ordenacao.stream().map((ordem) -> {
            return new Sort.Order(Sort.Direction.DESC, ordem);
        }).toList();

        Pageable pageable = PageRequest.of(pagina,resultados, Sort.by(orderList));
        Page<InsumosModel> insumosModelPage = insumosRepository.findAll(pageable);
        return insumosModelPage.map(insumosMapper::toInsumoDto).toList();
    }

    public Optional<InsumosDto> findInsumosById(Long id) {

        Optional<InsumosModel> insumosModelOptional = insumosRepository.findById(id);
        if (insumosModelOptional.isEmpty()){
            return Optional.empty();
        }
        InsumosModel insumosModel = new InsumosModel();
        BeanUtils.copyProperties(insumosModelOptional.get(), insumosModel);
        return Optional.ofNullable(insumosMapper.toInsumoDto(insumosModel));
    }


    public Optional<List<InsumosDto>> findByNome(String nome) {

        Optional<List<InsumosModel>> optionalInsumosModelList = Optional.ofNullable(insumosRepository.findByNome(nome));
        if (optionalInsumosModelList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(optionalInsumosModelList.stream().flatMap(Collection::stream).map(insumosMapper::toInsumoDto).toList());
    }

}

