package com.yash.transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalApplication.class, args);
	}
}

//

/*
*
* Docker run command
* 	-> docker run -itd --name db2 --privileged=true -p 50000:50000 -e LICENSE=accept -e DB2INST1_PASSWORD=krsna19 -e DBNAME=testdb2 ibmcom/db2
*
*  Connect to DB2
* 	-> connect to testdb2
*
* List All the tables
* 	-> db2 LIST TABLES FOR ALL
*
* cataloged db2 databases
* 	-> db2 list db directory
*
* query users
* 	-> select * from users;
*
* query process instances
* 	-> select * from ACT_HI_PROCINST;
* */