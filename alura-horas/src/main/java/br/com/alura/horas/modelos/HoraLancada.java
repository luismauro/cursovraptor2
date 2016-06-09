package br.com.alura.horas.modelos;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HoraLancada {

	@Id
	@SequenceGenerator(name="horaLancada_idhoraLancada_seq",
    sequenceName="horaLancada_idhoraLancada_seq",
    allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator="horaLancada_idhoraLancada_seq")
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	private String horaInicial;
	
	private String horaFinal;
	
	@ManyToOne
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
