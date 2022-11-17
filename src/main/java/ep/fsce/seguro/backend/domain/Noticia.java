package ep.fsce.seguro.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TW_NOTICIA")
public class Noticia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String autor;
	private String coAutor;
	private String fuente;
	private Date fechPubl;
	private String img1;
	private String img2;
	private String parrafo1;
	private String parrafo2;
	private String parrafo3;
	private String parrafo4;
	private String parrafo5;
	private String parrafo6;
	@Column(name = "FECHA_REGISTRO")
	private Date fechRegis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCoAutor() {
		return coAutor;
	}

	public void setCoAutor(String coAutor) {
		this.coAutor = coAutor;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public Date getFechPubl() {
		return fechPubl;
	}

	public void setFechPubl(Date fechPubl) {
		this.fechPubl = fechPubl;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getParrafo1() {
		return parrafo1;
	}

	public void setParrafo1(String parrafo1) {
		this.parrafo1 = parrafo1;
	}

	public String getParrafo2() {
		return parrafo2;
	}

	public void setParrafo2(String parrafo2) {
		this.parrafo2 = parrafo2;
	}

	public String getParrafo3() {
		return parrafo3;
	}

	public void setParrafo3(String parrafo3) {
		this.parrafo3 = parrafo3;
	}

	public String getParrafo4() {
		return parrafo4;
	}

	public void setParrafo4(String parrafo4) {
		this.parrafo4 = parrafo4;
	}

	public String getParrafo5() {
		return parrafo5;
	}

	public void setParrafo5(String parrafo5) {
		this.parrafo5 = parrafo5;
	}

	public String getParrafo6() {
		return parrafo6;
	}

	public void setParrafo6(String parrafo6) {
		this.parrafo6 = parrafo6;
	}

	public Date getFechRegis() {
		return fechRegis;
	}

	public void setFechRegis(Date fechRegis) {
		this.fechRegis = fechRegis;
	}

}
