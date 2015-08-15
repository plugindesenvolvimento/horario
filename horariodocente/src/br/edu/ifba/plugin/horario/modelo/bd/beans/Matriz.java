package br.edu.ifba.plugin.horario.modelo.bd.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "matriz", schema = "academico")
public class Matriz {

	public Matriz() {

	}

	@Id
	@SequenceGenerator(name = "SEQ_MATRIZ", schema = "academico", sequenceName = "SEQ_MATRIZ_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATRIZ")
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "data", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name = "ativa")
	private Boolean ativa;

	@Column(name = "codigoinep")
	private Integer codigoinep;

	@ManyToOne
	@JoinColumn(name = "idcurso")
	private Curso idcurso;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "quantidadeperiodos")
	private Integer quantidadeperiodos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}
	
	public Integer getCodigoinep() {
		return codigoinep;
	}

	public void setCodigoinep(Integer codigoinep) {
		this.codigoinep = codigoinep;
	}

	public Curso getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Curso idcurso) {
		this.idcurso = idcurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getQuantidadeperiodos() {
		return quantidadeperiodos;
	}

	public void setQuantidadeperiodos(Integer quantidadeperiodos) {
		this.quantidadeperiodos = quantidadeperiodos;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativa == null) ? 0 : ativa.hashCode());
		result = prime * result
				+ ((codigoinep == null) ? 0 : codigoinep.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idcurso == null) ? 0 : idcurso.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((quantidadeperiodos == null) ? 0 : quantidadeperiodos
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matriz other = (Matriz) obj;
		if (ativa == null) {
			if (other.ativa != null)
				return false;
		} else if (!ativa.equals(other.ativa))
			return false;
		if (codigoinep == null) {
			if (other.codigoinep != null)
				return false;
		} else if (!codigoinep.equals(other.codigoinep))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idcurso == null) {
			if (other.idcurso != null)
				return false;
		} else if (!idcurso.equals(other.idcurso))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (quantidadeperiodos == null) {
			if (other.quantidadeperiodos != null)
				return false;
		} else if (!quantidadeperiodos.equals(other.quantidadeperiodos))
			return false;
		return true;
	}	
}
