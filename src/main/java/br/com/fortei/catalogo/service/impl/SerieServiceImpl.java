package br.com.fortei.catalogo.service.impl;

import br.com.fortei.catalogo.entity.Serie;
import br.com.fortei.catalogo.enums.Status;
import br.com.fortei.catalogo.repository.SerieRepository;
import br.com.fortei.catalogo.service.api.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Override
    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    @Override
    public List<Serie> findAssistindo() {
        return serieRepository.findByStatus(Status.ASSISTINDO);
    }

    @Override
    public Serie findById(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    @Override
    public Long save(Serie serie) {
        normalize(serie);
        validate(serie);
        return serieRepository.save(serie).getId();
    }

    @Override
    public void validate(Serie serie) {
        if (serie.getTemporadas() <= 0 || serie.getEpisodios() <= 0) {
            throw new RuntimeException("Não existe série sem nenhuma temporada ou episódio!");
        }
    }

    @Override
    public void normalize(Serie serie) {
        if (serie.getId() == null) {
            serie.setStatus(Status.NAO_ASSISTIDO);
        }
    }

    @Override
    public void deleteById(Long id) {
        serieRepository.deleteById(id);
    }
}
