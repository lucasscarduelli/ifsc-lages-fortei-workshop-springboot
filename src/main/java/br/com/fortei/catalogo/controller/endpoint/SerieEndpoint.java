package br.com.fortei.catalogo.controller.endpoint;

import br.com.fortei.catalogo.entity.Serie;
import br.com.fortei.catalogo.enums.Categoria;
import br.com.fortei.catalogo.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SerieEndpoint {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/api/series", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Serie> findAll() {
        List<Serie> series = new ArrayList<>();

        Serie breakingBad = Serie.builder()
                .id(1l).titulo("Breaking Bad")
                .sinopse("O professor de química Walter White não acredita que sua vida possa piorar ainda mais. Quando descobre que tem câncer terminal, Walter decide arriscar tudo para ganhar dinheiro enquanto pode, transformando sua van em um laboratório de metanfetamina.")
                .categoria(Categoria.DRAMA).status(Status.NAO_ASSISTIDO).anoLancamento(2008l)
                .temporadas(5l).episodios(Long.valueOf(7+13+13+13+16)).finalizada(true).build();

        Serie gameOfThrones = Serie.builder()
                .id(2l).titulo("Game of Thrones")
                .sinopse("Retrato de duas famílias poderosas - reis e rainhas, cavaleiros e renegados, homens honestos e mentirosos - disputando um jogo mortal pelo controle dos Sete Reinos de Westeros para assumir o Trono de Ferro.")
                .categoria(Categoria.DRAMA).status(Status.NAO_ASSISTIDO).anoLancamento(2011l)
                .temporadas(8l).episodios(Long.valueOf(10+10+10+10+10+10+7+6)).finalizada(false).build();

        series.add(breakingBad);
        series.add(gameOfThrones);
        return series;
    }

}
