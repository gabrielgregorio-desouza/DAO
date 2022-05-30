
package model.dao;

import java.util.List;
import model.entities.Disciplina;

public interface DisciplinaDAO {
	
	void insert(Disciplina obj);
	//List<Disciplina> update(Disciplina obj);
	void deleteById(Integer id);
	Disciplina findById(Integer id);
	List<Disciplina> findAll();
	void update(Disciplina obj);
}
