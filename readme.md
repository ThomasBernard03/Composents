[![Android CI](https://github.com/ThomasBernard03/Composents/actions/workflows/main.yml/badge.svg?branch=main)](https://github.com/ThomasBernard03/Composents/actions/workflows/main.yml)
[![](https://jitpack.io/v/ThomasBernard03/Composents.svg)](https://jitpack.io/#ThomasBernard03/Composents)


##

In settings.gradle.kts add jitpack repository :
```kotlin
repositories {
    google()
    mavenCentral()
    maven { url = uri("https://jitpack.io" ) } // This line
}
```

Then you can add dependency :
```kotlin
implementation("com.github.ThomasBernard03:Composents:version")
```