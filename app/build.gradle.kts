plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    kotlin("android") version "1.8.22"
}

android {
    namespace = "com.example.myproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myproject"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "CONSUMER_KEY", "\"${project.properties["DARAJA_CONSUMER_KEY"]}\"")
        buildConfigField("String", "CONSUMER_SECRET", "\"${project.properties["DARAJA_CONSUMER_SECRET"]}\"")
    }

    buildTypes {
        getByName("debug") {
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
        mlModelBinding = true
    }
}

repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io") // Ensure JitPack is included
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:21.0.1")
    implementation("com.google.firebase:firebase-database:20.0.3")
    implementation("androidx.viewpager:viewpager:1.0.0")
    implementation("androidx.fragment:fragment:1.3.4")

    // Use the correct navigation dependencies
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    // Lifecycle components (if needed)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("org.tensorflow:tensorflow-lite:2.8.0")
    implementation ("org.tensorflow:tensorflow-lite-support:0.3.1")
    implementation ("org.tensorflow:tensorflow-lite-metadata:0.1.0")

    implementation("com.jakewharton.timber:timber:4.7.1")
    // Check for an updated version or alternative for SweetAlert
    implementation("com.github.f0ris.sweetalert:library:1.6.2")

    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.squareup.retrofit2:converter-gson:2.5.0")
    implementation("com.squareup.okhttp3:okhttp:3.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.12.0")
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("com.squareup.okio:okio:2.1.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
