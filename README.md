# Tast-Tracker
project from roadmap
https://roadmap.sh/projects/task-tracker

#information
Projet configurer en Java 21
Utilisation de la dépendance suivante, pour utiliser les fichiers aux formats Json : 
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.16.1</version>
</dependency>

#Lancer le projet
Ouvrez le dossier taskTracker dans votre IDE.
Après le build, il faut ajouter les arguments suivant pour effectuer les différentes actions : 
	
# Ajouter une task
add "Buy groceries"
### sortie attendue: Task added successfully (ID: 1)

# Mise à jour et suppression d'une task
update 1 "Buy groceries and cook dinner"
delete 1

# Mettre une task au status in-progress ou done
mark-in-progress 1
mark-done 1

# Lister toutes les tasks
list

# Lister les tasks par status
list done
list todo
list in-progress
