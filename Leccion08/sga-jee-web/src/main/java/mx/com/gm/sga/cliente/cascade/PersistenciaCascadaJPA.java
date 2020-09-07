package mx.com.gm.sga.cliente.cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersistenciaCascadaJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 1 Crear nnuevo objeto
        // objeto en estado transitivo
        Persona persona1 = new Persona("Hugo", "Gatel", "hgatrl@mail.com", "6453485642");

        //crear objeto usuario(tiene dependencia con el objeto Persona)
        Usuario usuario1 = new Usuario("Hlopez", "123456", persona1);

        //Paso3. persistimos el objeto usuario solamente
        em.persist(usuario1);

        //paso4. hacemos commit transaccion
        tx.commit();

        //objeto en estado detached
        log.debug("objeto poeristido persona: " + persona1);
        log.debug("objeto poeristido usuario: " + usuario1);
    
        em.close();

    }
}
