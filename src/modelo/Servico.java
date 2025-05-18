package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Servico {
	private String datahora;
	private Pet pet;
	private String tipo;

	public Servico() {}

	public Servico(String datahora ,Pet pet ,String tipo) {
		this.datahora = datahora;
		this.pet = pet;
		this.pet.adicionarServico(this);
		this.tipo = tipo;
		
	}

	public String getDatahora() {
		return datahora;
	}
	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}
	
	public Pet getPet() {
		return this.pet;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return tipo + " em " + datahora + " - Pet: " + this.pet.getApelido() + "Tutor: " + this.pet.getTutor().getNome();
	}
}
