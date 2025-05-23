package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import modelo.Pet;
import modelo.Servico;

public class Alterar {
    private static ObjectContainer manager;

    public static void main(String[] args) {
        manager = Util.conectarBanco();

        System.out.println("Alteração: remover e adicionar relacionamento de um Pet");

        Query q = manager.query();
        q.constrain(Pet.class);
        q.descend("apelido").constrain("Rex");
        List<Pet> resultado = q.execute();

        if (!resultado.isEmpty()) {
            Pet rex = resultado.get(0);

            if (!rex.getServicos().isEmpty()) {
                Servico removido = rex.getServicos().removeLast();
                manager.delete(removido);
                manager.store(rex);
                System.out.println("Último serviço removido: " + removido.getTipo() + " em " + removido.getDatahora());
            } else {
                System.out.println("Pet não possui serviços para remover.");
            }

            Servico novoServico = new Servico("20/05/2025 14:00", rex, "vacina");
            manager.store(novoServico);
            manager.store(rex);
            System.out.println("Novo serviço adicionado: " + novoServico.getTipo() + " em " + novoServico.getDatahora());

            manager.commit();
        } else {
            System.out.println("Pet não encontrado.");
        }

        Util.desconectar();
    }
}
