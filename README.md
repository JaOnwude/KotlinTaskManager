# Overview

Kotlin Task Manager is a console application for organizing a personal task list. A user can add tasks, view the task list, mark a task complete, remove a task, and see a completion summary. Tasks are kept in memory while the program is running.

I am using this software to practice Kotlin syntax and object-oriented structure with a small application. It demonstrates mutable and immutable variables, expressions, conditionals, loops, functions, classes, and collection changes. The `Task` data class and its `copy` function demonstrate the data-class stretch challenge.

Replace the link below with the public or unlisted YouTube URL after recording the 4–5 minute software demonstration and code walkthrough.

[Software Demo Video](https://youtu.be/qwoddDFGsTg)

# Development Environment

The project is configured for IntelliJ IDEA and uses Gradle to build and run the Kotlin/JVM application. It targets JDK 21 and uses Kotlin Gradle Plugin 2.4.21. The program uses only the Kotlin standard library; it has no additional application libraries.

The code is organized into `Task.kt` for the task data class, `TaskManager.kt` for collection operations, and `Main.kt` for the menu and console interaction.

On Windows, open a terminal in the project folder and run `.\gradlew.bat run`. The first run downloads the Gradle distribution and Kotlin plugin. IntelliJ IDEA can also import this folder as a Gradle project and run `MainKt`.

# Useful Websites

- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Kotlin Basic Syntax](https://kotlinlang.org/docs/basic-syntax.html)
- [Kotlin Collections](https://kotlinlang.org/docs/collections-overview.html)
- [CSE 310 Kotlin Module Description](https://byui-cse.github.io/cse310-ww-course/modules/module_descriptions.html)

# Future Work

- Save tasks to a file so they remain available after the program closes.
- Let users edit task titles.
- Add due dates and categories.