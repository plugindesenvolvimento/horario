package br.edu.ifba.plugin.horario.modelo.bd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.edu.ifba.plugin.horario.enumeradores.RegimeLetivo;

@Entity
@Table(name = "modalidadecurso", schema = "academico")
public class ModalidadeCurso {

	public ModalidadeCurso() {

	}

	@Id	
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name="SEQ_MODALIDADE_CURSO", schema="academico", sequenceName="SEQ_MODALIDADE_CURSO_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_MODALIDADE_CURSO")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Enumerated
	@Column(name = "idregimeletivo")
	private RegimeLetivo idregimeletivo;

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
	
	public RegimeLetivo getIdregimeletivo() {
		return idregimeletivo;
	}

	public void setIdregimeletivo(RegimeLetivo idregimeletivo) {
		this.idregimeletivo = idregimeletivo;
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
				+ ((idregimeletivo == null) ? 0 : idregimeletivo.hashCode());
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
		ModalidadeCurso other = (ModalidadeCurso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idregimeletivo != other.idregimeletivo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
