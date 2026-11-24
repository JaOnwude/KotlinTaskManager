private val taskManager = TaskManager()

/**
 * Starts the task manager and keeps displaying the menu until the user exits.
 */
fun main() {
    println("Welcome to Kotlin Task Manager")
    var isRunning = true

    while (isRunning) {
        displayMenu()
        val menuChoice = readlnOrNull()
        if (menuChoice == null) {
            println("\nInput stream closed. Exiting the Task Manager.")
            return
        }

        when (menuChoice.trim()) {
            "1" -> addTaskFromInput()
            "2" -> displayTasks()
            "3" -> completeTaskFromInput()
            "4" -> removeTaskFromInput()
            "5" -> displaySummary()
            "0" -> {
                println("Goodbye. Your tasks will be cleared when the program closes.")
                isRunning = false
            }
            else -> println("Please enter a number from 0 to 5.")
        }
    }
}

/**
 * Prints the available actions for the user.
 */
private fun displayMenu() {
    println()
    println("--- Task Manager ---")
    println("1. Add a task")
    println("2. View tasks")
    println("3. Mark a task complete")
    println("4. Remove a task")
    println("5. View task summary")
    println("0. Exit")
    print("Choose an option: ")
}

/**
 * Reads a title and asks the manager to add it to the collection.
 */
private fun addTaskFromInput() {
    print("Enter a task title: ")
    val title = readlnOrNull().orEmpty()
    val wasAdded = taskManager.addTask(title)

    if (wasAdded) {
        println("Task added successfully.")
    } else {
        println("A task title cannot be blank.")
    }
}

/**
 * Displays every task with its ID and completion status.
 */
private fun displayTasks() {
    val tasks = taskManager.getTasks()
    if (tasks.isEmpty()) {
        println("There are no tasks yet.")
        return
    }

    println("\nYour tasks:")
    for (task in tasks) {
        val status = if (task.isCompleted) "Complete" else "Not complete"
        println("${task.id}. [$status] ${task.title}")
    }
}

/**
 * Reads a task ID and marks that task complete when it exists and is not already complete.
 */
private fun completeTaskFromInput() {
    val taskId = readTaskId("Enter the ID to complete: ") ?: return
    val wasUpdated = taskManager.markCompleted(taskId)

    if (wasUpdated) {
        println("Task $taskId marked complete.")
    } else if (taskManager.findTask(taskId) != null) {
        println("That task is already complete.")
    } else {
        println("No task has ID $taskId.")
    }
}

/**
 * Reads a task ID and removes the matching task from the collection.
 */
private fun removeTaskFromInput() {
    val taskId = readTaskId("Enter the ID to remove: ") ?: return
    if (taskManager.removeTask(taskId)) {
        println("Task $taskId removed.")
    } else {
        println("No task has ID $taskId.")
    }
}

/**
 * Prompts for an ID and returns a positive integer, or null for invalid input.
 */
private fun readTaskId(prompt: String): Int? {
    print(prompt)
    val enteredText = readlnOrNull()?.trim()
    val taskId = enteredText?.toIntOrNull()

    if (taskId == null || taskId < 1) {
        println("Enter a positive whole number for the task ID.")
        return null
    }
    return taskId
}

/**
 * Displays total, completed, and remaining task counts.
 */
private fun displaySummary() {
    val (total, completed) = taskManager.getTaskCounts()
    val remaining = taskManager.getRemainingCount()
    val completionRate = if (total == 0) 0 else completed * 100 / total

    println("\nTask summary")
    println("Total tasks: $total")
    println("Completed: $completed")
    println("Remaining: $remaining")
    println("Completion rate: $completionRate%")
}





