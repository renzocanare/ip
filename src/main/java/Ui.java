import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Class handling the user interface interactions with the user.
 */
public class Ui {
    protected int ARRAYLIST_PRINT_OFFSET = 1;
    protected String LINE_DIVIDER = "____________________________________________________________";
    protected String EXIT_MESSAGE = LINE_DIVIDER + System.lineSeparator()
            + "Your tasks have been saved! Thanks for talking with me, see you soon!" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String UNKNOWN_COMMAND = LINE_DIVIDER + System.lineSeparator()
            + "Unrecognized command! ☹ Please try again, or type @help for a list of commands." + System.lineSeparator()
            + LINE_DIVIDER;
    protected String DONE_EMPTY = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, you did not select a task to mark as done ☹" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String DELETE_EMPTY = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, you did not select a task to delete ☹" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String DONE_WORD = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, you entered a word instead of a number after done ☹ Please enter the task number to be marked as done!" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String DELETE_WORD = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, you entered a word instead of a number after delete ☹ Please enter the task number to delete!" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String DONE_INVALID_NUM = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, you entered an invalid task number to mark as done! ☹ Please enter the correct task number." + System.lineSeparator()
            + LINE_DIVIDER;
    protected String DELETE_INVALID_NUM = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, you entered an invalid task number to delete! ☹ Please enter the correct task number." + System.lineSeparator()
            + LINE_DIVIDER;
    protected String TODO_EMPTY = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, the TODO description cannot be empty ☹" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String DEADLINE_EMPTY = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, the DEADLINE description cannot be empty ☹" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String DEADLINE_MISSINGPARAM = LINE_DIVIDER + System.lineSeparator()
            + "Woops! Did you forget the /by parameter?" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String DEADLINE_EVENT_DATEPARAM = LINE_DIVIDER + System.lineSeparator()
            + "Woops! Please enter a valid date format YYYY-MM-DD (e.g. 1999-06-14)" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String EVENT_EMPTY = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, the EVENT description cannot be empty ☹" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String EVENT_MISSINGPARAM = LINE_DIVIDER + System.lineSeparator()
            + "Woops! Did you forget the /at parameter?" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String FIND_MISSINGPARAM = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, did you forget to include the keyword you are searching for?" + System.lineSeparator()
            + LINE_DIVIDER;
    protected String FIND_MULTIPLEPARAM = LINE_DIVIDER + System.lineSeparator()
            + "Sorry, please include only one keyword to search for!" + System.lineSeparator()
            + LINE_DIVIDER;

    public void printWelcome() {
        String welcomeMessage = LINE_DIVIDER + System.lineSeparator()
                + "Hello! I'm your friendly taskbot, John!" + System.lineSeparator()
                + "Please type @help for a list of commands. How can I help?" + System.lineSeparator()
                + LINE_DIVIDER;
        System.out.println(welcomeMessage);
    }

    public void printHelp() {
        String helpMessage = LINE_DIVIDER + System.lineSeparator()
                + "todo <task> - Adds a todo task." + System.lineSeparator()
                + "deadline <task> /by <due date> - Adds a deadline task." + System.lineSeparator()
                + "event <task> /at <event date> - Adds an event task." + System.lineSeparator()
                + "list - Lists all tasks recorded." + System.lineSeparator()
                + "find <keyword> - Lists all tasks that have the keyword in their description." + System.lineSeparator()
                + "done <task number> - Marks selected task number as done with an X." + System.lineSeparator()
                + "delete <task number> - Deletes selected task number." + System.lineSeparator()
                + "exit - Saves and exits the taskbot." + System.lineSeparator()
                + LINE_DIVIDER;
        System.out.println(helpMessage);
    }

    public void printAddedTodo(String todoDescription, ArrayList<Task> tasks) {
        String addedMessage = LINE_DIVIDER + System.lineSeparator()
                + "Alright! I've successfully added this task:" + System.lineSeparator()
                + "[T]" + "[ " + "] " + todoDescription + System.lineSeparator()
                + "You now have " + tasks.size() + " tasks in the list!" + System.lineSeparator()
                + LINE_DIVIDER;
        System.out.println(addedMessage);
    }

    public void printAddedDeadline(String deadlineDescription, LocalDate deadlineBy, ArrayList<Task> tasks) {
        String addedMessage = LINE_DIVIDER + System.lineSeparator()
                + "Alright! I've successfully added this task:" + System.lineSeparator()
                + "[D]" + "[ " + "] " + deadlineDescription +
                "(by: " + deadlineBy.format(DateTimeFormatter.ofPattern((Task.DATE_FORMAT))) + ")" + System.lineSeparator()
                + "You now have " + tasks.size() + " tasks in the list!" + System.lineSeparator()
                + LINE_DIVIDER;
        System.out.println(addedMessage);
    }

