import java.io.IOException;

class Parser {
    static Command parse(String fullCommand) throws InvalidDataException {
        String[] commandArray = fullCommand.split(" ", 3);
        String firstWord = commandArray[0];
        Command c;
        switch (firstWord) {
            case "list":
                c = new ListCommand();
                return c;
            case "delete":
                // consider inserting exception here for invalid size of array
                int deleteIndex = Integer.parseInt(commandArray[1]);
                c = new DeleteCommand(deleteIndex);
                return c;
            case "done":
                // consider inserting exception here for invalid size of array
                int doneIndex = Integer.parseInt(commandArray[1]);
                c = new DoneCommand(doneIndex);
                return c;
            case "deadline":
            case "event":
            case "todo":
                try {
                    String[] taskDetails = getTaskDetails(firstWord, fullCommand);
                    c = new AddCommand(taskDetails);
                    return c;
                } catch (InvalidDataException e){
                    throw new InvalidDataException("Invalid input. Please try again.");
                }
            case "find":
                try {
                    String keywords;
                    keywords = fullCommand.split("find ", 2)[1];
                    c = new findCommand(keywords);
                    return c;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new InvalidDataException("please enter a keyword with the find term.");
                }
            case "bye":
                try {
                    c = new byeCommand();
                    return c;
                } catch (IOException e) {
                    e.getMessage();
                }
            default:
                throw new InvalidDataException("Invalid input. Please try again.");
        }
    }

    /**
     * Function that parses string to get task details
     * @param fullCommand user initial input
     * @param taskType task type
     * @return Array of strings that contain the task details in the order [Task type, task description, time if relevant]
     * @throws InvalidDataException when there is missing fields in user input.
     */
    private static String[] getTaskDetails(String taskType, String fullCommand) throws InvalidDataException{
        String description;
        String[] taskDetails = new String[0];
        String[] splitCommand = fullCommand.split(" ", 2);
        if (splitCommand.length == 1) {
            throw new InvalidDataException("please add a description.");
        }
        if (taskType.equals("todo")) {
            try {
                description = splitCommand[1];
                taskDetails = new String[]{taskType, description};
            } catch (Exception e) {
                System.out.println("invalid description");
            }
        } else {
            try {
                String[] splitSplitCommand = splitCommand[1].split("/.. ",2);
                if (splitSplitCommand.length < 2) {
                    throw new InvalidDataException("please add a valid time/ description");
                }
                description = splitSplitCommand[0];
                String time = splitSplitCommand[1];
                taskDetails = new String[]{taskType, description, time};
            } catch (Exception e) {
                throw new InvalidDataException("invalid description or time input.");
            }
        }
        return taskDetails;
    }

    static String[] getTaskDetailsFromSave(String TaskString) {
        return TaskString.split("\\|");
    }
}
