package br.com.fortei.catalogo.controller.dto;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class SerieResource extends ResourceSupport {

    private String titulo;
    private String sinopse;
    private String categoria;
    private String status;
    private Long anoLancamento;
    private Long temporadas;
    private Long episodios;
    private Boolean finalizada;

}

