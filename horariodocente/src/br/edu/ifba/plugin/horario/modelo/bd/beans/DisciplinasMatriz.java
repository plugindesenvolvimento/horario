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

import br.edu.ifba.plugin.horario.enumeradores.GrupoCurricular;

@Entity
@Table(name = "disciplinasmatriz", schema = "academico")
public class DisciplinasMatriz {

	public DisciplinasMatriz() {
	}

	@Id
	@SequenceGenerator(name = "SEQ_DISCIPLINAS_MATRIZ", schema = "academico",sequenceName = "SEQ_DISCIPLINAS_MATRIZ_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DISCIPLINAS_MATRIZ")
	@Column(name = "id", nullable = false)
	private Integer id;

	@Enumerated
	@Column(name = "idgrupocurricular")
	private GrupoCurricular idgrupocurricular;

	@ManyToOne
	@JoinColumn(name = "iddisciplina")
	private Disciplina iddisciplina;

	@ManyToOne
	@JoinColumn(name = "idmatriz")
	private Matriz idmatriz;

	@Column(name = "nrperiodo")
	private Integer nrperiodo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Disciplina getIddisciplina() {
		return iddisciplina;
	}

	public void setIddisciplina(Disciplina iddisciplina) {
		this.iddisciplina = iddisciplina;
	}

	public void setIdmatriz(Matriz idmatriz) {
		this.idmatriz = idmatriz;
	}

	public GrupoCurricular getIdgrupocurricular() {
		return idgrupocurricular;
	}

	public void setIdgrupocurricular(GrupoCurricular idgrupocurricular) {
		this.idgrupocurricular = idgrupocurricular;
	}

	public Matriz getIdmatriz() {
		return idmatriz;
	}

	public Integer getNrperiodo() {
		return nrperiodo;
	}

	public void setNrperiodo(Integer nrperiodo) {
		this.nrperiodo = nrperiodo;
	}

	@Override
	public String toString() {
		return "DisciplinasMatriz [id=" + id + ", idgrupocurricular="
				+ idgrupocurricular + ", iddisciplina=" + iddisciplina
				+ ", idmatriz=" + idmatriz + ", nrperiodo=" + nrperiodo + "]";
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
		DisciplinasMatriz other = (DisciplinasMatriz) obj;
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
