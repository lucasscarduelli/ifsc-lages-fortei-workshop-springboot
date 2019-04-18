package br.com.fortei.catalogo.controller.endpoint;

import br.com.fortei.catalogo.enums.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CategoriaEndpoint {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/categorias")
    public List<Categoria> findAll() {
        return Arrays.asList(Categoria.values());
    }

}


