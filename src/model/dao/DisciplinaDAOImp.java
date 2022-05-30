
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.entities.Disciplina;

public class DisciplinaDAOImp implements DisciplinaDAO {
	static PreparedStatement pst;
	static String sql;

	private Connection conexao;
	
	public DisciplinaDAOImp(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Disciplina obj) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			String sql = "INSERT INTO disciplina (nomedisciplina,cargahoraria) VALUES (?,?)";
			pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, obj.getNomedisciplina());
			pst.setInt(2, obj.getCargahoraria());
			int linhas = pst.executeUpdate();
			
			if (linhas > 0) {
				rs = pst.getGeneratedKeys();
				rs.next();
				obj.setIdDisciplina(rs.getInt(1));
				System.out.println(obj.toString() + " foi criado com sucesso !");
			}
			else {
				System.out.println("Nao foi possivel cadastrar a disciplina !");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Disciplina obj) {

		try {
			sql = "UPDATE disciplina SET nomedisciplina= ?,cargahoraria= ? Where iddisciplina=?";
			pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1,obj.getNomedisciplina());
			pst.setInt(2,obj.getCargahoraria());
			pst.setInt(3, obj.getIdDisciplina());
			
			
			if(pst.executeUpdate() >=1) {
				System.out.println("curso alterado com sucesso");
			}
			else {
				System.out.println("Nao foi encontrado curso com ID "+ obj.getIdDisciplina() + "!");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

/*
	public List<Disciplina> update(Disciplina obj) {
		
	//	sql = "SELECT * FROM disciplina";
	//	pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	//	ResultSet rs = pst.executeQuery();
	//	List <Disciplina> lista= new ArrayList<>();
	//	while (rs.next()) {
	//		Disciplina d = new Disciplina(rs.getInt(1),rs.getString(2),rs.getInt(3));
	//		lista.add(d);
	//	}
		//	return lista;
	//	}
	try {
		sql = "UPDATE curso SET (nomedisciplina= ?,cargahoraria=?) Where iddisciplina=?";
		pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = pst.executeQuery();
		List <Disciplina> lista= new ArrayList<>();
		while (rs.next()) {
			Disciplina d = new Disciplina(rs.getInt(1),rs.getString(2),rs.getInt(3));
			lista.add(d);
		}
		//pst.setString(1,obj.getNomedisciplina());
		//pst.setInt(2, obj.getCargahoraria());
		//pst.setInt(3, obj.getIdDisciplina());
		
		
		if(pst.executeUpdate() >=1) {
			System.out.println("Disciplina alterado com sucesso");
		}
		else {
			System.out.println("Nao foi encontrado Disciplina com ID "+ obj.getIdDisciplina()+ "!");
		}
		return lista;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}*/
		
	

	@Override
	public void deleteById(Integer id) {
		try {
		sql= "DELETE FROM disciplina WHERE iddisciplina= ?";
		pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pst.setInt(1,id);
		
		
		if(pst.executeUpdate() >=1) {
			System.out.println("Disciplina excluida com sucesso");
		}
		else {
			System.out.println("Nao foi encontrado disciplina com id = "+ id + "!");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Disciplina findById(Integer id) {
		
		return null;
	}

	@Override
	public List<Disciplina> findAll() {
		
		return null;
	}


	
}
