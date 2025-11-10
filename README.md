# SOAP-CXF Service - Projet Complet

## 📋 Description

Projet Maven démontrant la création d'un service SOAP avec Apache CXF, incluant:
- Service SOAP avec interface JAX-WS
- Modèle JAXB (Person)
- Serveur CXF embarqué
- Client Java
- Support pour WS-Security (en option)

## 🏗️ Architecture

```
soap-cxf-service/
├── src/main/java/ma/projet/
│   ├── api/
│   │   └── HelloService.java          # Interface JAX-WS du service
│   ├── impl/
│   │   └── HelloServiceImpl.java      # Implémentation du service
│   ├── model/
│   │   └── Person.java                # Modèle JAXB
│   ├── security/
│   │   └── UTPasswordCallback.java    # Callback WS-Security (optionnel)
│   ├── client/
│   │   └── ClientDemo.java            # Client Java
│   ├── Server.java                    # Serveur non sécurisé
│   └── SecureServer.java              # Serveur sécurisé (optionnel)
├── pom.xml                            # Configuration Maven
├── README.md                          # Ce fichier
├── DEMARRAGE.md                       # Guide de démarrage rapide
├── SOAPUI-GUIDE.md                    # Guide de test avec SoapUI
├── RESOLUTION-ERREURS.md              # Détails de résolution d'erreurs
└── RESUME-FINAL.md                    # Résumé et état du projet
```


<img width="1902" height="1149" alt="Screenshot 2025-11-11 002508" src="https://github.com/user-attachments/assets/64c71a52-13db-453d-aa05-ff3703009dd2" />
<img width="1859" height="1069" alt="Screenshot 2025-11-11 002440" src="https://github.com/user-attachments/assets/1599275f-0932-42e5-bfc8-4fd2fad257f8" />
<img width="1907" height="1137" alt="Screenshot 2025-11-11 001356" src="https://github.com/user-attachments/assets/a869477b-141c-4dfc-86c5-88b34f95beab" />
<img width="1904" height="1128" alt="Screenshot 2025-11-11 001349" src="https://github.com/user-attachments/assets/023e8a4e-95a4-483b-9044-ee6926f7ac3e" />


## 🔧 Technologies Utilisées

- **Java 11+**
- **Apache CXF 4.0.3** - Framework SOAP/REST
- **JAX-WS** - API Java pour services web SOAP
- **JAXB** - Liaison XML/Objet Java
- **Maven** - Gestion des dépendances
- **WSS4J 3.0.0** (optionnel) - WS-Security

## 📦 Prérequis

- Java JDK 11 ou supérieur
- Maven 3.6+
- Un IDE (IntelliJ IDEA recommandé) ou ligne de commande

## 🚀 Installation et Démarrage

### 1. Cloner/Ouvrir le Projet

```cmd
cd C:\Users\karzo\OneDrive\Bureau\study\lachgar\soap-cxf-service
```

### 2. Compiler le Projet

```cmd
mvn clean compile
```

ou pour créer le JAR:

```cmd
mvn clean package
```

### 3. Démarrer le Serveur

#### Option A: Avec Maven

```cmd
mvn exec:java -Dexec.mainClass="ma.projet.Server"
```

#### Option B: Avec IntelliJ IDEA

1. Ouvrir `src/main/java/ma/projet/Server.java`
2. Clic droit → Run 'Server.main()'

#### Option C: Avec le JAR

```cmd
java -cp target\soap-cxf-service-1.0-SNAPSHOT.jar ma.projet.Server
```

### 4. Vérifier le Démarrage

Le serveur affichera:
```
========================================
Service SOAP démarré avec succès!
WSDL disponible à: http://localhost:8080/services/hello?wsdl
========================================
```

Ouvrir dans un navigateur: http://localhost:8080/services/hello?wsdl

## 🧪 Tester le Service

### 1. Avec le Client Java

```cmd
mvn exec:java -Dexec.mainClass="ma.projet.client.ClientDemo"
```

**Résultat attendu:**
```
========================================
Client SOAP - Démonstration
========================================

--- Test 1: SayHello ---
Réponse: Bonjour, ClientJava

--- Test 2: FindPerson ---
Personne trouvée:
  ID: P-777
  Nom: Ada Lovelace
  Âge: 36

--- Test 3: SayHello avec nom null ---
Réponse: Bonjour, inconnu

========================================
Tous les tests ont réussi!
========================================
```

### 2. Avec cURL

**Test SayHello:**
```cmd
curl -X POST http://localhost:8080/services/hello ^
  -H "Content-Type: text/xml" ^
  -d "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:api=\"http://api.projet.ma/\"><soapenv:Header/><soapenv:Body><api:SayHello><name>Lachgar</name></api:SayHello></soapenv:Body></soapenv:Envelope>"
```

