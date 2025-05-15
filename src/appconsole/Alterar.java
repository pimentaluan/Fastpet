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
			rex.adicionarServico(new Servico(rex.getApelido(), rex.getTutor().getNome(), "tosa"));
			manager.store(rex);
			manager.commit();
			System.out.println("serviço de tosa adicionado a Rex");
		} else {
			System.out.println("pet não encontrado");
		}

		Util.desconectar();
	}
}
