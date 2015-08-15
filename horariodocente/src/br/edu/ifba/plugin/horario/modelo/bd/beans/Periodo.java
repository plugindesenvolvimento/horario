package br.edu.ifba.plugin.horario.modelo.bd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "periodo", schema = "academico")
public class Periodo {

	public Periodo() {
	}

	@Id
	@SequenceGenerator(name="SEQ_PERIODO", schema = "academico", sequenceName="SEQ_PERIODO_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_PERIODO")
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "nrperiodo", nullable = false)
	private Integer nrperiodo;

	@ManyToOne
	@JoinColumn(name = "idmatriz", nullable = false)
	private Matriz idmatriz;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SemestreAno [nrPeriodo=" + nrperiodo + ", idMatriz="
				+ idmatriz + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idmatriz == null) ? 0 : idmatriz.hashCode());
		result = prime * result
				+ ((nrperiodo == null) ? 0 : nrperiodo.hashCode());
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
		Periodo other = (Periodo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idmatriz == null) {
			if (other.idmatriz != null)
				return false;
		} else if (!idmatriz.equals(other.idmatriz))
			return false;
		if (nrperiodo == null) {
			if (other.nrperiodo != null)
				return false;
		} else if (!nrperiodo.equals(other.nrperiodo))
			return false;
		return true;
	}
}
