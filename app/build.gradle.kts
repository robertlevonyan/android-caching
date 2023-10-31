plugins {
  id("com.android.application")
  kotlin("android")
  id("com.google.devtools.ksp")
  id("io.realm.kotlin")
  id("io.objectbox")
  id("app.cash.sqldelight")
}

android {
  compileSdk = 34
  namespace = "com.robertlevonyan.demo.caching"

  defaultConfig {
    applicationId = "com.robertlevonyan.demo.caching"
    minSdk = 21
    targetSdk = 34

    testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
  }
  buildFeatures {
    viewBinding = true
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
}

dependencies {
  //common
  implementation("androidx.activity:activity-ktx:1.8.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
  implementation("com.google.android.material:material:1.10.0")
  implementation("io.insert-koin:koin-android:3.5.0")
  implementation("io.coil-kt:coil:2.4.0")

  //retrofit
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")
  implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")

  //objectbox
  implementation("io.objectbox:objectbox-kotlin:3.7.0")

  //room
  implementation("androidx.room:room-runtime:2.6.0")
  implementation("androidx.room:room-ktx:2.6.0")
  ksp("androidx.room:room-compiler:2.6.0")

  //sqldelight
  implementation("com.squareup.sqldelight:android-driver:1.5.5")
  implementation("com.squareup.sqldelight:coroutines-extensions-jvm:1.5.5")
}
