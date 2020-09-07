package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EliminarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Inicia transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso2. Ejecutamos SQL select
        Persona persona1 = em.find(Persona.class, 13);

        //Paspo3. termina transaccion 1
        tx.commit();

        //objeto en estado detacved
        log.debug("objeto encontrado: " + persona1);

        //Paso4. inicia transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();

        //Paso5. Ejecuta SQL que es un delete
        em.remove(em.merge(persona1));

        //Paso 6. cerramos transaccion 2
        tx2.commit();
        
        //Objeto en estado detached ya eliminado en la bd
        log.debug("objeto Eliminado " + persona1);

        //cerramos el entiti mayor
        em.close();

    }
}
