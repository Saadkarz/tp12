package ma.projet.client;

import ma.projet.api.HelloService;
import ma.projet.model.Person;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;

/**
 * Client Java pour consommer le service SOAP HelloService.
 * Utilise l'API standard JAX-WS pour créer un proxy dynamique.
 */
public class ClientDemo {
    public static void main(String[] args) {
        try {
            System.out.println("========================================");
            System.out.println("Client SOAP - Démonstration");
            System.out.println("========================================");
            
            // Connexion au service via le WSDL
            URL wsdl = new URL("http://localhost:8080/services/hello?wsdl");
            QName qname = new QName("http://api.projet.ma/", "HelloService");
            
            Service service = Service.create(wsdl, qname);
            HelloService port = service.getPort(HelloService.class);

            // Test 1: SayHello
            System.out.println("\n--- Test 1: SayHello ---");
            String greeting = port.sayHello("ClientJava");
            System.out.println("Réponse: " + greeting);

            // Test 2: FindPerson
            System.out.println("\n--- Test 2: FindPerson ---");
            Person person = port.findPersonById("P-777");
            System.out.println("Personne trouvée:");
            System.out.println("  ID: " + person.getId());
            System.out.println("  Nom: " + person.getName());
            System.out.println("  Âge: " + person.getAge());

            // Test 3: SayHello avec nom null
            System.out.println("\n--- Test 3: SayHello avec nom null ---");
            String greeting2 = port.sayHello(null);
            System.out.println("Réponse: " + greeting2);

            System.out.println("\n========================================");
            System.out.println("Tous les tests ont réussi!");
            System.out.println("========================================");

        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel du service:");
            System.err.println("  Message: " + e.getMessage());
            System.err.println("\nAssurez-vous que le serveur est démarré (Server.java)");
            e.printStackTrace();
        }
    }
}

