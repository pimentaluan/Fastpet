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
			Pet mimi = resultado.next();

			for (Servico s : mimi.getServicos()) {
				manager.delete(s);
			}

			manager.delete(mimi);
			manager.commit();
			System.out.println("pet e serviços relacionados apagados");
		} else {
			System.out.println("pet não encontrado");
		}

		Util.desconectar();
	}
}
