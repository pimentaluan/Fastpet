package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Pet;
import modelo.Servico;

public class Apagar {
    public static void main(String[] args) {
        ObjectContainer manager = Util.conectarBanco();

        System.out.println("Apagar o pet Mimi e seus serviços relacionados");

        Query q = manager.query();
        q.constrain(Pet.class);
        q.descend("apelido").constrain("Mimi");
        List<Pet> resultado = q.execute();

        if (!resultado.isEmpty()) {
            Pet mimi = resultado.get(0);

            for (Servico s : mimi.getServicos()) {
                manager.delete(s);
            }

            manager.delete(mimi);
            manager.commit();
            System.out.println("Pet e serviços relacionados apagados com sucesso.");
        } else {
            System.out.println("Pet não encontrado.");
        }

        Util.desconectar();
    }
}
