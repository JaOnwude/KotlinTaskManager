/**
 * Represents one task in the task manager.
 * The data class provides useful value behavior, including `copy` for updates.
 */
data class Task(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false
)
