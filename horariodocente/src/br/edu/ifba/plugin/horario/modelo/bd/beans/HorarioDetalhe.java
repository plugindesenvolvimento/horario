package br.edu.ifba.plugin.horario.modelo.bd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.edu.ifba.plugin.horario.enumeradores.DiaSemana;
import br.edu.ifba.plugin.horario.enumeradores.Horario;

@Entity
@Table(name = "horariodetalhe", schema = "academico")
public class HorarioDetalhe {

	public HorarioDetalhe() {

	}

	@Id
	@SequenceGenerator(name="SEQ_HORARIO_DETALHE", schema = "academico", sequenceName="SEQ_HORARIO_DETALHE_ID", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_HORARIO_DETALHE")
	@Column(name = "id", nullable = false)
	private Integer id;

	@Enumerated
	@Column(name = "iddiasemana", nullable = false)
	private DiaSemana iddiasemana;

	@Enumerated
	@Column(name = "idhorario", nullable = false)
	private Horario idhorario;

	@ManyToOne
	@Column(name = "iddisciplinashorario", nullable = false)
	private DisciplinasHorario iddisciplinashorario;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DiaSemana getIddiasemana() {
		return iddiasemana;
	}

	public void setIddiasemana(DiaSemana iddiasemana) {
		this.iddiasemana = iddiasemana;
	}

	public Horario getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(Horario idhorario) {
		this.idhorario = idhorario;
	}
	
	public DisciplinasHorario getIddisciplinashorario() {
		return iddisciplinashorario;
	}

	public void setIddisciplinashorario(DisciplinasHorario iddisciplinashorario) {
		this.iddisciplinashorario = iddisciplinashorario;
	}
	
	@Override
	public String toString() {
		return "HorarioDetalhe [id=" + id + ", iddiasemana=" + iddiasemana
				+ ", idhorario=" + idhorario + ", iddisciplinashorario="
				+ iddisciplinashorario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((iddiasemana == null) ? 0 : iddiasemana.hashCode());
		result = prime
				* result
				+ ((iddisciplinashorario == null) ? 0 : iddisciplinashorario
						.hashCode());
		result = prime * result
				+ ((idhorario == null) ? 0 : idhorario.hashCode());
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
		HorarioDetalhe other = (HorarioDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (iddiasemana != other.iddiasemana)
			return false;
		if (iddisciplinashorario == null) {
			if (other.iddisciplinashorario != null)
				return false;
		} else if (!iddisciplinashorario.equals(other.iddisciplinashorario))
			return false;
		if (idhorario != other.idhorario)
			return false;
		return true;
	}
	
}