    public void printAddedEvent(String eventDescription, LocalDate eventAt, ArrayList<Task> tasks) {
        String addedMessage = LINE_DIVIDER + System.lineSeparator()
                + "Alright! I've successfully added this task:"  + System.lineSeparator()
                + "[E]" + "[ " + "] " + eventDescription +
                "(at: " + eventAt.format(DateTimeFormatter.ofPattern((Task.DATE_FORMAT))) + ")" + System.lineSeparator()
                + "You now have " + tasks.size() + " tasks in the list!" + System.lineSeparator()
                + LINE_DIVIDER;
        System.out.println(addedMessage);
    }

    public void printList(ArrayList<Task> tasks) {
        System.out.println(LINE_DIVIDER + System.lineSeparator()
                + "As requested, here are the tasks in your list:");
        if (tasks.size() == 0) {
            System.out.println("There are no tasks recorded!");
        } else {
            for (Task element : tasks) {
                System.out.println((tasks.indexOf(element) + ARRAYLIST_PRINT_OFFSET) + "." + element.toString());
            }
        }
        System.out.println(LINE_DIVIDER);
    }

    public void printLineDivider() {
        System.out.println(LINE_DIVIDER);
    }

    public void printExit() {
        System.out.println(EXIT_MESSAGE);
    }

    public void printUnknownCommand() {
        System.out.println(UNKNOWN_COMMAND);
    }

    public void printDoneEmptyError() {
        System.out.println(DONE_EMPTY);
    }

    public void printDoneWordError() {
        System.out.println(DONE_WORD);
    }

    public void printDoneInvalidNumError() {
        System.out.println(DONE_INVALID_NUM);
    }

    public void printDeleteEmptyError() {
        System.out.println(DELETE_EMPTY);
    }

    public void printDeleteWordError() {
        System.out.println(DELETE_WORD);
    }

    public void printDeleteInvalidNumError() {
        System.out.println(DELETE_INVALID_NUM);
    }

    public void printTodoEmptyError() {
        System.out.println(TODO_EMPTY);
    }

    public void printDeadlineEmptyError() {
        System.out.println(DEADLINE_EMPTY);
    }

    public void printDeadlineMissingParamError() {
        System.out.println(DEADLINE_MISSINGPARAM);
    }

    public void printDeadlineEventDateParamError() {
        System.out.println(DEADLINE_EVENT_DATEPARAM);
    }

    public void printEventEmptyError() {
        System.out.println(EVENT_EMPTY);
    }

    public void printEventMissingParamError() {
        System.out.println(EVENT_MISSINGPARAM);
    }

    public void printTaskMarked(int numToMark, ArrayList<Task> tasks, int DONE_OFFSET) {
        System.out.println(LINE_DIVIDER + System.lineSeparator()
                + "Great work! I've marked this task as done:" + System.lineSeparator()
                + tasks.get(numToMark - DONE_OFFSET).toString() + System.lineSeparator()
                + LINE_DIVIDER);
    }

    public void printDeleteTask(int numToRemove, int DELETE_OFFSET, ArrayList<Task> tasks) {
        System.out.println(LINE_DIVIDER + System.lineSeparator()
                + "Alright! I've removed this task:" + System.lineSeparator()
                + tasks.get(numToRemove - DELETE_OFFSET).toString() + System.lineSeparator()
                + "Now you have " + (tasks.size() - DELETE_OFFSET)+ " tasks remaining in the list." + System.lineSeparator()
                + LINE_DIVIDER);
    }

    public void printMatchedTasks(ArrayList<Task> matchedKeys, ArrayList<Task> tasks)  {
        System.out.println(LINE_DIVIDER + System.lineSeparator()
                + "As requested, here are the matching tasks in your list:");
        if (tasks.size() == 0) {
            System.out.println("There are no tasks recorded!");
        } else if (matchedKeys.size() == 0) {
            System.out.println("The keyword cannot be found!");
        } else {
            int taskCounter = 0;
            for (Task element : matchedKeys) {
                System.out.println(taskCounter + ARRAYLIST_PRINT_OFFSET + ". " + element.toString());
                taskCounter++;
            }
        }
        System.out.println(LINE_DIVIDER);
    }

    public void printFindMissingParamError() {
        System.out.println(FIND_MISSINGPARAM);
    }

    public void printFindMultipleParamError() {
        System.out.println(FIND_MULTIPLEPARAM);
    }
}
