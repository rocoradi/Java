/**
 * @author Coradi
 *
 * 10 de jan de 2018
 */
package com.schoolofnet.WebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolofnet.WebApp.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
