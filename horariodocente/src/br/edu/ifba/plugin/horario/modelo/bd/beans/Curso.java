package br.edu.ifba.plugin.horario.modelo.bd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "curso", schema = "academico")
@NamedQueries({ @NamedQuery(name = "findByModalidadeCurso", 
query = "SELECT u FROM Curso u WHERE u.idmodalidadecurso.id=:idmodalidadecurso") })
public class Curso {

	public Curso() {

	}

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = "SEQ_CURSO", schema = "academico", sequenceName = "SEQ_CURSO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CURSO")
	private Integer id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "idmodalidadecurso")
	private ModalidadeCurso idmodalidadecurso;

	@ManyToOne
	@JoinColumn(name = "idcoordenador")
	private Servidor idcoordenador;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ModalidadeCurso getIdmodalidadecurso() {
		return idmodalidadecurso;
	}

	public void setIdmodalidadecurso(ModalidadeCurso idmodalidadecurso) {
		this.idmodalidadecurso = idmodalidadecurso;
	}

	public Servidor getIdcoordenador() {
		return idcoordenador;
	}

	public void setIdcoordenador(Servidor idcoordenador) {
		this.idcoordenador = idcoordenador;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idcoordenador == null) ? 0 : idcoordenador.hashCode());
		result = prime
				* result
				+ ((idmodalidadecurso == null) ? 0 : idmodalidadecurso
						.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idcoordenador == null) {
			if (other.idcoordenador != null)
				return false;
		} else if (!idcoordenador.equals(other.idcoordenador))
			return false;
		if (idmodalidadecurso == null) {
			if (other.idmodalidadecurso != null)
				return false;
		} else if (!idmodalidadecurso.equals(other.idmodalidadecurso))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
