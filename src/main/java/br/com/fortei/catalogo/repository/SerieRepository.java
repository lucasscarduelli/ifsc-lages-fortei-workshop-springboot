package br.com.fortei.catalogo.repository;

import br.com.fortei.catalogo.entity.Serie;
import br.com.fortei.catalogo.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    List<Serie> findByStatus(Status status);

}
