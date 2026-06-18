plugins {
	id("fabric-loom") version "1.6.+"
	id("maven-publish")
	id("java")
}

version = project.property("mod_version") as String
group = project.property("maven_group") as String

repositories {
	mavenCentral()
	maven { url = uri("https://api.modrinth.com/maven") }
}

dependencies {
	minecraft("com.mojang:minecraft:${project.property("minecraft_version")}")
	mappings(loom.officialMojangMappings())
	modImplementation("net.fabricmc:fabric-loader:${project.property("loader_version")}")
	modImplementation("net.fabricmc.fabric-api:fabric-api:${project.property("fabric_version")}")
}

loom {
	accessWidenerPath.set(file("src/main/resources/caostaotal.accesswidener"))
}

tasks.withType<JavaCompile>().configureEach {
	options.release.set(21)
}

java {
	sourceCompatibility = JavaVersion.VERSION_21
	targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<ProcessResources>().configureEach {
	duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
		}
	}

	repositories {
		mavenLocal()
	}
}