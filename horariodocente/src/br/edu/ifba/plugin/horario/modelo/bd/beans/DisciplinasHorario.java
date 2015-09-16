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
@Table(name = "disciplinashorario", schema = "academico")
public class DisciplinasHorario {

	public DisciplinasHorario() {
	}

	@Id
	@SequenceGenerator(name = "SEQ_DISCIPLINAS_HORARIO", schema = "academico", sequenceName = "SEQ_DISCIPLINAS_HORARIO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DISCIPLINAS_HORARIO")
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idhorarioturma")
	private HorarioTurma idhorarioturma;

	@ManyToOne
	@JoinColumn(name = "iddisciplina")
	private Disciplina iddisciplina;

	@ManyToOne
	@JoinColumn(name = "idservidor")
	private Servidor idservidor;

	@ManyToOne
	@JoinColumn(name = "idsala")
	private Sala idsala;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HorarioTurma getIdhorarioturma() {
		return idhorarioturma;
	}

	public void setIdhorarioturma(HorarioTurma idhorarioturma) {
		this.idhorarioturma = idhorarioturma;
	}

	public Disciplina getIddisciplina() {
		return iddisciplina;
	}

	public void setIddisciplina(Disciplina iddisciplina) {
		this.iddisciplina = iddisciplina;
	}

	public Servidor getIdservidor() {
		return idservidor;
	}

	public void setIdservidor(Servidor idservidor) {
		this.idservidor = idservidor;
	}

	public Sala getIdsala() {
		return idsala;
	}

	public void setIdsala(Sala idsala) {
		this.idsala = idsala;
	}

	@Override
	public String toString() {
		return "DisciplinaProfessor [idHorarioTurma=" + idhorarioturma
				+ ", idDisciplina=" + iddisciplina + ", idServidor="
				+ idservidor + ", idSala=" + idsala + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((iddisciplina == null) ? 0 : iddisciplina.hashCode());
		result = prime * result
				+ ((idhorarioturma == null) ? 0 : idhorarioturma.hashCode());
		result = prime * result + ((idsala == null) ? 0 : idsala.hashCode());
		result = prime * result
				+ ((idservidor == null) ? 0 : idservidor.hashCode());
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
		DisciplinasHorario other = (DisciplinasHorario) obj;
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
		if (idhorarioturma == null) {
			if (other.idhorarioturma != null)
				return false;
		} else if (!idhorarioturma.equals(other.idhorarioturma))
			return false;
		if (idsala == null) {
			if (other.idsala != null)
				return false;
		} else if (!idsala.equals(other.idsala))
			return false;
		if (idservidor == null) {
			if (other.idservidor != null)
				return false;
		} else if (!idservidor.equals(other.idservidor))
			return false;
		return true;
	}
}
