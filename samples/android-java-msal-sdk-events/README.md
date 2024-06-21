# Office 365 Simple Calendar for Android - Native MSAL & MSGraph SDKs

This sample demonstrates an Android native application with Android Studio that displays events in your Office 365 calendar using an Azure AD application with the Microsoft Graph Android SDK & Microsoft Authentication Library (MSAL).

> This sample is the final result from a training module. Refer to the following repo for additional details including a step-by-step hands-on lab in building this sample: [microsoftgraph/msgraph-training-android](https://github.com/microsoftgraph/msgraph-training-android).

## Sample Details

|               Category               |     Description     |
| ------------------------------------ | ------------------- |
| **Technologies Used**                | Android, Java, MSAL |
| **[Microsoft Graph SDK(s) Used][1]** | Android             |

## Applies to

* [Microsoft Graph](https://developer.microsoft.com/en-us/graph)

## Prerequisites

* Office 365 tenancy
  * If you do not have one, you obtain one (for free) by signing up to the [Office 365 Developer Program](https://developer.microsoft.com/en-us/office/dev-program).
* [Android Studio](https://developer.android.com/studio/) v3.1.2
* [Android SDK](https://developer.android.com/studio/releases/sdk-tools) v26+

## Installation / Working Instructions

1. Create a native Azure AD application using the [App Registration Portal](https://apps.dev.microsoft.com).
    1. Copy the application ID for later use.
    1. Add the **Calendars.Read** delegated permission to the app.
1. Open the application in Android Studio.
    1. Sync the dependencies with the project by selecting **File > Sync Project with Gradle Files**.
    1. Open the **app/src/main/AndroidManifest.xml** and replace the string `{{REPLACE_WITH_APP_ID}}` the previously copied Azure AD application ID.
    1. Open the **app/src/main/java/com.microsoft.nativeo365calendarevents/Constants.java**and replace the string `{{REPLACE_WITH_APP_ID}}` the previously copied Azure AD application ID.
1. Run the application.

## Contributors

| Roles  |                        Author(s)                        |
| ------ | ------------------------------------------------------- |
| Author | Andrew Connell (Microsoft MVP, Voitanos) @andrewconnell |

## Version history

| Version |     Date     |      Comments      |
| ------- | ------------ | ------------------ |
| 1.0     | June 6, 2018 | Initial submission |

[1]: https://developer.microsoft.com/en-us/graph/code-samples-and-sdks

<img src="https://telemetry.sharepointpnp.com/msgraph-community-samples/samples/android-java-msal-sdk-events" />