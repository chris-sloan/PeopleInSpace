plugins {
    id("com.android.application")
    kotlin("android")
    id("com.github.ben-manes.versions")
}

android {
    compileSdk = Versions.androidCompileSdk

    defaultConfig {
        applicationId = "com.surrus.peopleinspace"
        minSdk = Versions.androidMinSdk
        targetSdk = Versions.androidTargetSdk

        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
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

    packagingOptions {
        resources.excludes.add("META-INF/licenses/**")
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
    namespace = "com.surrus.peopleinspace"
}

dependencies {
    with(Deps.Android) {
        implementation(osmdroidAndroid)
    }

    with(Deps.AndroidX) {
        implementation(lifecycleRuntimeCompose)
        implementation(lifecycleRuntimeKtx)
        implementation(lifecycleViewmodelKtx)
        implementation(activityCompose)
        implementation(material3)
        implementation(material3WindowSizeClass)
        implementation(splashScreen)
    }

    with(Deps.Glance) {
        implementation(appwidget)
    }

    with(Deps.Compose) {
        implementation(compiler)
        implementation(ui)
        implementation(uiGraphics)
        implementation(foundationLayout)
        implementation(material)
        implementation(navigation)
        implementation(coilCompose)
        implementation(accompanistSwipeRefresh)
        implementation(uiTooling)
    }

    with(Deps.Koin) {
        implementation(core)
        implementation(android)
        implementation(compose)
        testImplementation(test)
        testImplementation(testJUnit4)
    }

    with(Deps.Test) {
        testImplementation(junit)
        androidTestImplementation(androidXTestJUnit)
        testImplementation(testCore)
        testImplementation(robolectric)
        testImplementation(mockito)

        // Compose testing dependencies
        androidTestImplementation(composeUiTest)
        androidTestImplementation(composeUiTestJUnit)
        androidTestImplementation(composeNavTesting)
        debugImplementation(composeUiTestManifest)

    }

    implementation(project(":common"))
}