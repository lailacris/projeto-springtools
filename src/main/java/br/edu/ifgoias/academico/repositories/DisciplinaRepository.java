package br.edu.ifgoias.academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifgoias.academico.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

}
