# VISIT RECORD

This is a simple program was developed using java and maven. The program allows to query about the visits of people to different cities having as data source a file.
The data (list of cities and people) are stored in a file with custom format, below you can see an example.

File content example: 

```
F1
D Erica Burns,BARCELONA,93654902Y
F2 
D Mitchell Newton ; LAS VEGAS ; 25384390-A 
```   

## SETUP

You should have installed the Java's virtual machine in your operating system.

## USAGE

There are two commands:
```    
java -jar visit.record.jar {FILE} CITY {CITY_NAME}   
  
java -jar visit.record.jar {FILE} ID {ID_VALUE}
```

## HOW TO

In a terminal of commands write:
```
java -jar visit.record.jar {PATH TO FILE} CITY {CITY'S NAME}
OR
java -jar visit.record.jar {PATH TO FILE} ID {PERSON'S ID}
```

Examples in compliance with the data file shown above:

```
java -jar visit.record.jar data.txt CITY BARCELONA
Output:
Erica Burns,93654902Y
```

```
java -jar visit.record.jar data.txt ID 93654902Y
Output:
BARCELONA
```

## CONTACT
Roberto Granda Ruiz, 
roberuiz11@gmail.com
