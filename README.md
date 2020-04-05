# rdlgalaxie

rdlgalaxie est une application de e-commerce commercialisant des produits dérivés de la communauté (fictive) nommée “Les Radins de la Galaxie”.

Cette application a été développée en tant que projet de groupe dans le cadre d’une formation JavaJEE de 57 jours. Cette formation, dispensée par Inti et commandée par Adaming, a pour objectif de former des ingénieurs issus de différentes formations aux bases de Java. https://adaming.fr/

Cette application a été générée en utilisant JHipster 6.6.0, vous pouvez trouver la documentation et l’aide ici : https://www.jhipster.tech/documentation-archive/v6.6.0](https://www.jhipster.tech/documentation-archive/v6.6.0)

## Développement

Avant de construire ce projet, vous devez installer et configurer les dépendances suivantes sur votre machine : 


1. [Node.js][]: nous utilisons Node pour lancer un serveur de développement web et construire le projet. En fonction de votre système, vous pouvez installer Node soit comme une source ou comme un package pré-emballé.

Après avoir installé Node, vous devez lancer les commandes suivantes pour installer les outils de développement.
Vous aurez seulement besoin de cette commande pour lancer le projet lorsque les dépendances seront installées :

    npm install

Nous utilisons npm  scripts et [Webpack][] comme système de construction.

Lancer les commandes suivantes dans 2 terminaux différents pour créer le développement où votre navigateur s’actualisera automatiquement quand les dossiers seront changés sur le disque dur :

    ./mvnw
    npm start

Npm est aussi utilisé pour gérer les dépendance CSS et JavaScript utilisées dans cette application. Vous pouvez améliorer les dépendance en spécifiant une nouvelle version dans [package.json](package.json) ou vous pouvez lancer `npm update` et `npm install`.
Ajoutez le `help` sur chaque commande pour voir comment l’utiliser. Par exemple, `npm help update`

La commande `npm run` listera tous les scripts disponibles pour lancer le projet.


### Support PWA 

JHipster expédit avec le support PWA (Progressive Web App) et cela s’arrête par défaut. L’un des principaux composants de PWA est un  “service worker”.

L’initialisation du code du service worker est en commentaire par défaut. Pour l’activer, enlever le commentaire dans le code suivant : `src/main/webapp/index.html`:


```html
<script>
  if ('serviceWorker' in navigator) {
    navigator.serviceWorker.register('./service-worker.js').then(function() {
      console.log('Service Worker Registered');
    });
  }
</script>
```

