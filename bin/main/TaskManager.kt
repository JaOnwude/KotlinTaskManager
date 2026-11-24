/**
 * Stores tasks and provides operations for changing and summarizing the collection.
 */
class TaskManager {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1

    /**
     * Adds a task when the supplied title contains non-whitespace text.
     * Returns true when the task was added and false when the title was empty.
     */
    fun addTask(title: String): Boolean {
        val cleanTitle = title.trim()
        if (cleanTitle.isEmpty()) {
            return false
        }

        val task = Task(id = nextId, title = cleanTitle)
        tasks.add(task)
        nextId += 1
        return true
    }

    /**
     * Returns a read-only copy so callers cannot directly change the stored list.
     */
    fun getTasks(): List<Task> {
        return tasks.toList()
    }

    /**
     * Finds a task by its ID, or returns null when no task has that ID.
     */
    fun findTask(id: Int): Task? {
        return tasks.find { task -> task.id == id }
    }

    /**
     * Marks the matching task complete, returning false if it is missing or already complete.
     */
    fun markCompleted(id: Int): Boolean {
        val taskIndex = tasks.indexOfFirst { task -> task.id == id }
        if (taskIndex == -1) {
            return false
        }

        val selectedTask = tasks[taskIndex]
        if (selectedTask.isCompleted) {
            return false
        }

        tasks[taskIndex] = selectedTask.copy(isCompleted = true)
        return true
    }

    /**
     * Removes the task with the given ID and reports whether a task was removed.
     */
    fun removeTask(id: Int): Boolean {
        return tasks.removeAll { task -> task.id == id }
    }

    /**
     * Counts completed tasks and returns the result as a pair: total, completed.
     */
    fun getTaskCounts(): Pair<Int, Int> {
        val total = tasks.size
        val completed = tasks.count { task -> task.isCompleted }
        return Pair(total, completed)
    }

    /**
     * Returns the remaining task count using the total and completed counts.
     */
    fun getRemainingCount(): Int {
        val (total, completed) = getTaskCounts()
        return total - completed
    }
}
