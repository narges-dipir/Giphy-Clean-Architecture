plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.narcis.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("com.github.ihsanbal:LoggingInterceptor:3.1.0") {
        exclude("org.json", "json")
    }

    // test
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.strikt:strikt-core:0.34.1")
    testImplementation("io.mockk:mockk:1.13.4")
    testImplementation("app.cash.turbine:turbine:0.12.1") // For Flow testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.10")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    implementation("com.google.dagger:hilt-android-testing:2.48")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    implementation("com.squareup.okhttp3:mockwebserver:4.11.0")
    debugImplementation("androidx.test:monitor:1.6.0")
    // serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.6.0")
    // Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.46.1")
}
