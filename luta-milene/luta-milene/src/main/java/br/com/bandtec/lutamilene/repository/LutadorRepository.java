package br.com.bandtec.lutamilene.repository;

import br.com.bandtec.lutamilene.dominio.Lutadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutadores, Integer> {

      List<Lutadores> findAll();
      List<Lutadores> findAllByOrdergolpeForcaDesc();
       int countByVivo(boolean s);

}
