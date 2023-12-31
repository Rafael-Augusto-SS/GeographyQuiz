package br.edu.ifrn.GeographyQuiz.domain.pergunta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "pergunta")
@Table(name = "pergunta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O texto da pergunta obrigatório")
    private String texto;
    @NotNull
    private String resposta_correta;
    @NotNull
    private String respostas;

    public Pergunta(@Valid PerguntaRequestDTO perguntaDTO) {
      this.texto = perguntaDTO.texto();
      this.resposta_correta = perguntaDTO.resposta_correta();
      this.respostas = perguntaDTO.respostas();
;
    }

}
