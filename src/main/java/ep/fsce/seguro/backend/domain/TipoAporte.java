package ep.fsce.seguro.backend.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TW_TIPO_APORTE")
public class TipoAporte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TIP_APA")
	private String tipApa;

	@Column(name = "DESC_APA")
	private String descApa;
	
	@OneToMany(mappedBy = "tipApa")
	@JsonIgnore
	private List<AporteFscec> aporteFscec; 

	public String getTipApa() {
		return tipApa;
	}

	public void setTipApa(String tipApa) {
		this.tipApa = tipApa;
	}

	public String getDescApa() {
		return descApa;
	}

	public void setDescApa(String descApa) {
		this.descApa = descApa;
	}

}
