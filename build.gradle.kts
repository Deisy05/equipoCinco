buildscript {
    val agp_version by extra("8.1.0")
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
    id("com.google.dagger.hilt.android") version "2.47" apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
}