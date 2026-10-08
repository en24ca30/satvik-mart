# Satvik Mart - 15-30 Minute Home Delivery

Satvik Mart is an original Android quick-commerce app for Indian home essentials, groceries, wellness, household, pooja, and daily essentials.

## Overview

The app provides a polished demo shopping experience inspired by modern Indian grocery delivery services, while keeping all branding and visuals original.

## Features

- 15-30 minute delivery promise
- 100+ products across 12 categories
- Search with suggestions and filters
- Local Room database with demo data
- Wishlist, cart, checkout, coupons
- UPI QR demo payment and COD mode
- Order tracking and order history
- Offline-first local persistence
- Admin/demo dashboard flag
- Compose material app with MVVM architecture

## Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- Room Database
- Coroutines + Flow + StateFlow
- Navigation Compose
- DataStore
- Retrofit + OkHttp
- Coil image loading
- ZXing QR generation

## Requirements

- Android Studio Hedgehog or newer
- JDK 17+
- Android SDK 34
- Emulator or device

## Running

1. Open the project in Android Studio.
2. Let Gradle sync.
3. Select an emulator or device.
4. Run the app module.

## Demo Login

- Mobile: `9999999999`
- OTP: `123456`

## Demo UPI

- UPI ID: `quickcartdemo@upi`
- This is a demo-only identifier used in the app.

## Demo Coupons

- `SATVIK50`
- `WELCOME100`
- `SAVE10`
- `FIRSTORDER`

## Building APK/AAB

### Debug APK
- `./gradlew assembleDebug`

### Release APK
- `./gradlew assembleRelease`

### Release AAB
- `./gradlew bundleRelease`

## Release Signing

Use Android Studio:
- Build -> Generate Signed Bundle / APK
- Create a keystore or use an existing one
- Never commit actual signing keys to source control

## Project Structure

- `app/src/main/java/com/satvikmart/data` - database, repositories, model
- `app/src/main/java/com/satvikmart/ui` - screens, components, navigation
- `app/src/main/java/com/satvikmart/theme` - colors and themes
- `app/src/main/res` - resources and launcher assets

## Future Integration

- Replace demo auth with Firebase or backend auth
- Connect Room to API using Retrofit repositories
- Integrate actual payment gateway behind the `PaymentRepository` abstraction

## Troubleshooting

- If Gradle sync fails, ensure JDK 17 is installed and selected
- If emulator fails, use x86 or armv8 images with hardware acceleration
- Clear app data if Room DB is stale

## Notes

This app is an original demo implementation for Satvik Mart, with all branding and assets created for the app.
