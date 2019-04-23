package br.com.fortei.catalogo.controller.endpoint;

import br.com.fortei.catalogo.controller.dto.SerieResource;
import br.com.fortei.catalogo.controller.dto.SerieResourceAssembler;
import br.com.fortei.catalogo.entity.Serie;
import br.com.fortei.catalogo.enums.Categoria;
import br.com.fortei.catalogo.enums.Status;
import br.com.fortei.catalogo.service.api.SerieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SerieEndpoint {

    @Autowired
    private SerieService serieService;

    @Autowired
    private SerieResourceAssembler serieResourceAssembler;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/series", method = {RequestMethod.GET})
    public List<SerieResource> findAll() {
        return serieResourceAssembler.toResources(serieService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/series/assistindo", method = {RequestMethod.GET})
    public List<SerieResource> findAssistindo() {
        return serieResourceAssembler.toResources(serieService.findAssistindo());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/series/{id}")
    public SerieResource getById(@PathVariable Long id) {
        return serieResourceAssembler.toResource(serieService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/series")
    public ResponseEntity<SerieResource> create(@RequestBody Serie serieInput, HttpServletRequest request) {
        Long id = serieService.save(serieInput);
        Serie serie = serieService.findById(id);
        return ResponseEntity
                .created(URI.create(request.getRequestURL() + "/" + id))
                .body(serieResourceAssembler.toResource(serie));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/series/{id}")
    public SerieResource update(@RequestBody Serie serieInput, @PathVariable Long id) {
        Serie serie = Serie.builder().id(id).build();
        BeanUtils.copyProperties(serieInput, serie);
        serieService.save(serie);
        return serieResourceAssembler.toResource(serieService.findById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/series/{id}")
    public void delete(@PathVariable Long id) {
        serieService.deleteById(id);
    }
}

