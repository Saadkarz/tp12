'''# Guide de Démarrage Rapide

## ✅ Projet Créé

Votre projet SOAP-CXF est maintenant complet avec tous les fichiers nécessaires:

### 📁 Structure du Projet
```
soap-cxf-service/
├── src/main/java/ma/projet/
│   ├── api/HelloService.java              ✓ Interface JAX-WS
│   ├── impl/HelloServiceImpl.java         ✓ Implémentation
│   ├── model/Person.java                  ✓ Modèle JAXB
│   ├── security/UTPasswordCallback.java   ✓ Sécurité
│   ├── client/ClientDemo.java             ✓ Client
│   ├── Server.java                        ✓ Serveur normal
│   └── SecureServer.java                  ✓ Serveur sécurisé
├── pom.xml                                ✓ Configuration Maven
├── README.md                              ✓ Documentation complète
└── SOAPUI-GUIDE.md                        ✓ Guide de test

```

## 🚀 Compilation et Exécution

### Option 1: Avec Maven (recommandé)

#### 1. Compiler le projet
```cmd
mvn clean install -DskipTests
```

#### 2. Lancer le serveur non sécurisé
```cmd
mvn exec:java -Dexec.mainClass="ma.projet.Server"
```

#### 3. Lancer le serveur sécurisé
```cmd
mvn exec:java -Dexec.mainClass="ma.projet.SecureServer"
```

#### 4. Lancer le client
```cmd
mvn exec:java -Dexec.mainClass="ma.projet.client.ClientDemo"
```

### Option 2: Depuis l'IDE (IntelliJ IDEA)

1. **Importer le projet**
   - File → Open → Sélectionner le dossier `soap-cxf-service`
   - Attendre que Maven synchronise les dépendances

2. **Exécuter le serveur**
   - Ouvrir `ma.projet.Server.java`
   - Clic droit → Run 'Server.main()'
   
3. **Tester le WSDL**
   - Ouvrir dans un navigateur: http://localhost:8080/services/hello?wsdl

4. **Exécuter le client**
   - Ouvrir `ma.projet.client.ClientDemo.java`
   - Clic droit → Run 'ClientDemo.main()'

### Option 3: Avec JAR exécutable

```cmd
mvn clean package
java -cp target/soap-cxf-service-1.0-SNAPSHOT.jar ma.projet.Server
```

## 🧪 Tester le Service

### 1. Avec le Client Java
Lancer `ClientDemo.java` pour tester automatiquement les deux opérations.

### 2. Avec SoapUI
Voir le fichier `SOAPUI-GUIDE.md` pour des instructions détaillées.

### 3. Avec un navigateur
- WSDL: http://localhost:8080/services/hello?wsdl
- WSDL sécurisé: http://localhost:8080/services/hello-secure?wsdl

### 4. Avec curl (test rapide)

**SayHello:**
```cmd
curl -X POST http://localhost:8080/services/hello ^
  -H "Content-Type: text/xml" ^
  -d "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:api=\"http://api.projet.ma/\"><soapenv:Header/><soapenv:Body><api:SayHello><name>Lachgar</name></api:SayHello></soapenv:Body></soapenv:Envelope>"
```

**FindPerson:**
```cmd
curl -X POST http://localhost:8080/services/hello ^
  -H "Content-Type: text/xml" ^
  -d "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:api=\"http://api.projet.ma/\"><soapenv:Header/><soapenv:Body><api:FindPerson><id>P-001</id></api:FindPerson></soapenv:Body></soapenv:Envelope>"
```

## 📚 Documentation Complète

- **README.md** - Documentation générale du projet
- **SOAPUI-GUIDE.md** - Guide de test avec SoapUI

## 🔧 Dépannage

### Problème: Port 8080 déjà utilisé
**Solution**: Changer le port dans `Server.java` et `SecureServer.java`
```java
String address = "http://localhost:9090/services/hello";
```

### Problème: Dependencies Maven
**Solution**: Nettoyer le cache Maven
```cmd
mvn clean
mvn dependency:purge-local-repository
mvn install -U
```

### Problème: Java version
Le projet est configuré pour Java 11. Vérifier votre version:
```cmd
java -version
```

## 📖 Concepts Clés

### Apache CXF
Framework pour services SOAP (JAX-WS) et REST (JAX-RS). Gère la publication HTTP, génération WSDL, et WS-Security.

### JAX-WS
Standard Java pour services web SOAP via annotations (@WebService, @WebMethod).

### JAXB
Liaison XML/Objet (Java ↔ XML) pour (dé)sérialiser les POJO.

### WS-Security
Sécurité au niveau message SOAP (UsernameToken, signature, chiffrement).

## ✅ Checklist de Validation

- [✓] Projet Maven créé
- [✓] Dépendances CXF ajoutées
- [✓] Modèle JAXB (Person) créé
- [✓] Interface JAX-WS (HelloService) créée
- [✓] Implémentation (HelloServiceImpl) créée
- [✓] Serveur non sécurisé créé
- [✓] Serveur sécurisé avec WS-Security créé
- [✓] Client Java créé
- [✓] Callback de sécurité créé
- [✓] Documentation complète

## 🎯 Prochaines Étapes

1. **Compiler** le projet avec Maven ou l'IDE
2. **Lancer** le serveur (`Server.java`)
3. **Tester** le WSDL dans un navigateur
4. **Exécuter** le client Java (`ClientDemo.java`)
5. **Tester** avec SoapUI (voir guide)
6. **Explorer** le service sécurisé (`SecureServer.java`)

## 📞 Besoin d'aide?

Consultez les fichiers de documentation:
- `README.md` pour la documentation technique complète
- `SOAPUI-GUIDE.md` pour les tests avec SoapUI

Bon travail! 🚀

