package model.dao;

import java.util.List;

import model.entities.Aluno;



public interface AlunoDAO {
	void insert(Aluno obj);
	//List<Aluno> update(Aluno obj) throws SQLException;
	void deleteById(Integer id);
	Aluno findById(Integer id);
	List<Aluno> findAll();
	void update(Aluno obj);
}
