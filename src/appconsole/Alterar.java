package appconsole;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import modelo.*;

public class Alterar {
	public static void main(String[] args) {
		ObjectContainer manager = Util.conectarBanco();

		var resultado = manager.query(new Predicate<Pet>() {
			public boolean match(Pet p) {
				return p.getApelido().equalsIgnoreCase("Rex");
			}
		});

		if (!resultado.isEmpty()) {
			Pet rex = resultado.next();

			String datahora = "16/05/2025 10:00";
			new Servico(datahora, rex, "tosa");

			manager.store(rex);
			manager.commit();
			System.out.println("serviço de tosa agendado para Rex em " + datahora);
		} else {
			System.out.println("pet não encontrado");
		}

		Util.desconectar();
	}
}
