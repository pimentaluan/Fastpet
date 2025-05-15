package appconsole;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;
import modelo.*;

public class Consultar {
	public static void main(String[] args) {
		ObjectContainer manager = Util.conectarBanco();

		Query q1 = manager.query();
		q1.constrain(Pet.class);
		q1.descend("raca").constrain("Labrador");
		for (Object p : q1.execute()) {
			System.out.println(p);
		}

		for (Pet p : manager.query(Pet.class)) {
			for (Servico s : p.getServicos()) {
				if (s.getTipo().equalsIgnoreCase("banho") && s.getDatahora().startsWith("10/05/2025")) {
					System.out.println(p);
					break;
				}
			}
		}

		for (Pet p : manager.query(Pet.class)) {
			if (p.getQuantidadeServicos() > 1) {
				System.out.println(p);
			}
		}

		Util.desconectar();
	}
}
