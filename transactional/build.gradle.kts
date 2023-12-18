plugins {
	java
	id("org.springframework.boot") version "3.1.6"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.yash"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")

	compileOnly("org.projectlombok:lombok")

	// camunda 7.20 dependencies
	implementation("org.camunda.bpm:camunda-bom:7.20.0")
	implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter:7.20.0")
	implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest:7.20.0")
	implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:7.20.0")
	implementation("org.camunda.bpm:camunda-engine-plugin-spin:7.20.0")
	implementation("org.camunda.spin:camunda-spin-dataformat-all:1.22.0")
	implementation("org.camunda.bpm:camunda-engine-rest-openapi:7.20.0")
	implementation("org.camunda.bpm:camunda-engine:7.20.0")
	implementation("org.camunda.bpm:camunda-engine-plugin-connect:7.20.0")

	// Db2 JDBC driver
	implementation("com.ibm.db2.jcc:db2jcc:db2jcc4")

	// tests
	// testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}
