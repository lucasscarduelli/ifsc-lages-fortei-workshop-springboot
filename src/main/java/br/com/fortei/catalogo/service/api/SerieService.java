package br.com.fortei.catalogo.service.api;

import br.com.fortei.catalogo.entity.Serie;

import java.util.List;

public interface SerieService {

    List<Serie> findAll();

    List<Serie> findAssistindo();

    Serie findById(Long id);

    Long save(Serie serie);

    void validate(Serie serie);

    void normalize(Serie serie);

    void deleteById(Long id);

}
