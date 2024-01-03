package br.edu.ifrn.GeographyQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.GeographyQuiz.domain.pontuacao.Pontuacao;

public interface PontuacaoRepository extends JpaRepository<Pontuacao, Long>{

  
}
