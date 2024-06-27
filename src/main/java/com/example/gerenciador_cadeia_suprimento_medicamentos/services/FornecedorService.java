package com.example.gerenciador_cadeia_suprimento_medicamentos.services;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.FornecedorDto.FornecedorRequestDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.FornecedorDto.FornecedorResponseDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.mappers.FornecedorMapper;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.FornecedorModel;
import com.example.gerenciador_cadeia_suprimento_medicamentos.repositories.FornecedorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    FornecedorMapper fornecedorMapper;

    @Transactional
    public FornecedorResponseDto save(FornecedorModel fornecedorModel) {
        return fornecedorMapper.toFornecedorResponseDto(fornecedorRepository.save(fornecedorModel));
    }

    @Transactional
    public void delete(FornecedorModel fornecedorModel) {
        fornecedorRepository.delete(fornecedorModel);
    }

    public List<FornecedorResponseDto> findAllPageable(Integer pagina,
                                                    Integer resultados,
                                                    List<String> ordenacao
    ) {
        List<Sort.Order> orderList = ordenacao.stream().map((ordem) -> {
            return new Sort.Order(Sort.Direction.DESC, ordem);
        }).toList();

        Pageable pageable = PageRequest.of(pagina,resultados, Sort.by(orderList));
        Page<FornecedorModel> fornecedorModelPage = fornecedorRepository.findAll(pageable);
        return fornecedorModelPage.map(fornecedorMapper::toFornecedorResponseDto).toList();
    }

    public Optional<FornecedorResponseDto> findFornecedorResponseById(Long id) {

        Optional<FornecedorModel> fornecedorModelOptional = fornecedorRepository.findById(id);
        if (fornecedorModelOptional.isEmpty()){
            return Optional.empty();
        }
        FornecedorModel fornecedorModel = new FornecedorModel();
        BeanUtils.copyProperties(fornecedorModelOptional.get(), fornecedorModel);
        return Optional.ofNullable(fornecedorMapper.toFornecedorResponseDto(fornecedorModel));
    }

    public Optional<FornecedorRequestDto> findFornecedorRequestById(Long id) {

        Optional<FornecedorModel> fornecedorModelOptional = fornecedorRepository.findById(id);
        if (fornecedorModelOptional.isEmpty()){
            return Optional.empty();
        }
        FornecedorModel fornecedorModel = new FornecedorModel();
        BeanUtils.copyProperties(fornecedorModelOptional.get(), fornecedorModel);
        return Optional.ofNullable(fornecedorMapper.toFornecedorRequestDto(fornecedorModel));
    }


    public Optional<List<FornecedorResponseDto>> findByNome(String nome) {

        Optional<List<FornecedorModel>> optionalFornecedorModelList = Optional.ofNullable(fornecedorRepository.findByNome(nome));
        if (optionalFornecedorModelList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(optionalFornecedorModelList.stream().flatMap(Collection::stream).map(fornecedorMapper::toFornecedorResponseDto).toList());
    }

}

