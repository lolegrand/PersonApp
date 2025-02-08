# Multiplatform Test App Repository

This repository contains a multiplatform test application that includes both native and multiplatform components. The project is structured to support Android, iOS, and Compose Multiplatform (CMP) applications, with a shared KMP (Kotlin Multiplatform) library for backend data retrieval. The application is built using Clean Architecture principles to ensure separation of concerns, testability, and scalability.

# Project Overview

The application is a Person Generator that leverages the Random User API to fetch and display random user profiles. It demonstrates how to build a multiplatform application with shared business logic while maintaining platform-specific UIs.

# Key Features:

Random User Generation: Fetches random user data from the Random User API.

Multiplatform Support: Works on Android (native), iOS (native), and Compose Multiplatform (in progress).

Clean Architecture: Follows Clean Architecture principles for modularity and maintainability.

Shared Business Logic: Uses Kotlin Multiplatform (KMP) to share data retrieval and business logic across platforms.

# Project Structure

The repository is organized into several modules, following Clean Architecture:

## 1. App Android (Native)
A native Android application built with standard Android tools and libraries.

Location: androidApp/

Dependencies:

Android SDK
Kotlin
Android Jetpack Libraries (ViewModel, Flow, etc.)

## 2. App iOS (Native)
A native iOS application built with Swift and the iOS SDK.

Location: iosApp/

Dependencies:

iOS SDK
Swift

## 3. App Compose Multiplatform (CMP)
A multiplatform application using Jetpack Compose for shared UI across Android and iOS. ** This module is currently a work in progress. **

Location: composeApp/

Dependencies:

Jetpack Compose
Kotlin Multiplatform
Shared KMP Library

## 4. Libs (KMP)
A shared Kotlin Multiplatform library responsible for backend data retrieval and business logic. This module is the core of the Clean Architecture, containing the data and domain layers.

Location: data/

Dependencies:

Kotlin Multiplatform
Ktor (for networking)
Kotlinx Serialization (for JSON parsing)
Room (for caching)

# Clean Architecture
The project follows Clean Architecture principles to ensure separation of concerns and modularity. The architecture is divided into three main layers:

## Presentation Layer:

Contains platform-specific UI code (Android, iOS, Compose Multiplatform).
Communicates with the domain layer to fetch and display data.

## Domain Layer:

Contains the core business logic and use cases.
Defines interfaces for data repositories.
Platform-agnostic and shared across all platforms via KMP.

## Data Layer:

Implements the data repositories defined in the domain layer.
Handles data retrieval from the Random User API.
Shared across platforms via the KMP module.

## Application: Person Generator

The application generates random user profiles using the Random User API. Here's how it works:

## Data Fetching:

The KMP library (libs/) makes an HTTP request to the Random User API using Ktor.
The response is parsed using Kotlinx Serialization and mapped to domain models.

## Business Logic:

The domain layer defines use cases (e.g., GetRandomUserUseCase) to fetch and process data.

The presentation layer (Android, iOS, CMP) calls these use cases to retrieve data.

## UI Display:

The Android and iOS apps display the user data in their native UIs.

The Compose Multiplatform app (in progress) will provide a shared UI for both platforms.
