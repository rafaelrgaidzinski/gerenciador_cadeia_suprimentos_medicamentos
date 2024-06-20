package com.example.gerenciador_cadeia_suprimento_medicamentos.repositories;

import com.example.gerenciador_cadeia_suprimento_medicamentos.models.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {

    List<FornecedorModel> findByNome(String nome);
}
