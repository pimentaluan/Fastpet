package appconsole;

import com.db4o.ObjectContainer;
import modelo.*;

public class Cadastrar {
	private static ObjectContainer manager;

	public static void main(String[] args) {
		manager = Util.conectarBanco();

		Tutor t1 = new Tutor("11111111111", "José", "83990000001");
		Tutor t2 = new Tutor("22222222222", "Maria", "83990000002");
		Tutor t3 = new Tutor("33333333333", "Pedro", "83990000003");
		
		

		Pet p1 = new Pet("Rex", t1, "Labrador");
		Pet p2 = new Pet("Mimi", t2, "Persa");
		Pet p3 = new Pet("Miau", t3, "Persa");

		Servico s1 = new Servico("", p1, "banho");
		Servico s2 = new Servico("", p1, "tosa");
		Servico s3 = new Servico("", p2, "banho");
		Servico s4 = new Servico("", p3, "hospedagem");
		
	
		
		manager.store(s1);
		manager.store(s2);
		manager.store(s3);
		manager.store(s4);

		manager.commit();
		Util.desconectar();
		System.out.println("cadastrou os pets com seus tutores e serviços");
	}
}
