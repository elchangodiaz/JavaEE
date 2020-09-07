package testclientews;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWS;
import java.util.List;

public class TestPersonaServiceWS {
    public static void main(String[] args) {
        PersonaServiceWS personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        
        System.out.println("Ejecutando servicio listar personas ws");
        List<Persona> personas = personaService.listarPersonas();
        for(Persona persona:personas){
            System.out.println("Persona idPersona: " + persona.getIdPersona() + ", nombre: " + persona.getNombre()
            + ", Apellido: " + persona.getApellido() + ", Email: " + persona.getEmail());
        }
        
        System.out.println("Fin Servicio listar personas");
    }
}
