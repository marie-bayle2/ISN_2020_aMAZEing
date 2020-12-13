----- Compiler et lancer le jeu -----

- Utiliser la commande "ant compile jar" pour compiler l'ensemble des fichiers et créer l'archive .jar.
- Une fois cela fait, pour lancer le jeu utiliser la commande "ant run"

----- Plus de commande -----

- "ant clean" permet d'effacer les répertoires bin/ et exe/ si ils existent
- "ant compile" lance "ant clean" et compile les fichiers .java et met les .class dans un répertoire bin/ 
après l'avoir créé.
- "ant jar" lance "ant compile" et créer une archive .jar à partir des fichiers .class
et la met dans un dossier exe/ après l'avoir créé.
- "ant run" exécute le fichier .jar et lance le jeu.

----- Information annexe -----

- Durant la partie pour quitter le jeu utiliser CTRL + C et réponder 'o'.
