/**
 * Copyright Trian Damai 2022 triandamai@gmail.com
 *
 * */
plugins {
    id("com.android.library")
    id("com.google.gms.google-services")
    kotlin("android")
    kotlin("kapt")

}


android{
    compileSdk = 31
    defaultConfig {
        minSdk = 23
        targetSdk = 30

    }

    compileOptions {
        // Flag to enable support for the new language APIs
        isCoreLibraryDesugaringEnabled =true

        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {

    //Loads packaged libraries in the libs folder
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")


    implementation(Libs.JodaTime.jodaTime)

    implementation(Libs.Com.Squareup.Logcat.logcat)

    //firebase
    with(Libs.Com.Google.Firebase) {
        implementation(platform(bom))
        implementation(auth)
        implementation(firestore)
        implementation(storage)
        implementation(messaging)
        implementation(crashlytics)
        implementation(analytics)
        implementation(functions)

    }


    //allow use await() in firebase task
    with(Libs.Org.Jetbrains.Kotlinx) {
        implementation(googlePlayKotlinCoroutine)
    }

    implementation(Libs.Com.Squareup.Retrofit2.gsonFactory)


}
