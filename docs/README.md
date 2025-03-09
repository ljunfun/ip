# Caifan User Guide

```
Hello! I'm Caifan!
What can I do for you sweetheart <3?
```

Caifan is a simple command-line based desktop application that acts as a task manager that helps you keep track of your 
todos, deadlines, and events.

## Table of Contents
1. [Quick Start](#quick-start)
2. [Features](#features)
    - [Adding Tasks](#adding-tasks)
        - [Adding a Todo](#1-adding-a-todo)
        - [Adding a Deadline](#2-adding-a-deadline)
        - [Adding an Event](#3-adding-an-event)
    - [Managing Tasks](#managing-tasks)
        - [Listing Tasks](#1-listing-tasks)
        - [Marking Tasks as Done](#2-marking-tasks-as-done)
        - [Unmarking Tasks](#3-unmarking-tasks)
        - [Deleting Tasks](#4-deleting-tasks)
        - [Finding Tasks](#5finding-tasks)
    - [Saving and Exiting the Application](#saving-and-exiting-the-application)

## Quick Start
1. Ensure that you have `Java 17` or above installed on your computer.
2. Download the `.jar` file from (placeholder)
3. Copy the file to the directory you want to use as the home directory for your task tracker

## Features
### Adding Tasks
Caifan allows you to add tasks to your task list. There are three types of tasks that you can add:
- Todo
- Deadline
- Event

#### 1. Adding a Todo 
Adds a simple task without any timing information.

Command `todo DESCRIPTION`
Example: ` todo read book`

```
added this for you my love <3:
  [T][ ] read book
Now you have 1 tasks in the list.
```

#### 2. Adding a Deadline
Adds a task with a specific deadline.  

Command: `deadline DESCRIPTION /by DEADLINE`  
Example: `deadline submit report /by Friday 5pm`

```
added this for you my love <3:
  [D][ ] submit report (by: Friday 5pm)
Now you have 2 tasks in the list.
```

#### 3. Adding an Event
Adds a task with its individual start and end times.

Command: `event DESCRIPTION /from START /to END`
Example: `event team meeting /from Mon 2pm /to Mon 4pm`

```
added this for you my love <3:
  [E][ ] team meeting (from: Mon 2pm to: Mon 4pm)
Now you have 3 tasks in the list.
```

### Managing Tasks
#### 1. Listing Tasks
Shows all the tasks in the list, as tracked by the application.

Command: `list`
Example: 

```
Here is your To-do List!!
1.[T][ ] read book
2.[D][ ] submit report (by: Friday 5pm)
3.[E][ ] team meeting (from: Mon 2pm to: Mon 4pm)
```

#### 2. Marking Tasks as Done
Marks a task at the specific index as completed.
The index must be a positive integer, and must be the index of an existing task in the task list. 
(i.e. index must be smaller than or equal to current size of task list.)

Command: `mark TASK_NUMBER`
Example: `mark 1`

```
YAY!! You have completed it :D
  [T][✓] read book
```

#### 3. Unmarking Tasks
Changes a completed task back to not done. This is to revert the marked status of a task back to undone.
The index must be a positive integer, and must be the index of an existing task in the task list.
(i.e. index must be smaller than or equal to current size of task list.)

Command: `unmark TASK_NUMBER`
Example: `unmark 1`

```
Get your lazy ass up and finish this >_< 
  [T][ ] read book
```

#### 4. Deleting Tasks
Removes a task from the list.
The index must be a positive integer, and must be the index of an existing task in the task list.
(i.e. index must be smaller than or equal to current size of task list.)

Command: `delete TASK_NUMBER`
Example: `delete 1`

```
Okie Dookie! I've removed this task:
  [T][ ] read book
Now you have 2 tasks in the list.
```

#### 5.Finding Tasks
Searches for tasks containing specific keywords.

Command: `find KEYWORD`
Example: `find meeting`

```
Here are some matching tasks in the list ᕕ(╯°□°)ᕗ:
1.[E][ ] team meeting (from: Mon 2pm to: Mon 4pm)
```

Example: `find nonsense`

```
No matching tasks found TT
```

### Saving and Exiting the Application
All changes are automatically saved into a `data` folder, within `Caifan.txt` file.
Use `bye` to exit the application.

Example:
```
Bye byeee!! Hope to see you again soon <3
```