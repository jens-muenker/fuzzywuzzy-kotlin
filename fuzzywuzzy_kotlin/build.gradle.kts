plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.frosch2010.fuzzywuzzy_kotlin"
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
                "proguard-rules.pro"
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
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation( "org.mockito:mockito-core:+")
    androidTestImplementation("org.mockito:mockito-android:+")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")
}

publishing {
    publications {
        create<MavenPublication>("release") {

            groupId = "com.frosch2010"
            artifactId = "fuzzywuzzy_kotlin"
            version = "1.0.0"

            pom {
                name.set("fuzzywuzzy-kotlin")
                description.set("fuzzywuzzy-kotlin is an Android library for string matching based on the JavaWuzzy Python algorithm. The algorithm uses Levenshtein distance to calculate similarity between strings.")
                url.set("https://github.com/frosch2010/fuzzywuzzy-kotlin")
                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
            }

            afterEvaluate {
                from(components["release"])
            }
        }
    }

    repositories {
        maven {
            url = uri("https://jitpack.io")
        }
    }
}