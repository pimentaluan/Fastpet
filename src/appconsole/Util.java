package appconsole;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

import modelo.Servico;
import modelo.Pet;
import modelo.Tutor;

public class Util {
	private static ObjectContainer manager;

	public static ObjectContainer conectarBanco(){
		if (manager != null)
			return manager;

		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);
		
		config.common().objectClass(Tutor.class).cascadeOnDelete(false);;
		config.common().objectClass(Tutor.class).cascadeOnUpdate(true);;
		config.common().objectClass(Tutor.class).cascadeOnActivate(true);
		config.common().objectClass(Servico.class).cascadeOnDelete(false);;
		config.common().objectClass(Servico.class).cascadeOnUpdate(true);;
		config.common().objectClass(Servico.class).cascadeOnActivate(true);
		config.common().objectClass(Pet.class).cascadeOnDelete(false);;
		config.common().objectClass(Pet.class).cascadeOnUpdate(true);;
		config.common().objectClass(Pet.class).cascadeOnActivate(true);
		manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
	}
	
	public static void desconectar() {
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}
}
