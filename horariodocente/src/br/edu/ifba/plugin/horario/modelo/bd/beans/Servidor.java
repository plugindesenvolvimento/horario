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
@Table(name = "servidor", schema = "administrativo")
public class Servidor {

	public Servidor() {

	}

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = "SEQ_SERVIDOR", schema = "administrativo", sequenceName = "SEQ_SERVIDOR_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SERVIDOR")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "siape", nullable = false)
	private String siape;

	@ManyToOne
	@JoinColumn(name = "idpessoa", nullable = false)
	private Pessoa idpessoa;

	@ManyToOne
	@JoinColumn(name = "idcargo", nullable = false)
	private Cargo idcargo;

	@Column(name = "cargahoraria", nullable = false)
	private Integer cargahoraria;

	@ManyToOne
	@JoinColumn(name = "idsetor", nullable = false)
	private Setor idsetor;

	@ManyToOne
	@JoinColumn(name = "idarea", nullable = false)
	private Area idarea;

	@ManyToOne
	@JoinColumn(name = "idcargocomissionado", nullable = false)
	private Cargo idcargocomissionado;

	public Cargo getIdcargocomissionado() {
		return idcargocomissionado;
	}

	public void setIdcargocomissionado(Cargo idcargocomissionado) {
		this.idcargocomissionado = idcargocomissionado;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public Pessoa getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Pessoa idpessoa) {
		this.idpessoa = idpessoa;
	}

	public Cargo getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(Cargo idcargo) {
		this.idcargo = idcargo;
	}

	public Integer getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(Integer cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	public Setor getIdsetor() {
		return idsetor;
	}

	public void setIdsetor(Setor idsetor) {
		this.idsetor = idsetor;
	}

	public Area getIdarea() {
		return idarea;
	}

	public void setIdarea(Area idarea) {
		this.idarea = idarea;
	}

	@Override
	public String toString() {
		return idpessoa.getNome();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cargahoraria == null) ? 0 : cargahoraria.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idarea == null) ? 0 : idarea.hashCode());
		result = prime * result + ((idcargo == null) ? 0 : idcargo.hashCode());
		result = prime
				* result
				+ ((idcargocomissionado == null) ? 0 : idcargocomissionado
						.hashCode());
		result = prime * result
				+ ((idpessoa == null) ? 0 : idpessoa.hashCode());
		result = prime * result + ((idsetor == null) ? 0 : idsetor.hashCode());
		result = prime * result + ((siape == null) ? 0 : siape.hashCode());
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
		Servidor other = (Servidor) obj;
		if (cargahoraria == null) {
			if (other.cargahoraria != null)
				return false;
		} else if (!cargahoraria.equals(other.cargahoraria))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idarea == null) {
			if (other.idarea != null)
				return false;
		} else if (!idarea.equals(other.idarea))
			return false;
		if (idcargo == null) {
			if (other.idcargo != null)
				return false;
		} else if (!idcargo.equals(other.idcargo))
			return false;
		if (idcargocomissionado == null) {
			if (other.idcargocomissionado != null)
				return false;
		} else if (!idcargocomissionado.equals(other.idcargocomissionado))
			return false;
		if (idpessoa == null) {
			if (other.idpessoa != null)
				return false;
		} else if (!idpessoa.equals(other.idpessoa))
			return false;
		if (idsetor == null) {
			if (other.idsetor != null)
				return false;
		} else if (!idsetor.equals(other.idsetor))
			return false;
		if (siape == null) {
			if (other.siape != null)
				return false;
		} else if (!siape.equals(other.siape))
			return false;
		return true;
	}
}
