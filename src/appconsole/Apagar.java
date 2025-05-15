package appconsole;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import modelo.*;

public class Apagar {
	public static void main(String[] args) {
		ObjectContainer manager = Util.conectarBanco();

		var resultado = manager.query(new Predicate<Pet>() {
			public boolean match(Pet p) {
				return p.getApelido().equalsIgnoreCase("Mimi");
			}
		});

		if (!resultado.isEmpty()) {
			manager.delete(resultado.next());
			manager.commit();
			System.out.println("pet apagado");
		} else {
			System.out.println("pet não encontrado");
		}

		Util.desconectar();
	}
}
