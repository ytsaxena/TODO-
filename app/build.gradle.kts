plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.anonymous.surveyheartllp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.anonymous.surveyheartllp"
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
buildFeatures{
    viewBinding = true
}

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.retrofit)
    androidTestImplementation(libs.androidx.runner)

// GSON

    implementation(libs.converter.gson)

// coroutine

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.kotlinx.coroutines.core)


        // To use the androidx.test.core APIs
        androidTestImplementation("androidx.test:core:1.6.1")
        // Kotlin extensions for androidx.test.core
        androidTestImplementation("androidx.test:core-ktx:1.6.1")

        // To use the androidx.test.espresso
        androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

        // To use the JUnit Extension APIs
        androidTestImplementation("androidx.test.ext:junit:1.2.1")
        // Kotlin extensions for androidx.test.ext.junit
        androidTestImplementation("androidx.test.ext:junit-ktx:1.2.1")

        // To use the Truth Extension APIs
        androidTestImplementation("androidx.test.ext:truth:1.6.0")

        // To use the androidx.test.runner APIs
        androidTestImplementation("androidx.test:runner:1.6.1")

        // To use android test orchestrator
        androidTestUtil("androidx.test:orchestrator:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")

}

