package br.com.alura.horas.modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

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
	
	@NotNull(message="Nao pode ser nulo") @NotEmpty(message="Nao pode ser vazio")
	private String horaInicial;
	
	@NotNull(message="Nao pode ser nulo") @NotEmpty(message="Nao pode ser vazio")
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


	
	public double getDuracao(){
	    try {
	        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	        Date fim = format.parse(horaFinal);
	        Date inicio = format.parse(horaInicial);
	        long millis = fim.getTime() - inicio.getTime();
	        return millis / (1000.0 * 60.0 * 60.0);
	    } catch (ParseException e) {
	        return 0;
	    }
	}
	
}
