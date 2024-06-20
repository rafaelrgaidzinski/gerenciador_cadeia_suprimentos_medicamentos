package com.example.gerenciador_cadeia_suprimento_medicamentos.repositories;

import com.example.gerenciador_cadeia_suprimento_medicamentos.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long>{
}
