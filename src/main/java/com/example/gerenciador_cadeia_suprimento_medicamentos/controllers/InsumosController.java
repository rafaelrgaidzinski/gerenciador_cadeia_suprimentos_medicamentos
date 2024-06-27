package com.example.gerenciador_cadeia_suprimento_medicamentos.controllers;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.InsumosDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.FornecedorModel;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.InsumosModel;
import com.example.gerenciador_cadeia_suprimento_medicamentos.services.InsumosService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/insumos")
public class InsumosController {

    @Autowired
    InsumosService insumosService;

    @PostMapping
    public ResponseEntity<InsumosDto> saveInsumo(@RequestBody @Valid InsumosDto insumosDto){
        var insumoModel = new InsumosModel();
        BeanUtils.copyProperties(insumosDto, insumoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(insumosService.save(insumoModel));
    }

    @GetMapping
    public ResponseEntity<List<InsumosDto>> getInsumo(@RequestParam(defaultValue = "0") Integer pagina,
                                                      @RequestParam(defaultValue = "5") Integer resultados,
                                                      @RequestParam(defaultValue = "nome") List<String> ordenacao
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(insumosService.findAllPageable(pagina, resultados, ordenacao)) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getInsumoById(@PathVariable(value = "id") Long id) {
        Optional<InsumosDto> optionalInsumosDto = insumosService.findInsumosById(id);
        if (optionalInsumosDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Insumo não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalInsumosDto.get());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Object> getInsumoByNome(@PathVariable(value = "nome") String nome) {
        Optional<List<InsumosDto>> optionalInsumosDtoList = insumosService.findByNome(nome);
        optionalInsumosDtoList.stream().forEach(System.out::println);
        if (optionalInsumosDtoList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar insumos com este nome");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalInsumosDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInsumo(@PathVariable(value = "id") Long id){
        Optional<InsumosDto> optionalInsumosDto = insumosService.findInsumosById(id);
        if (optionalInsumosDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Insumo não encontrado.");
        }
        var insumoModel = new InsumosModel();
        BeanUtils.copyProperties(optionalInsumosDto, insumoModel);
        insumoModel.setId(id);
        insumosService.delete(insumoModel);
        return ResponseEntity.status(HttpStatus.OK).body("Insumo excluído com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInsumo(@PathVariable(value = "id") Long id,
                                               @RequestBody @Valid InsumosDto insumosDto){
        Optional<InsumosDto> optionalInsumosDto = insumosService.findInsumosById(id);
        if (optionalInsumosDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Insumo não encontrado.");
        }
        var insumoModel = new InsumosModel();
        BeanUtils.copyProperties(insumosDto, insumoModel);
        insumoModel.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(insumosService.save(insumoModel));
    }
}
