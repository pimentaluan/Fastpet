package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Servico {
	private String datahora;
	private String apelido;
	private String tutor;
	private String tipo;

	public Servico() {}

	public Servico(String apelido, String tutor, String tipo) {
		this.datahora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		this.apelido = apelido;
		this.tutor = tutor;
		this.tipo = tipo;
	}

	public String getDatahora() {
		return datahora;
	}
	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}

	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return tipo + " em " + datahora + " - Pet: " + apelido;
	}
}
