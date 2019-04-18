package br.com.fortei.catalogo.entity;

import br.com.fortei.catalogo.enums.Categoria;
import br.com.fortei.catalogo.enums.Status;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Serie {

    private static final String SEQ_NAME = "SERIE_SEQ";

    @Id
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    private String titulo;
    private String sinopse;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Long anoLancamento;
    private Long temporadas;
    private Long episodios;
    private Boolean finalizada;

}
