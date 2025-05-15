package appconsole;

import com.db4o.ObjectContainer;
import modelo.*;

public class Cadastrar {
	private static ObjectContainer manager;

	public static void main(String[] args) {
		manager = Util.conectarBanco();

		Tutor t1 = new Tutor("11111111111", "José", "83990000001");
		Tutor t2 = new Tutor("22222222222", "Maria", "83990000002");

		Pet p1 = new Pet("Rex", t1, "Labrador");
		Pet p2 = new Pet("Mimi", t2, "Persa");

		p1.adicionarServico(new Servico(p1.getApelido(), t1.getNome(), "banho"));
		p2.adicionarServico(new Servico(p2.getApelido(), t2.getNome(), "banho"));
		p2.adicionarServico(new Servico(p2.getApelido(), t2.getNome(), "tosa"));

		manager.store(p1);
		manager.store(p2);

		manager.commit();
		Util.desconectar();
		System.out.println("cadastrou os pets com seus tutores e serviços");
	}
}