Note: [Workbox](https://developers.google.com/web/tools/workbox/) fait fonctionner le service worker de JHipster. Cela génère automatiquement le fichier `service-worker.js`.

### Gérer les dépendances

Par exemple, pour ajouter la librairie  [Leaflet][] comme dépendance d'exécution à votre application, vous devez lancer la commande suivante :

    npm install --save --save-exact leaflet

Pour bénéficier des types de définition TypeScript du répertoire [DefinitelyTyped][] en développement, vous devez lancer la commande suivante :

    npm install --save-dev --save-exact @types/leaflet

Ensuite, vous devez importer les fichier JS et CSS spécifiés dans les instructions d’installation de la librairie pour que  [Webpack][] puisse les reconnaître :

Editez [src/main/webapp/app/vendor.ts](src/main/webapp/app/vendor.ts) :

```
import 'leaflet/dist/leaflet.js';
```

Editez[src/main/webapp/content/scss/vendor.scss](src/main/webapp/content/scss/vendor.scss) :

```
@import '~leaflet/dist/leaflet.css';
```

Note: There are still a few other things remaining to do for Leaflet that we won't detail here. Il reste toujours quelques modifications à faire pour Leaflet mais nous ne les détaillerons pas ici. Pour plus d’information, regardez [Using JHipster in development][].

### Utiliser Angular CLI

Vous pouvez aussi utiliser  [Angular CLI][] pour générer un code client personnalisé.
Par exemple, la commande suivante 

    ng generate component my-component

génère plusieur fichiers :

    create src/main/webapp/app/my-component/my-component.component.html
    create src/main/webapp/app/my-component/my-component.component.ts
    update src/main/webapp/app/app.module.ts

## Construire pour la production

### Créer le jar

Pour construire le jar final et optimiser votre application pour la production, lancez :

    ./mvnw -Pprod clean verify

Cela va concaténer et minimiser les fichiers CSS et JavaScript du client. Cela va aussi modifier index.html pour faire référence aux nouveaux fichiers.
Pour s’assurer que tout fonctionne, lancez :

    java -jar target/*.jar

Ensuite, ouvrez la page http://localhost:8080 avec votre navigateur.

Référez-vous à [Using JHipster in production][] pour plus de détails.


### Faire le package war

Pour faire le package war de votre application et la déployer sur un serveur d’application, lancez :

    ./mvnw -Pprod,war clean verify

## Tester

Pour faire les tests de votre application, lancez :

    ./mvnw verify

### Tests client

Les tests unitaires sont lancés par [Jest][] et écrits avec [Jasmine][]. Il se trouvent dans : src/test/javascript/](src/test/javascript/ et vous pouvez les lancer avec :

    npm test

Pour plus d’informations, référez-vous à [Running tests page][].

### Qualité du code

Sonar est utilisé pour analyser la qualité du code. Vous pouvez démarrer un serveur local Sonal (accessible sur http://localhost:9001) avec :

```
docker-compose -f src/main/docker/sonar.yml up -d
```

Vous pouvez lancer une analyse Sonar en utilisant le scanner sonar (https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner) ou en utilisant le plugin maven.

Ensuite, lancer l’analyse Sonar :

```
./mvnw -Pprod clean verify sonar:sonar
```

Si vous avez de relancer la phase Sonar, assurez-vous de spécifier au moins la phase d’initialisation car les propriétés de Sonar sont chargées à partir du fichier sonar-project.properties.

```
./mvnw initialize sonar:sonar
```

ou

Pour plus d’information, référez-vous à  [Code quality page][].


## Utiliser Docker (optionnel)

Vous pouvez utiliser Docker pour améliorer votre expérience de développement JHipster. Un nombre de configurations docker sont disponibles dans le dossier [src/main/docker](src/main/docker) pour lancer les services tiers requis.

Par exemple, pour démarrer la base de données mongodb dans un conteneur docker, lancez :

    docker-compose -f src/main/docker/mongodb.yml up -d

Pour le stopper et retirer le conteneur, lancez :

    docker-compose -f src/main/docker/mongodb.yml down

Vous pouvez aussi entièrement “dockeriser” votre application et tous les services qui en dépendent. Pour cela, construisez un docker image de votre application en lançant :

    ./mvnw -Pprod verify jib:dockerBuild

Ensuite lancez :

    docker-compose -f src/main/docker/app.yml up -d

Pour plus d’information, référez-vous à [Using Docker and Docker-Compose][],cette page contient également des informations sur le sous-générateur docker-compose  (`jhipster docker-compose`) qui est capable de générer les configurations de docker pour une ou plusieurs applications JHipster. 

## Intégration continue (optionnelle)

Pour configurer CI pour votre projet, exécutez le sous-générateur ci-cd (`jhipster ci-cd`), cela vous permettra de générer des fichiers de configuration pour un certain nombre de systèmes d'intégration continue. Consultez la page [Configuration de l'intégration continue] [] pour plus d'informations.

## Auteurs
Lorène BASTAZO @lbastazo
Louis LAILLET @laille02
Pauline MUYL @Pauline195
Julie COTON @juliecoton


[jhipster homepage and latest documentation]: https://www.jhipster.tech
[jhipster 6.6.0 archive]: https://www.jhipster.tech/documentation-archive/v6.6.0
[using jhipster in development]: https://www.jhipster.tech/documentation-archive/v6.6.0/development/
[using docker and docker-compose]: https://www.jhipster.tech/documentation-archive/v6.6.0/docker-compose
[using jhipster in production]: https://www.jhipster.tech/documentation-archive/v6.6.0/production/
[running tests page]: https://www.jhipster.tech/documentation-archive/v6.6.0/running-tests/
[code quality page]: https://www.jhipster.tech/documentation-archive/v6.6.0/code-quality/
[setting up continuous integration]: https://www.jhipster.tech/documentation-archive/v6.6.0/setting-up-ci/
[node.js]: https://nodejs.org/
[yarn]: https://yarnpkg.org/
[webpack]: https://webpack.github.io/
[angular cli]: https://cli.angular.io/
[browsersync]: https://www.browsersync.io/
[jest]: https://facebook.github.io/jest/
[jasmine]: https://jasmine.github.io/2.0/introduction.html
[protractor]: https://angular.github.io/protractor/
[leaflet]: https://leafletjs.com/
[definitelytyped]: https://definitelytyped.org/
