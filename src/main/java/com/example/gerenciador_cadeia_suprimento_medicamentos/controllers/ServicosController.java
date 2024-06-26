package com.example.gerenciador_cadeia_suprimento_medicamentos.controllers;

import com.example.gerenciador_cadeia_suprimento_medicamentos.dtos.ServicosDto;
import com.example.gerenciador_cadeia_suprimento_medicamentos.services.ServicosService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

    @Autowired
    ServicosService servicosService;

    @PostMapping
    public ResponseEntity<ServicosDto> saveServico(@RequestBody @Valid ServicosDto servicosDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicosService.save(servicosDto));
    }

    @GetMapping
    public ResponseEntity<List<ServicosDto>> getInsumo(@RequestParam(defaultValue = "0") Integer pagina,
                                                      @RequestParam(defaultValue = "5") Integer resultados,
                                                      @RequestParam(defaultValue = "nome") List<String> ordenacao
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(servicosService.findAllPageable(pagina, resultados, ordenacao)) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getServicoById(@PathVariable(value = "id") Long id) {
        Optional<ServicosDto> optionalServicosDto = servicosService.findServicoById(id);
        if (optionalServicosDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalServicosDto.get());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Object> getServicoByNome(@PathVariable(value = "nome") String nome) {
        Optional<List<ServicosDto>> optionalServicosDtoList = servicosService.findByNome(nome);
        optionalServicosDtoList.stream().forEach(System.out::println);
        if (optionalServicosDtoList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar serviços com este nome");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalServicosDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteServico(@PathVariable(value = "id") Long id){
        Optional<ServicosDto> optionalServicosDto = servicosService.findServicoById(id);
        if (optionalServicosDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado.");
        }
        servicosService.delete(optionalServicosDto.get());
        return ResponseEntity.status(HttpStatus.OK).body("Serviço excluído com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateServico(@PathVariable(value = "id") Long id,
                                               @RequestBody @Valid ServicosDto servicosDto){
        Optional<ServicosDto> optionalInsumosDto = servicosService.findServicoById(id);
        if (optionalInsumosDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(servicosService.save(optionalInsumosDto.get()));
    }
}
