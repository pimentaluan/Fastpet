package appconsole;

import com.db4o.ObjectContainer;
import modelo.*;

public class Listar {
	public static void main(String[] args) {
		ObjectContainer manager = Util.conectarBanco();

		for (Pet pet : manager.query(Pet.class)) {
			System.out.println(pet);
			for (Servico s : pet.getServicos()) {
				System.out.println("   > " + s);
			}
		}

		Util.desconectar();
	}
}
