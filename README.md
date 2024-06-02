# Projet JavaFX Agence de voyage

Ce guide vous expliquera comment configurer votre environnement de développement, créer un projet JavaFX, et démarrer avec un exemple de code.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les éléments suivants :

- **Java Development Kit (JDK)**
- **JavaFX SDK** : Téléchargez la version compatible avec votre JDK.
- **IDE** : Un environnement de développement intégré comme IntelliJ IDEA, Eclipse, ou NetBeans.
- **Scene Builder** : Un outil pour créer des interfaces utilisateur JavaFX.


## Configuration de l'Environnement

1. **Téléchargez et installez le JDK** :
    - Suivez les instructions sur le site officiel pour installer le JDK.

2. **Téléchargez et installez JavaFX SDK** :
    - Décompressez l'archive téléchargée dans un répertoire de votre choix.

3. **Configurez votre IDE** :
    - **IntelliJ IDEA** :
        - Allez dans `File` > `Project Structure` > `Libraries`.
        - Cliquez sur le bouton `+` et sélectionnez le dossier `lib` de votre JavaFX SDK.
    - **Eclipse** :
        - Allez dans `Window` > `Preferences` > `Java` > `Build Path` > `User Libraries`.
        - Cliquez sur `New` et ajoutez le dossier `lib` de votre JavaFX SDK.
    - **NetBeans** :
        - Allez dans `Tools` > `Libraries`.
        - Cliquez sur `New Library` et ajoutez le dossier `lib` de votre JavaFX SDK.
3. **Téléchargez et installez Scene Builder**.

## Création du Projet

1. **Créez un nouveau projet Java** dans votre IDE.
    - **IntelliJ IDEA** : `File` > `New` > `Project` > `Java`
    - **Eclipse** : `File` > `New` > `Java Project`
    - **NetBeans** : `File` > `New Project` > `Java` > `Java Application`

2. **Configurez le projet pour utiliser JavaFX** :
    - Ajoutez JavaFX SDK au chemin de construction (build path) de votre projet.


#### 3. `src/main/java/com/votrepackage/models`

Ce dossier contient les modèles de données de votre application.

- **Modèles** : Les modèles représentent les données de l'application. Chaque classe de modèle correspond à une entité de la base de données ou une structure de données utilisée dans l'application (par exemple, `Hotel`, `Chambre`).

#### 4. `src/main/java/com/votrepackage/services`

Ce dossier contient les services de votre application.

- **Services** : Les services contiennent la logique métier et les opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) pour les modèles. Ils interagissent directement avec la base de données pour effectuer des opérations sur les données.

#### 5. `src/main/resources/gui`

Ce dossier contient les fichiers FXML de votre application.
Ce dossier contient les contrôleurs de votre application.

- **Contrôleurs** : Les contrôleurs gèrent les interactions entre l'interface utilisateur définie dans les fichiers FXML et la logique métier de l'application. Chaque fichier FXML a un contrôleur associé qui contient les méthodes pour gérer les événements de l'interface utilisateur.

- **FXML** : Les fichiers FXML définissent l'interface utilisateur de l'application. Ils sont créés à l'aide de Scene Builder, un outil visuel pour concevoir les interfaces JavaFX. Chaque fichier FXML décrit la disposition des éléments de l'interface et est associé à un contrôleur.


### Création d'une Interface Utilisateur avec Scene Builder

1. **Créez un fichier FXML** :
    - Dans votre projet, créez un nouveau fichier FXML dans le dossier `resources/gui ou resources/views`.

2. **Ouvrez le fichier FXML avec Scene Builder** :
    - Dans votre IDE, faites un clic droit sur le fichier FXML et sélectionnez `Open in Scene Builder`.

3. **Concevez l'interface utilisateur** :
    - Utilisez les outils de Scene Builder pour ajouter des composants (boutons, labels, etc.) à votre interface.
    - Organisez les composants en utilisant des conteneurs (VBox, HBox, GridPane, etc.).

4. **Définissez les contrôleurs et les actions** :
    - Associez des contrôleurs aux éléments de l'interface en définissant les `fx:id` et les actions (méthodes du contrôleur).
    - Sauvegardez votre fichier FXML.

### Liaison avec le Contrôleur

1. **Créez une classe de contrôleur** dans le dossier `controllers`.
    - Définissez les méthodes pour gérer les événements de l'interface utilisateur.

2. **Associez le contrôleur au fichier FXML** :
    - Ouvrez le fichier FXML dans un éditeur de texte.
    - Ajoutez l'attribut `fx:controller` pour lier le fichier FXML à la classe de contrôleur.

### Conseils et Meilleures Pratiques

- **Utilisez FXML** : Séparez la logique de la présentation en utilisant des fichiers FXML pour définir l'interface utilisateur et des contrôleurs pour la logique.
- **Structure Modulaire** : Organisez votre code en utilisant des packages distincts pour les contrôleurs, modèles, services, etc.
- **Documentation et Commentaires** : Commentez votre code et fournissez une documentation claire pour faciliter la compréhension et la maintenance du projet.
- **Utilisez Scene Builder** : Pour concevoir les interfaces utilisateur graphiques facilement et efficacement.

