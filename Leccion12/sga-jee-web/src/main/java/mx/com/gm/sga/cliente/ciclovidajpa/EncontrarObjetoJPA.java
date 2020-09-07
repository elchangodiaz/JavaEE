package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncontrarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Inicia transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //P{aso 2 ejecutar sql select
        Persona persona1 = em.find(Persona.class, 12);
     
        //Paso 3 temina la transaccion
        tx.commit();
        
        //opbjeto estadp detached
        log.debug("Objeto recuperado" + persona1);
        //Cerramos el entity manager
        em.close();

    }
}
