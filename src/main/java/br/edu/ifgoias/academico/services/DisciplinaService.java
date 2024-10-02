package br.edu.ifgoias.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRep;

	public List<Disciplina> findAll() {
		return disciplinaRep.findAll();
	}

	public Disciplina findById(Integer id) {
		return disciplinaRep.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
 
	public Disciplina insert(Disciplina obj) {
		return disciplinaRep.save(obj);
	}

	public void delete(Integer id) {
		disciplinaRep.deleteById(id);
	}

	public Disciplina update(Integer id, Disciplina obj_alterado) {
		return disciplinaRep.findById(id).map(disciplinaDB -> {
			disciplinaDB.setNomedisciplina(obj_alterado.getNomedisciplina());
			disciplinaDB.setCargahoraria(obj_alterado.getCargahoraria());
			return disciplinaRep.save(disciplinaDB);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}