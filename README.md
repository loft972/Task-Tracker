# Tast-Tracker
project from roadmap
https://roadmap.sh/projects/task-tracker

#information
Java 21

#BUILD 
javac -d out *.java 

#RUN

### <ins>Adding a new task</ins>
```
java -cp out TaskAppli.java add "Buy groceries"
```
### <ins>Updating and deleting tasks</ins>
```
java -cp out TaskAppli.java update 1 "Buy groceries and cook dinner"
java -cp out TaskAppli.java delete 1
```
### <ins>Marking a task as in progress or done</ins>
```
java -cp out TaskAppli.java mark-in-progress 1
java -cp out TaskAppli.java mark-done 1
```
### <ins>Listing all tasks</ins>
```
java -cp out TaskAppli.java list
```

### <ins>Listing tasks by status</ins>
```
java -cp out TaskAppli.java list done
java -cp out TaskAppli.java list todo
java -cp out TaskAppli.java list in-progress
```
