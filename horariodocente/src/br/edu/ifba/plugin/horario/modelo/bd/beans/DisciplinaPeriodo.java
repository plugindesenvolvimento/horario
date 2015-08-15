package br.edu.ifba.plugin.horario.modelo.bd.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.edu.ifba.plugin.horario.enumeradores.GrupoCurricular;

@Entity
@Table(name = "disciplinaperiodo", schema = "academico")
public class DisciplinaPeriodo {

	public DisciplinaPeriodo() {
	}

	@Id
	@SequenceGenerator(name = "SEQ_DISCIPLINA_PERIODO", schema = "academico",sequenceName = "SEQ_DISCIPLINA_PERIODO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DISCIPLINA_PERIODO")
	@Column(name = "id", nullable = false)
	private Integer id;

	@Enumerated
	@Column(name = "idgrupocurricular", nullable = false)
	private GrupoCurricular idgrupocurricular;

	@ManyToMany
	@JoinColumn(name = "iddisciplina", nullable = false)
	private List<Disciplina> iddisciplina;

	@ManyToMany
	@JoinColumn(name = "idperiodo", nullable = false)
	private List<Periodo> idperiodo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Disciplina> getIddisciplina() {
		return iddisciplina;
	}

	public void setIddisciplina(List<Disciplina> iddisciplina) {
		this.iddisciplina = iddisciplina;
	}

	public List<Periodo> getIdperiodo() {
		return idperiodo;
	}

	public void setIdperiodo(List<Periodo> idperiodo) {
		this.idperiodo = idperiodo;
	}

	public GrupoCurricular getIdgrupocurricular() {
		return idgrupocurricular;
	}

	public void setIdgrupocurricular(GrupoCurricular idgrupocurricular) {
		this.idgrupocurricular = idgrupocurricular;
	}

	@Override
	public String toString() {
		return "DisciplinaPeriodo [grupoCurricularPeriodo=" + idgrupocurricular
				+ ", idPeriodo=" + idperiodo + ", idDisciplina=" + iddisciplina
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((iddisciplina == null) ? 0 : iddisciplina.hashCode());
		result = prime
				* result
				+ ((idgrupocurricular == null) ? 0 : idgrupocurricular
						.hashCode());
		result = prime * result
				+ ((idperiodo == null) ? 0 : idperiodo.hashCode());
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
		DisciplinaPeriodo other = (DisciplinaPeriodo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (iddisciplina == null) {
			if (other.iddisciplina != null)
				return false;
		} else if (!iddisciplina.equals(other.iddisciplina))
			return false;
		if (idgrupocurricular != other.idgrupocurricular)
			return false;
		if (idperiodo == null) {
			if (other.idperiodo != null)
				return false;
		} else if (!idperiodo.equals(other.idperiodo))
			return false;
		return true;
	}
}
