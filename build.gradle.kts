buildscript {
  repositories {
    google()
    jcenter()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.0.0")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
    //realm
    classpath("io.realm:realm-gradle-plugin:10.4.0")
    //objectbox
    classpath("io.objectbox:objectbox-gradle-plugin:2.8.1")
    //sqldelight
    classpath("com.squareup.sqldelight:gradle-plugin:1.5.0")
  }
}

allprojects {
  repositories {
    google()
    jcenter()
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
