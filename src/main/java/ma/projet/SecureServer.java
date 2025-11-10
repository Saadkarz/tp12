package ma.projet;

// import ma.projet.impl.HelloServiceImpl;
// import ma.projet.security.UTPasswordCallback;
// import org.apache.cxf.endpoint.Server;
// import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
// import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
// import java.util.HashMap;
// import java.util.Map;

/**
 * Serveur SOAP sécurisé avec WS-Security (UsernameToken).
 * Requiert un header WS-Security avec username/password pour accéder au service.
 *
 * NOTE: Les dépendances WS-Security doivent être ajoutées au POM pour activer ce serveur:
 * - org.apache.cxf:cxf-rt-ws-security
 * - org.apache.wss4j:wss4j-ws-security-common
 */
public class SecureServer {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("ERREUR: SecureServer nécessite des dépendances WS-Security");
        System.out.println("========================================");
        System.out.println("Pour activer ce serveur, ajoutez au pom.xml:");
        System.out.println();
        System.out.println("<dependency>");
        System.out.println("    <groupId>org.apache.cxf</groupId>");
        System.out.println("    <artifactId>cxf-rt-ws-security</artifactId>");
        System.out.println("    <version>4.0.3</version>");
        System.out.println("</dependency>");
        System.out.println("<dependency>");
        System.out.println("    <groupId>org.apache.wss4j</groupId>");
        System.out.println("    <artifactId>wss4j-ws-security-common</artifactId>");
        System.out.println("    <version>3.0.0</version>");
        System.out.println("</dependency>");
        System.out.println("========================================");
        System.out.println();
        System.out.println("En attendant, utilisez Server.java pour un serveur non sécurisé.");
        System.out.println("========================================");

        /* CODE SÉCURISÉ - À activer après avoir ajouté les dépendances

        import ma.projet.impl.HelloServiceImpl;
        import ma.projet.security.UTPasswordCallback;
        import org.apache.cxf.endpoint.Server;
        import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
        import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
        import java.util.HashMap;
        import java.util.Map;

        // Configuration WS-Security
        Map<String, Object> inProps = new HashMap<>();
        inProps.put("action", "UsernameToken");
        inProps.put("passwordType", "PasswordText");

        // Définir les utilisateurs autorisés (username -> password)
        Map<String, String> users = new HashMap<>();
        users.put("student", "secret123");
        users.put("admin", "admin456");
        inProps.put("passwordCallbackRef", new UTPasswordCallback(users));

        WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);

        // Création du serveur
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloServiceImpl.class);
        factory.setAddress("http://localhost:8080/services/hello-secure");

        Server server = factory.create();
        server.getEndpoint().getInInterceptors().add(wssIn);

        System.out.println("========================================");
        System.out.println("Service SOAP SÉCURISÉ démarré avec succès!");
        System.out.println("WSDL disponible à: http://localhost:8080/services/hello-secure?wsdl");
        System.out.println("========================================");
        System.out.println("Authentification requise (WS-Security UsernameToken):");
        System.out.println("  Utilisateurs autorisés:");
        System.out.println("    - student / secret123");
        System.out.println("    - admin / admin456");
        System.out.println("  Password Type: PasswordText");
        System.out.println("========================================");
        System.out.println("⚠️  ATTENTION: En production, utilisez:");
        System.out.println("  - PasswordDigest (pas PasswordText)");
        System.out.println("  - HTTPS (pas HTTP)");
        System.out.println("  - Signature et chiffrement des messages");
        System.out.println("========================================");
        System.out.println("Appuyez sur Ctrl+C pour arrêter le serveur");
        */
    }
}

