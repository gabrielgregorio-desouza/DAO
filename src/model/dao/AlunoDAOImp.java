
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.entities.Aluno;


public class AlunoDAOImp implements AlunoDAO {
	static PreparedStatement pst;
	static String sql;
	static Date dataSql ;
	private Connection conexao;
	
	
	public AlunoDAOImp(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Aluno obj) {
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql ;
		
		try {
			
			sql= "INSERT INTO aluno (nome, sexo, dt_nasc, nota) VALUES (?,?,?,?)";
			pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, obj.getNomeAluno());
			pst.setString(2, obj.getSexo());
			dataSql = new Date(obj.getDt_nasc().getTime());
			pst.setDate(3, dataSql);
			pst.setFloat(4, obj.getNota());
			int linhas = pst.executeUpdate();
			
			if (linhas > 0) {
				rs = pst.getGeneratedKeys();
				rs.next();
				obj.setIdAluno(rs.getInt(1));
				System.out.println(obj.toString() + " foi criado com sucesso !");
			}
			else {
				System.out.println("Nao foi possivel cadastrar o aluno!");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	/*public static List<Aluno> listar(Connection con) throws SQLException {
		
		sql = "SELECT * FROM aluno";
		pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List <Aluno> lista= new ArrayList<>();
		while (rs.next()) {
			Aluno a = new Aluno(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
			lista.add(a);
		}
			return lista;
		}*/

	/*public List<Disciplina> update(Disciplina obj) throws SQLException {
		/*sql = "SELECT * FROM disciplina";
		pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = pst.executeQuery();
		List <Disciplina> lista= new ArrayList<>();
		while (rs.next()) {
			Disciplina d = new Disciplina(rs.getInt(1),rs.getString(2),rs.getInt(3));
			lista.add(d);
		}
			return lista;
		}
		*/
	
	@Override
	public void update(Aluno obj) {
try {
			sql = "UPDATE aluno SET nome= ?,sexo= ?, dt_nasc= ?,nota =? Where idaluno=?";
			pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1,obj.getNomeAluno());
			pst.setString(2,obj.getSexo());
			dataSql = new Date(obj.getDt_nasc().getTime());
			pst.setDate(3, dataSql);
			pst.setFloat(4, obj.getNota());
			
			pst.setInt(5, obj.getIdAluno());
			
			
			if(pst.executeUpdate() >=1) {
				System.out.println("Aluno alterado com sucesso");
			}
			else {
				System.out.println("Nao foi encontrado aluno com ID "+ obj.getIdAluno() + "!");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

	@Override
	public void deleteById(Integer id) {
		try {
		sql= "DELETE FROM aluno WHERE idaluno= ?";
		pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pst.setInt(1,id);
		
		
		if(pst.executeUpdate() >=1) {
			System.out.println("Aluno excluido com sucesso");
		}
		else {
			System.out.println("Nao foi encontrado aluno com id = "+ id + "!");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Aluno findById(Integer id) {
		
		return null;
	}

	@Override
	public List<Aluno> findAll() {
		
		return null;
	}

	

	
}