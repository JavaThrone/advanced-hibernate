plugins { 
  java
  eclipse
}

allprojects {
   group = "it.discovery"
}

subprojects {  
   apply(plugin = "java")

   java.sourceCompatibility = JavaVersion.VERSION_11
   java.targetCompatibility = JavaVersion.VERSION_11

   repositories {
     jcenter()
   }
   
   dependencies {
        val hibernateVersion : String by project
        compile("org.hibernate:hibernate-core:$hibernateVersion")
        runtime("org.hsqldb:hsqldb:2.4.1")
        runtime("com.h2database:h2:1.4.199")
        runtime("mysql:mysql-connector-java:8.0.16")
        runtime("org.postgresql:postgresql:42.2.5")                

        compileOnly("org.projectlombok:lombok:1.18.8")
        annotationProcessor("org.projectlombok:lombok:1.18.8")
   } 
}

