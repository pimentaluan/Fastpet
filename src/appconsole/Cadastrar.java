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
		Pet p3 = new Pet("Miau", t3, "Siames");
		Pet p4 = new Pet("Bolt", t1, "Golden");
		Pet p5 = new Pet("Luna", t2, "Poodle");
		Pet p6 = new Pet("Thor", t1, "Labrador");

		Servico s1 = new Servico("15/05/2025 08:00", p1, "banho");
		Servico s2 = new Servico("15/05/2025 09:00", p1, "tosa");
		Servico s3 = new Servico("14/05/2025 08:30", p2, "banho");
		Servico s4 = new Servico("15/05/2025 10:00", p2, "vacina");
		Servico s5 = new Servico("15/05/2025 11:00", p3, "hospedagem");
		Servico s6 = new Servico("15/05/2025 08:00", p4, "consulta");
		Servico s7 = new Servico("15/05/2025 09:30", p5, "banho");
		Servico s8 = new Servico("15/05/2025 09:30", p3, "banho");
		

		manager.store(s1);
		manager.store(s2);
		manager.store(s3);
		manager.store(s4);
		manager.store(s5);
		manager.store(s6);
		manager.store(s7);
		manager.store(s8);
		manager.store(p6);
	
		manager.commit();
		Util.desconectar();
		System.out.println("Cadastrou pets, tutores e agendamentos de serviços.");
	}
}
