# QR Scanner with Auto Zoom

A modern Android QR code scanner application featuring auto-zoom functionality using ML Kit's barcode scanning API, built with Jetpack Compose and CameraX.

## Key Features

- **Advanced QR/Barcode Scanning** - Powered by Google ML Kit
- **Auto-Zoom Functionality** - Automatically zooms in on distant QR codes
- **Modern UI** - Built entirely with Jetpack Compose
- **CameraX Integration** - Robust camera handling with lifecycle awareness
- **Real-time Processing** - Instant detection as you point the camera
- **Permission Handling** - Automatic camera permission requests

## Tech Stack

- **UI Framework**: Jetpack Compose
- **Camera Library**: CameraX (with Preview, Analysis, and Capture use cases)
- **Barcode Scanning**: ML Kit Barcode Scanning (com.google.mlkit:barcode-scanning)
- **Permissions Handling**: Accompanist Permissions

## Setup Instructions

### Prerequisites
- Android Studio Giraffe (2022.3.1) or later
- Android device or emulator with camera support (API level 21+)

### Installation
1. Clone the repository:
```bash
git clone https://github.com/indradevelop/QRScanner
```

2. Open the project in Android Studio

3. Build and run the app on your device/emulator

## Usage Guide

1. **Launch the app** - Camera view will appear immediately
2. **Point at QR code** - Position the QR code within the viewfinder
3. **Automatic zoom** - The app will automatically zoom in on distant codes
4**Scan result** - Detected codes will appear as an overlay and in system logs

## Implementation Highlights

### Auto-Zoom Logic
```kotlin
val options = BarcodeScannerOptions.Builder()
   .setBarcodeFormats(Barcode.FORMAT_QR_CODE)
   .setZoomSuggestionOptions(
      ZoomSuggestionOptions.Builder { zoomRatio ->
         try {
            cameraControl?.setZoomRatio(zoomRatio)
         } catch (e: Exception) {
            Log.e("native_scanner", "Error enabling zoom", e)
         }
         true
      }.setMaxSupportedZoomRatio(5f).build()
   )
   .build()
BarcodeScanning.getClient(options)
```