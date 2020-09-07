package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetosSesionLarga {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Inicia transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2. Ejecutamos SQL Select
        Persona persona1 = em.find(Persona.class, 1);

        log.debug("Objeto reuperado " + persona1);

        //Paso3. set Value(nuevoValor
        persona1.setEmail("jjuarez@mail.com");

        persona1.setEmail("j.juarez@mail.com");

        //Paso4. termina transaccion
        tx.commit();
        
        //Objeto estado detached
        log.debug("objeto modificado " + persona1);
        
        //Cerramos el entity manager
        em.close();

    }
}
