# Tast-Tracker
project from roadmap
https://roadmap.sh/projects/task-tracker

#information
Java 21

#BUILD 
javac -d out *.java 

#RUN

### Adding a new task
java -cp out TaskAppli.java add "Buy groceries"
### Output: Task added successfully (ID: 1)

### Updating and deleting tasks
java -cp out TaskAppli.java update 1 "Buy groceries and cook dinner"
java -cp out TaskAppli.java delete 1

### Marking a task as in progress or done
java -cp out TaskAppli.java mark-in-progress 1
java -cp out TaskAppli.java mark-done 1

### Listing all tasks
java -cp out TaskAppli.java list

### Listing tasks by status
java -cp out TaskAppli.java list done
java -cp out TaskAppli.java list todo
java -cp out TaskAppli.java list in-progress
