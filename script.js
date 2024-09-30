// Grab the DOM elements
const taskInput = document.getElementById("new-task");
const addTaskButton = document.getElementById("add-task");
const taskList = document.getElementById("task-list");

// Function to add a new task
function addTask() {
    const taskName = taskInput.value.trim();
    if (taskName === "") return;

    // Create new list item
    const li = document.createElement("li");

    // Create task span (text)
    const taskSpan = document.createElement("span");
    taskSpan.textContent = taskName;

    // Create complete button
    const completeButton = document.createElement("button");
    completeButton.textContent = "Complete";
    completeButton.classList.add("complete-btn");
    completeButton.onclick = () => completeTask(li);

    // Create delete button
    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Delete";
    deleteButton.classList.add("delete-btn");
    deleteButton.onclick = () => deleteTask(li);

    // Append elements to the list item
    li.appendChild(taskSpan);
    li.appendChild(completeButton);
    li.appendChild(deleteButton);

    // Add the new list item to the task list
    taskList.appendChild(li);

    // Clear input field
    taskInput.value = "";
}

// Function to mark a task as completed
function completeTask(taskItem) {
    taskItem.classList.toggle("completed");
}

// Function to delete a task
function deleteTask(taskItem) {
    taskItem.remove();
}

// Event listener for the Add Task button
addTaskButton.addEventListener("click", addTask);

// Optional: Enable pressing "Enter" to add tasks
taskInput.addEventListener("keypress", (event) => {
    if (event.key === "Enter") {
        addTask();
    }
});
