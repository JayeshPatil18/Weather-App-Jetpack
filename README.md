<div align="left">
  <h1>Weather App - Jetpack Compose 🌦️</h1>
  <img alt="Android" src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" style="margin-left: 10px;">
  <img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white" style="margin-left: 10px;">
  <img alt="Retrofit" src="https://img.shields.io/badge/Retrofit-00D0FF?style=for-the-badge&logo=retrofit&logoColor=white" style="margin-left: 10px;">
  <a href="https://github.com/JayeshPatil18/Weather-App-Jetpack">
    <img alt="GitHub" src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" style="margin-left: 10px;">
  </a>
</div>
</br>

Welcome to **Weather App - Jetpack Compose**, a modern Android application built using Jetpack Compose for real-time weather updates. This app allows you to search for weather information by location (city) and provides detailed weather updates including humidity, wind speed, UV index, and more.

</br>

*Available Soon on Play Store.*

![Available](https://github.com/JayeshPatil18/Weather-App-Jetpack/blob/master/weather-app.jpg)


## Features

- **Real-time Weather Updates**: Get up-to-date weather information based on your location search.
- **Detailed Weather Information**: View details such as humidity, wind speed, UV index, and more.
- **Search Functionality**: Easily search for weather updates by entering the city name.

## Technology Used

- **Android**: Built using modern Android development practices.
- **Jetpack Compose**: For building reactive and composable UIs.
- **Kotlin**: Programming language for Android app development.
- **Retrofit**: HTTP client for making network requests to WeatherAPI.com.
- **WeatherAPI.com**: Provides weather data including current weather, forecasts, and more.


### Key Components:

- **`build.gradle`**: Configuration file for Gradle build system.
- **`settings.gradle`**: Settings file that includes all modules in the project.
- **`AndroidManifest.xml`**: Describes the fundamental characteristics of the app and defines each of its components.
- **`java/`**: Contains Java (or Kotlin) source code for the app.
- **`res/`**: Contains resources used by the app such as images, layouts, strings, and styles.
- **`drawable/`**: Stores drawable resources like images and XML drawables.
- **`layout/`**: Contains XML files that define the layout structure of activities and fragments.
- **`mipmap/`**: Contains launcher icons for different densities.
- **`values/`**: Contains XML files for various values such as strings, styles, dimensions, colors, and more.
- **`test/`**: Contains test code for the app, typically used for unit tests.

This structure provides a basic overview of how an Android project is organized, with directories for source code, resources, tests, and configuration files. Adjustments can be made based on specific project requirements or additional modules included in the project.


## Getting Started

To get started with **MSBTE Aspirants**, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/JayeshPatil18/MSBTE-Aspirants.git
   
## Install Android Studio

Download and install [Android Studio](https://developer.android.com/studio). Follow the installation instructions for your operating system.

## Set up Android SDK

1. Open Android Studio.
2. Navigate to `File > Settings > Appearance & Behavior > System Settings > Android SDK`.
3. **SDK Platforms tab:**
   - Ensure that `Android 10 (Q)` is checked or installed.
   
4. **SDK Tools tab:**
   - Install the latest version of `Android SDK Build-Tools`.

## Set up Android SDK

1. Open Android Studio.
2. Go to `File > Settings > Appearance & Behavior > System Settings > Android SDK`.
3. **SDK Platforms tab**:
   - Ensure that `Android 10 (Q)` is checked or installed.

4. **SDK Tools tab**:
   - Install the latest version of `Android SDK Build-Tools`.

## Install Java Development Kit (JDK)

Ensure you have JDK 8 or higher installed. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html).


## Install Dependencies

Open a terminal in the project directory and run:

```bash
./gradlew build
```

## Connect Your Device

### For Physical Device

1. Enable `Developer Options` and `USB Debugging` on your Android device.
   - Go to `Settings` > `About phone`.
   - Tap on `Build number` multiple times until it says you are now a developer.
   - Go back to `Settings` > `Developer options`.
   - Enable `USB debugging`.

2. Connect your device to your computer via USB.

### For Virtual Device

1. Open Android Studio.
2. Go to `Tools` > `AVD Manager`.
3. Click on `Create Virtual Device`.
4. Choose a hardware profile and click `Next`.
5. Select a system image (Android version) and click `Next`.
6. Customize the virtual device configuration as needed (e.g., RAM size, VM heap size) and click `Finish`.
7. Start the virtual device by clicking the `Play` button next to the device name in the AVD Manager.
