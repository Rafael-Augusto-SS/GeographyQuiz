package br.edu.ifrn.GeographyQuiz.domain.quiz;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.edu.ifrn.GeographyQuiz.domain.pergunta.*;
import br.edu.ifrn.GeographyQuiz.domain.usuario.Usuario;

@Entity(name = "quiz")    //JPQL
@Table(name = "quiz")     //SQL
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome do quiz obrigatório")
    @Column(name = "nome")
    private String nome;

    @NotBlank(message = "A Descrição do quiz obrigatório")
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nota")
    private Integer nota;

    @Column(name = "pontuacao")
    private Integer pontuacao;

    @Column(name = "data_hora")
    private LocalDate data_hora;

    @ManyToOne
    @JoinColumn(name = "jogador_atual_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "pergunta_atual_id")
    private Pergunta pergunta;
    
}
