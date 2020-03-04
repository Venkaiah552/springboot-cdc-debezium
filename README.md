# springboot-cdc-debezium
CDC Spring Boot with Embedded Debezium connector
Change Data Capture (CDC), As the name suggests, “CDC” is a design pattern that continuously identifies and captures incremental changes to data. This pattern is used for real-time data replication across live databases to analytical data sources or read replicas. It can also be used to trigger events based on data changes, such as the OutBox pattern.

Most modern databases support CDC through transaction logs. A transaction log is a sequential record of all changes made to the database while the actual data is contained in a separate file.

# What Is Debezium?
Debezium is a distributed platform built for CDC. It uses database transaction logs and creates event streams on row-level changes. Applications listening to these events can perform needed actions based on incremental data changes.
Debezium provides a library of connectors, supporting a variety of databases available today. These connectors can monitor and record row-level changes in the schemas of a database. They then publish the changes on to a streaming service like Kafka.
Normally, one or more connectors are deployed into a Kafka Connect cluster and are configured to monitor databases and publish data-change events to Kafka. A distributed Kafka Connect cluster provides the fault tolerance and scalability needed, ensuring that all the configured connectors are always running.

# What Is Embedded Debezium?
Applications that don’t need the level of fault tolerance and reliability Kafka Connect offers or want to minimize the cost of using them to run the entire platform, can run Debezium connectors within the application. This is done by embedding the Debezium engine and configuring the connector to run within the application. On data change events, the connectors send them directly to the application.

## Starting the SpringBoot application
Go to the folder springboot-cdc-debezium, run the command
```
mvn spring-boot:run
```


## Student table
```
 CREATE TABLE public.student
 (
    id integer NOT NULL,
    address character varying(255),
    email character varying(255),
    name character varying(255),
    CONSTRAINT student_pkey PRIMARY KEY (id)
 );
 ```

## Scripts to Insert, Update and Delete a record on Postgres
```
$ INSERT INTO STUDENT(ID, NAME, ADDRESS, EMAIL) VALUES('1','Jack','Dallas, TX','jack@gmail.com');

$ UPDATE STUDENT SET EMAIL='jill@gmail.com', NAME='Jill' WHERE ID = 1; 

$ DELETE FROM STUDENT WHERE ID = 1;
```

## H2 commands to test if CDC worked !
```
$ SELECT * FROM STUDENT;
```

