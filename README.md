Online Quiz App (Android + Firebase)

This application is an Android-based quiz app built using Kotlin and Firebase.
It allows users to log in, browse quiz categories, answer multiple-choice questions, and view their results.

Features
1. User Authentication

Users can register using email and password.

Users can log in using email and password.

Google Sign-In is supported for quicker login.

Login information is saved until the user logs out.

2. Quiz System

Quiz categories are loaded from Firebase Firestore.

Each quiz includes:

A title

A subtitle

A timer

A list of multiple-choice questions

Each question contains four options and one correct answer.

The result screen shows total questions, correct answers, and the final score.

3. Firebase Integration

Firebase Authentication is used for login and registration.

Firebase Firestore is used to store:

Quiz categories

Quiz questions

UI and Design Improvements (Assignment 3)

Updated layouts to improve readability and appearance.

Better spacing, color usage, and button styles.

Added a custom launcher icon.

Improved quiz question screen and overall app navigation.

Firebase Security

Firestore rules were added to prevent unauthorized access or editing:

rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /quizzes/{quizId} {
      allow read: if true;
      allow write: if false;
    }
  }
}


This ensures that users can read quiz data but cannot change it.