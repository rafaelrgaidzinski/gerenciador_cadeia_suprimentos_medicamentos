package com.example.gerenciador_cadeia_suprimento_medicamentos.repositories;

import com.example.gerenciador_cadeia_suprimento_medicamentos.models.FornecedorModel;
import com.example.gerenciador_cadeia_suprimento_medicamentos.models.ServicosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicosRepository extends JpaRepository<ServicosModel, Long> {

    List<ServicosModel> findByNome(String nome);
}
