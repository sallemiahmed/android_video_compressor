
# Android Video Compressor

An Android application that allows users to select, compress, and save videos using FFmpeg without losing quality. This project provides a simple interface for selecting videos, choosing an output directory, and compressing the selected video files on Android.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Building the APK](#building-the-apk)
- [Contributing](#contributing)
- [License](#license)

## Features
- Select videos from device storage.
- Compress video files to reduce size without significant quality loss.
- Set output directory for saving compressed videos.
- Portrait mode layout for ease of use.

## Requirements
- Android SDK (version 30 or higher)
- Gradle 7.0.2 or higher
- Java 11
- FFmpeg (integrated via Mobile FFmpeg library)

## Installation

### Clone the Repository
Clone this repository to your local machine:
```bash
git clone https://github.com/sallemiahmed/android_video_compressor.git
cd android_video_compressor
```

### Set Up the Android SDK Path
To ensure Gradle can locate the Android SDK, define the `ANDROID_SDK_ROOT` environment variable or set the SDK path in `local.properties`:
1. **Using Environment Variable**:
   ```bash
   export ANDROID_SDK_ROOT=/path/to/your/android-sdk
   ```
2. **Using `local.properties`**:
   Create a file named `local.properties` in the project root and add the following line:
   ```properties
   sdk.dir=/path/to/your/android-sdk
   ```

### Install Dependencies
Make sure your dependencies are up-to-date:
```bash
gradle clean
gradle build
```

## Usage
1. Open the app and click **Select Video** to choose a video file from your storage.
2. Click **Compress Video** to start the compression process.
3. The compressed video will be saved in the selected output directory.

## Building the APK

To build the APK from the command line:
1. Navigate to the project root directory:
   ```bash
   cd /path/to/android_video_compressor
   ```

2. Run the Gradle build command:
   ```bash
   gradle clean assembleDebug
   ```

3. The APK file will be generated in:
   ```
   app/build/outputs/apk/debug/app-debug.apk
   ```

### Install the APK
To install the APK on an emulator or Android device using `adb`:
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

## Contributing
Feel free to open issues or submit pull requests to help improve this project. Ensure that you adhere to code style guidelines and thoroughly test your contributions.

## License
This project is open source and available under the [MIT License](LICENSE).
