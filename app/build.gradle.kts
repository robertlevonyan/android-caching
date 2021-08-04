plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  id("realm-android")
  id("io.objectbox")
  id("com.squareup.sqldelight")
}

android {
  compileSdk = 31

  defaultConfig {
    applicationId = "com.robertlevonyan.demo.caching"
    minSdk = 21
    targetSdk = 31

    testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
  }
  buildFeatures {
    viewBinding = true
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
}

realm {
  isSyncEnabled = true
}

dependencies {
  //kotlin
  kotlin("stdlib")

  //common
  implementation("androidx.activity:activity-ktx:1.3.0")
  implementation("androidx.appcompat:appcompat:1.3.1")
  implementation("androidx.constraintlayout:constraintlayout:2.0.4")
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
  implementation("com.google.android.material:material:1.4.0")
  implementation("org.koin:koin-android:2.2.2")
  implementation("org.koin:koin-androidx-viewmodel:2.2.2")
  implementation("io.coil-kt:coil:1.3.0")

  //retrofit
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")
  implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

  //objectbox
  implementation("io.objectbox:objectbox-kotlin:2.8.1")

  //room
  implementation("androidx.room:room-runtime:2.3.0")
  implementation("androidx.room:room-ktx:2.3.0")
  kapt("androidx.room:room-compiler:2.3.0")

  //sqldelight
  implementation("com.squareup.sqldelight:android-driver:1.5.0")
  implementation("com.squareup.sqldelight:coroutines-extensions-jvm:1.5.0")
}
