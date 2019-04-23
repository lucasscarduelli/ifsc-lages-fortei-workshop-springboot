package br.com.fortei.catalogo.controller.dto;

import br.com.fortei.catalogo.controller.endpoint.SerieEndpoint;
import br.com.fortei.catalogo.entity.Serie;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class SerieResourceAssembler extends ResourceAssemblerSupport<Serie, SerieResource> {

    public SerieResourceAssembler() {
        super(SerieEndpoint.class, SerieResource.class);
    }

    @Override
    public SerieResource toResource(Serie serie) {
        SerieResource serieResource = new SerieResource();

        serieResource.setTitulo(serie.getTitulo());
        serieResource.setSinopse(serie.getSinopse());
        serieResource.setCategoria(serie.getCategoria().name());
        serieResource.setStatus(serie.getStatus().name());
        serieResource.setAnoLancamento(serie.getAnoLancamento());
        serieResource.setTemporadas(serie.getTemporadas());
        serieResource.setEpisodios(serie.getEpisodios());
        serieResource.setFinalizada(serie.getFinalizada());

        serieResource.add(linkTo(methodOn(SerieEndpoint.class).getById(serie.getId())).withSelfRel());

        return serieResource;
    }

    public List<SerieResource> toResources(List<Serie> series) {
        List<SerieResource> serieResources = new ArrayList<>();
        for (Serie serie: series) {
            serieResources.add(toResource(serie));
        }
        return serieResources;
    }
}

