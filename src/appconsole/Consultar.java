package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Pet;
import modelo.Tutor;
import modelo.Servico;

public class Consultar {
    private ObjectContainer manager;

    public Consultar() {
            manager = Util.conectarBanco();
            consultar();
            Util.desconectar();
    }

    public void consultar() {
        List<Pet> pets;
        List<Tutor> tutores;
        List<Servico> servicos;
        Query q;

        System.out.println("\n--- Quais os Pets de raça Labrador");
        q = manager.query();
        q.constrain(Pet.class);
        q.descend("raca").constrain("Labrador");
        pets = q.execute();

        for (Pet pet : pets) {
            System.out.println(pet.getApelido() + " - " + pet.getRaca());
        }

        System.out.println("\n--- Quais pets banharam na data 15/05/2025");
        Filtro1 filtro1 = new Filtro1("15/05/2025", "banho");

        q = manager.query();
        q.constrain(Servico.class);
        q.constrain(filtro1);
        servicos = q.execute();

        for (Servico servico : servicos) {
            System.out.println(servico.getPet().getApelido() + " - " + servico.getDatahora());
        }

        System.out.println("\n--- Listar pets contendo mais de 1 servico");
        Filtro2 filtro2 = new Filtro2(1);

        q = manager.query();
        q.constrain(Pet.class);
        q.constrain(filtro2);
        pets = q.execute();

        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    public static void main(String[] args) {
        new Consultar();
    }
}

class Filtro1 implements Evaluation {
    private String dataDesejada;
    private String tipoDesejado;

    public Filtro1(String dataDesejada, String tipoDesejado) {
        this.dataDesejada = dataDesejada;
        this.tipoDesejado = tipoDesejado;
    }

    public void evaluate(Candidate candidate) {
        Servico servico = (Servico) candidate.getObject();
        if (servico.getDatahora().startsWith(dataDesejada) && servico.getTipo().equals(tipoDesejado)) {
            candidate.include(true);
        } else {
            candidate.include(false);
        }
    }
}

class Filtro2 implements Evaluation {
    private int n;

    public Filtro2(int n) {
        this.n = n;
    }

    public void evaluate(Candidate candidate) {
        Pet pet = (Pet) candidate.getObject();
        if (pet.getServicos().size() > n) {
            candidate.include(true);
        } else {
            candidate.include(false);
        }
    }
}
