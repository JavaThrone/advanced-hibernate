  dependencies {
      val hibernateVersion : String by project

      compile("org.hibernate:hibernate-ehcache:$hibernateVersion")
      compile("org.hibernate:hibernate-entitymanager:$hibernateVersion")
 }
