package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pet {
	private String apelido;
	private Tutor tutor;
	private String raca;
	private List<Servico> servicos = new ArrayList<>();

	public Pet(String apelido, Tutor tutor, String raca) {
		this.apelido = apelido;
		this.tutor = tutor;
		this.raca = raca;
	}

	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}

	public List<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public void adicionarServico(Servico s) {
		this.servicos.add(s);
	}

	public int getQuantidadeServicos() {
		return this.servicos.size();
	}

	@Override
	public String toString() {
		return apelido + " (" + raca + ") - Tutor: " + tutor.getNome() + ", Serviços: " + getQuantidadeServicos();
	}
}
