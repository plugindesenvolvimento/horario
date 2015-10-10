package br.edu.ifba.plugin.horario.modelo.bd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.edu.ifba.plugin.horario.enumeradores.Turno;

@Entity
@Table(name = "horarioturma", schema = "academico")
public class HorarioTurma {

	public HorarioTurma() {

	}

	@Id
	@SequenceGenerator(name = "SEQ_HORARIO_TURMA", schema = "academico", 
					   sequenceName = "SEQ_HORARIO_TURMA_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HORARIO_TURMA")
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idcurso")
	private Curso idcurso;

	@ManyToOne
	@JoinColumn(name = "idperiodoletivo")
	private PeriodoLetivo idperiodoletivo;

	@Enumerated
	@Column(name = "idturno")
	private Turno idturno;

	@Column(name = "nrperiodo")
	private Integer nrperiodo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Curso idcurso) {
		this.idcurso = idcurso;
	}

	public PeriodoLetivo getIdperiodoletivo() {
		return idperiodoletivo;
	}

	public void setIdperiodoletivo(PeriodoLetivo idperiodoletivo) {
		this.idperiodoletivo = idperiodoletivo;
	}

	public Turno getIdturno() {
		return idturno;
	}

	public void setIdturno(Turno idturno) {
		this.idturno = idturno;
	}

	public Integer getNrperiodo() {
		return nrperiodo;
	}

	public void setNrperiodo(Integer nrperiodo) {
		this.nrperiodo = nrperiodo;
	}

	@Override
	public String toString() {
		return "HorarioTurma [id=" + id + ", idcurso=" + idcurso
				+ ", idperiodoletivo=" + idperiodoletivo + ", idturno="
				+ idturno + ", nrperiodo=" + nrperiodo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idcurso == null) ? 0 : idcurso.hashCode());
		result = prime * result
				+ ((idperiodoletivo == null) ? 0 : idperiodoletivo.hashCode());
		result = prime * result + ((idturno == null) ? 0 : idturno.hashCode());
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
		HorarioTurma other = (HorarioTurma) obj;
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
		if (idperiodoletivo == null) {
			if (other.idperiodoletivo != null)
				return false;
		} else if (!idperiodoletivo.equals(other.idperiodoletivo))
			return false;
		if (idturno != other.idturno)
			return false;
		if (nrperiodo == null) {
			if (other.nrperiodo != null)
				return false;
		} else if (!nrperiodo.equals(other.nrperiodo))
			return false;
		return true;
	}

}