**Test FindPerson:**
```cmd
curl -X POST http://localhost:8080/services/hello ^
  -H "Content-Type: text/xml" ^
  -d "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:api=\"http://api.projet.ma/\"><soapenv:Header/><soapenv:Body><api:FindPerson><id>P-001</id></api:FindPerson></soapenv:Body></soapenv:Envelope>"
```

### 3. Avec SoapUI

Voir le fichier **SOAPUI-GUIDE.md** pour des instructions détaillées.

## 🎯 Opérations du Service

### 1. SayHello

**Description**: Retourne un message de salutation personnalisé

**Entrée**: 
- `name` (String) - Le nom à saluer

**Sortie**: 
- `greeting` (String) - Message de salutation

**Exemple**:
```xml
<api:SayHello>
   <name>Lachgar</name>
</api:SayHello>
```

**Réponse**:
```xml
<ns2:SayHelloResponse>
   <greeting>Bonjour, Lachgar</greeting>
</ns2:SayHelloResponse>
```

### 2. FindPerson

**Description**: Recherche et retourne les informations d'une personne

**Entrée**: 
- `id` (String) - L'identifiant de la personne

**Sortie**: 
- `person` (Person) - Objet contenant id, name, age

**Exemple**:
```xml
<api:FindPerson>
   <id>P-001</id>
</api:FindPerson>
```

**Réponse**:
```xml
<ns2:FindPersonResponse>
   <person>
      <id>P-001</id>
      <name>Ada Lovelace</name>
      <age>36</age>
   </person>
</ns2:FindPersonResponse>
```

## 🔒 Serveur Sécurisé (Optionnel)

Le projet inclut un serveur avec WS-Security, actuellement désactivé pour faciliter la première utilisation.

### Pour Activer WS-Security:

1. **Ajouter les dépendances au pom.xml**:

```xml
<!-- WS-Security -->
<dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-rt-ws-security</artifactId>
    <version>4.0.3</version>
</dependency>
<dependency>
    <groupId>org.apache.wss4j</groupId>
    <artifactId>wss4j-ws-security-common</artifactId>
    <version>3.0.0</version>
</dependency>
```

