buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.4.1")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    //realm
    classpath("io.realm:realm-gradle-plugin:10.4.0")
    //objectbox
    classpath("io.objectbox:objectbox-gradle-plugin:3.1.3")
    //sqldelight
    classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
