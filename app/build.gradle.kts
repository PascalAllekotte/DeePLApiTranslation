plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    //Moshi
    id("kotlin-kapt")
}

android {
    namespace = "com.example.deeplapitranslation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.deeplapitranslation"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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



    // Viewbinding aktivieren


    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //Moshi
    implementation("com.squareup.moshi:moshi:1.15.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")

    // Retrofit und Moshi Konverter
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

    // OkHttp für Retrofit
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")

    // JSON
    implementation ("org.json:json:20230227")
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}