package ma.projet.security;

// import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Map;

/**
 * Callback handler pour valider les UsernameToken.
 * Utilisé par WSS4J pour vérifier les credentials dans le header WS-Security.
 *
 * NOTE: Cette classe nécessite les dépendances WS-Security pour fonctionner.
 * Ajoutez au pom.xml:
 * - org.apache.wss4j:wss4j-ws-security-common:3.0.0
 */
public class UTPasswordCallback implements CallbackHandler {
    private final Map<String, String> users;

    public UTPasswordCallback(Map<String, String> users) {
        this.users = users;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        /* CODE À ACTIVER APRÈS AVOIR AJOUTÉ LES DÉPENDANCES WS-SECURITY
        for (Callback cb : callbacks) {
            if (cb instanceof WSPasswordCallback) {
                WSPasswordCallback pc = (WSPasswordCallback) cb;
                String pass = users.get(pc.getIdentifier());
                if (pass != null) {
                    pc.setPassword(pass);
                }
            }
        }
        */
        throw new UnsupportedOperationException(
            "UTPasswordCallback nécessite les dépendances WS-Security. " +
            "Ajoutez org.apache.wss4j:wss4j-ws-security-common au pom.xml"
        );
    }
}

