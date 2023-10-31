plugins {
  id("com.android.application") version "8.1.2" apply false
  id("com.android.library") version "8.1.2" apply false
  id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
  //realm
  id("io.realm.kotlin") version "1.11.1" apply false
  //objectbox
  id("io.objectbox") version "3.7.0" apply false
  //sqldelight
  id("app.cash.sqldelight") version "2.0.0" apply false
  kotlin("android") version "1.9.10" apply false
}

tasks.register("clean", Delete::class) {
  delete(layout.buildDirectory)
}
