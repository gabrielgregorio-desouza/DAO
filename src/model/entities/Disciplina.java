package model.entities;

import java.util.Objects;

public class Disciplina {
	private Integer idDisciplina;
	private String nomedisciplina;
	private Integer cargahoraria;
	
	public Disciplina() {
	}

	public Disciplina(Integer idDisciplina, String nomedisciplina, Integer cargahoraria) {
		super();
		this.idDisciplina = idDisciplina;
		this.nomedisciplina = nomedisciplina;
		this.cargahoraria = cargahoraria;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomedisciplina() {
		return nomedisciplina;
	}

	public void setNomedisciplina(String nomedisciplina) {
		this.nomedisciplina = nomedisciplina;
	}

	public int getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(int cargahoraria) {
		this.cargahoraria = cargahoraria;
	}
	
	

	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nomedisciplina=" + nomedisciplina + ", cargahoraria="
				+ cargahoraria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomedisciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(nomedisciplina, other.nomedisciplina);
	}

	
	
	
	

}
