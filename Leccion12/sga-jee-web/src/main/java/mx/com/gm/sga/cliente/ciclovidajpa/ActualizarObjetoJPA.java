package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoJPA {
        static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Inicia transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Paso2. Ejecutar SQL select
        //el id debe existir en bd
        Persona persona1 = em.find(Persona.class, 1);
        
        //Paso3. termina la transaccion
        tx.commit();
        
        //objeto en estado detache
        log.debug("Objeto recuperado" + persona1);
        
        //Paso4, setvalue para modificar un campo
        persona1.setApellido("Juarez");
        
        //Paso5. iniciamos transacion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();

        //Modificamos el objeto
        em.merge(persona1);
        
        //Paso7 Terminamos transaccion 2
        tx2.commit();
        
        //Objeto en estado detache
        log.debug("Objeto recuperado " +persona1);
        //Cerramos el entity manager
        em.close();

    }
}
