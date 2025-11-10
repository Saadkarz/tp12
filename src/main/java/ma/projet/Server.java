package ma.projet;

import ma.projet.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {
    public static void main(String[] args) {
        String address = "http://localhost:8080/services/hello";
        
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloServiceImpl.class);
        factory.setAddress(address);
        factory.create();
        
        System.out.println("========================================");
        System.out.println("Service SOAP démarré avec succès!");
        System.out.println("WSDL disponible à: " + address + "?wsdl");
        System.out.println("========================================");
        System.out.println("Opérations disponibles:");
        System.out.println("  - SayHello");
        System.out.println("  - FindPerson");
        System.out.println("========================================");
        System.out.println("Appuyez sur Ctrl+C pour arrêter le serveur");
    }
}