2. **Décommenter le code dans**:
   - `SecureServer.java` (le bloc commenté)
   - `UTPasswordCallback.java` (l'implémentation)

3. **Recompiler**:
```cmd
mvn clean compile
```

4. **Lancer le serveur sécurisé**:
```cmd
mvn exec:java -Dexec.mainClass="ma.projet.SecureServer"
```

**Credentials par défaut:**
- Username: `student` / Password: `secret123`
- Username: `admin` / Password: `admin456`

## 📖 Concepts SOA Implémentés

### Apache CXF
Framework Apache pour services SOAP (JAX-WS) et REST (JAX-RS). Gère la publication, le transport HTTP, la génération du WSDL et l'intégration WS-Security.

### JAX-WS
Standard Java pour exposer des services SOAP via annotations:
- `@WebService` - Marque une interface/classe comme service web
- `@WebMethod` - Définit une opération du service
- `@WebParam` - Nomme un paramètre d'opération
- `@WebResult` - Nomme le résultat d'une opération

### JAXB
Standard Java pour la liaison XML/Objet (Java ↔ XML):
- `@XmlRootElement` - Définit l'élément racine XML
- `@XmlElement` - Marque une propriété comme élément XML

### WSDL
Contrat XML du service décrivant:
- **Types** - Schémas XSD des données
- **Messages** - Formats de requêtes/réponses
- **PortType** - Interface logique (opérations)
- **Binding** - Protocole (SOAP/HTTP)
- **Service** - Endpoint réel (URL)

### WS-Security
Sécurité au niveau message SOAP:
- **UsernameToken** - Authentification par username/password
- **Signature** - Garantit l'intégrité du message
- **Chiffrement** - Protège la confidentialité des données

## 🔍 Structure du WSDL Généré

Le WSDL est automatiquement généré par CXF et accessible à:
```
http://localhost:8080/services/hello?wsdl
```

**Sections principales:**

1. **types** - Définitions XSD (Person, requests, responses)
2. **message** - Messages de requête/réponse pour chaque opération
3. **portType** - Interface logique avec les opérations
4. **binding** - Liaison SOAP/HTTP
5. **service** - Endpoint physique avec l'URL

## 🛠️ Dépannage

### Port 8080 déjà utilisé

**Solution**: Changer le port dans `Server.java`:
```java
String address = "http://localhost:9090/services/hello";
```

### Dépendances Maven non résolues

**Solution**:
```cmd
mvn clean
mvn dependency:purge-local-repository
mvn install -U
```

### Erreur "release version not supported"

**Solution**: Vérifier la version de Java:
```cmd
java -version
```
Le projet nécessite Java 11+.

### WSDL introuvable

**Solutions**:
1. Vérifier que le serveur est démarré
2. Vérifier l'URL exacte (avec `?wsdl`)
3. Vérifier le firewall

### Client ne peut pas se connecter

**Solutions**:
1. Vérifier que le serveur est en cours d'exécution
2. Vérifier l'URL du WSDL dans `ClientDemo.java`
3. Vérifier que le port n'est pas bloqué

## 📊 Bonnes Pratiques Implémentées

✅ **Séparation des préoccupations**:
- `api/` - Interfaces (contrats)
- `impl/` - Implémentations (logique métier)
- `model/` - Modèles de données
- `security/` - Sécurité
- `client/` - Clients

✅ **Annotations explicites**:
- Noms d'opérations clairs (`@WebMethod(operationName = "...")`)
- Noms de paramètres explicites (`@WebParam(name = "...")`)
- Noms de résultats descriptifs (`@WebResult(name = "...")`)

✅ **Documentation du code**:
- Javadoc pour les classes et méthodes
- Commentaires explicatifs
- Guides d'utilisation séparés

✅ **Gestion des cas limites**:
- Paramètres null gérés
- Messages d'erreur clairs

## 🚀 Extensions Possibles

### 1. Spring Boot
Intégrer avec `cxf-spring-boot-starter-jaxws` pour:
- Configuration via application.properties
- Injection de dépendances
- Endpoints REST supplémentaires

### 2. Base de Données
Remplacer les données mockées par:
- JPA/Hibernate
- Repository pattern
- Transactions

### 3. Sécurité Avancée
Implémenter:
- PasswordDigest (au lieu de PasswordText)
- Signature des messages
- Chiffrement des parties sensibles
- HTTPS/TLS
- Certificats X.509

### 4. Tests Automatisés
Ajouter:
- Tests JUnit pour la logique métier
- Tests d'intégration avec serveur embarqué
- Tests SoapUI automatisés (testrunner)

### 5. Monitoring
Intégrer:
- Logging avec SLF4J/Logback
- Métriques avec Micrometer
- Health checks

### 6. Contract-First
Partir d'un WSDL existant:
- Générer le code avec `wsdl2java`
- Implémenter les interfaces générées
- Garantir la compatibilité stricte

## 📚 Ressources et Références

### Documentation Officielle
- **Apache CXF**: https://cxf.apache.org/docs/
- **JAX-WS**: https://javaee.github.io/metro-jax-ws/
- **JAXB**: https://javaee.github.io/jaxb-v2/
- **WSS4J**: https://ws.apache.org/wss4j/

### Outils
- **SoapUI**: https://www.soapui.org/
- **Postman**: Supporte aussi SOAP
- **curl**: Outil en ligne de commande

### Standards
- **SOAP 1.1**: https://www.w3.org/TR/soap11/
- **SOAP 1.2**: https://www.w3.org/TR/soap12/
- **WSDL 1.1**: https://www.w3.org/TR/wsdl
- **WS-Security**: https://www.oasis-open.org/committees/wss/

## 📝 Fichiers de Documentation

- **DEMARRAGE.md** - Guide de démarrage rapide avec checklist
- **SOAPUI-GUIDE.md** - Instructions détaillées pour tester avec SoapUI
- **RESOLUTION-ERREURS.md** - Détails sur les problèmes résolus
- **RESUME-FINAL.md** - État du projet et instructions complètes

## 👥 Auteur

Projet créé pour le cours de **M. Lachgar** - Services Web SOAP avec Apache CXF

## 📄 Licence

Ce projet est à des fins éducatives.

## ✅ Checklist de Validation

- [x] WSDL accessible et parsable
- [x] SayHello et FindPerson fonctionnels
- [x] Person correctement sérialisé (JAXB)
- [x] Client Java opérationnel
- [x] Code organisé (packages api, impl, model, security, client)
- [x] Documentation complète
- [ ] Endpoint sécurisé activé (optionnel)
- [ ] Tests automatisés (optionnel)

## 🆘 Support

Pour toute question:
1. Consulter les fichiers de documentation
2. Vérifier les logs d'erreur
3. Consulter la documentation Apache CXF
4. Utiliser SoapUI pour déboguer les messages SOAP

---

**Le projet est opérationnel et prêt à l'emploi! 🎉**

Pour démarrer rapidement, voir **DEMARRAGE.md**

