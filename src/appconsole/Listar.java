package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Pet;
import modelo.Tutor;
import modelo.Servico;

public class Listar {
	private static ObjectContainer manager;

	public static void main(String[] args) {
		manager = Util.conectarBanco();

		System.out.println("\nListar todos os Pets:");
		Query q = manager.query();
		q.constrain(Pet.class);
		List<Pet> empregados = q.execute();
		empregados.stream().forEach(item -> System.out.println(item));

		System.out.println("\nListar todos os Tutores:");
		q = manager.query();
		q.constrain(Tutor.class);
		List<Tutor> gerentes = q.execute();
		gerentes.stream().forEach(item -> System.out.println(item));

		System.out.println("\nListar todos os serviços:");
		q = manager.query();
		q.constrain(Servico.class);
		List<Servico> lojas = q.execute();
		lojas.stream().forEach(item -> System.out.println(item));
		
		Util.desconectar();
	}

}
