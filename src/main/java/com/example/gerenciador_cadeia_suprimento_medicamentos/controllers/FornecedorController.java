package com.example.gerenciador_cadeia_suprimento_medicamentos.controllers;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.FornecedorDto.FornecedorRequestDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.FornecedorDto.FornecedorResponseDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.services.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorResponseDto> saveFornecedor(@RequestBody @Valid FornecedorRequestDto fornecedorRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorService.save(fornecedorRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDto>> getFornecedor(@RequestParam(defaultValue = "0") Integer pagina,
                                                                @RequestParam(defaultValue = "5") Integer resultados,
                                                                @RequestParam(defaultValue = "nome") List<String> ordenacao
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.findAllPageable(pagina, resultados, ordenacao)) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFornecedorById(@PathVariable(value = "id") Long id) {
        Optional<FornecedorResponseDto> optionalFornecedorResponseDto = fornecedorService.findFornecedorResponseById(id);
        if (optionalFornecedorResponseDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalFornecedorResponseDto.get());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Object> getFornecedorByNome(@PathVariable(value = "nome") String nome) {
        Optional<List<FornecedorResponseDto>> optionalFornecedorResponseDtoList = fornecedorService.findByNome(nome);
        optionalFornecedorResponseDtoList.stream().forEach(System.out::println);
        if (optionalFornecedorResponseDtoList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar fornecedores com este nome");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalFornecedorResponseDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFornecedor(@PathVariable(value = "id") Long id){
        Optional<FornecedorRequestDto> optionalFornecedorRequestDto = fornecedorService.findFornecedorRequestById(id);
        if (optionalFornecedorRequestDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado.");
        }
        fornecedorService.delete(optionalFornecedorRequestDto.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fornecedor excluído com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFornecedor(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid FornecedorRequestDto fornecedorRequestDto){
        Optional<FornecedorRequestDto> optionalFornecedorRequestDto = fornecedorService.findFornecedorRequestById(id);
        if (optionalFornecedorRequestDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.save(optionalFornecedorRequestDto.get()));
    }
}
