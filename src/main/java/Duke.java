import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Scanner;

public class Duke extends Application {

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));
    /**
     * this is the main function for duke.
     * */

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greeting("hi");
        // create scanner object
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            String userInput = inputScanner.nextLine();
            handle_input(userInput);
        }
    }

    /**
     * Method to greet user. Called at startup/ exit.
     */

    static void greeting(String greetingType) {
        String hiGreeting = "Hello! I'm Duke\nWhat can I do for you?";
        String byeGreeting = "Bye. Hope to see you again soon!";
        String greeting = null;
        switch (greetingType) {
        case "hi" :
            greeting = hiGreeting;
            break;
        case "bye" :
            greeting = byeGreeting;
            System.out.println(addBorder());
            System.out.println(greeting);
            System.out.println(addBorder());
            System.exit(0);
            break;
        case "list":
            System.out.println(addBorder());
            taskMaster.listTasks();
            System.out.println(addBorder());
            break;
        default :
            greeting = greetingType;
            taskMaster.addTask(greeting);
            break;
        }
        if (greeting != null) {
            System.out.println(addBorder());
            System.out.println("added: " + greeting);
            System.out.println(addBorder());
        }
        return;
    }

    /**
     * Method to add horizontal lines above and below Duke output.
     * */
    static String addBorder() {
        String border = "____________________________________________________________";
        return border;
    }

    /**
     * Handles user input.
     * */

    static void handle_input(String userInput) {
        greeting(userInput);
        return;
    }







    @Override
    /**
     * Creating the GUI with JavaFX - Excercise 2.
     * */

    public void start(Stage stage) throws Exception {
        // Step 1. Setting up required components.

        // The container for the content of the chat to scroll.
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.show();

        // Step 2. Formatting the window to look as expected.
        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane,1.0);

        AnchorPane.setBottomAnchor(sendButton,1.0);
        AnchorPane.setRightAnchor(sendButton,1.0);

        AnchorPane.setLeftAnchor(userInput,1.0);
        AnchorPane.setBottomAnchor(userInput,1.0);

        // Step 3. Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            userInput.clear();
        });

        userInput.setOnAction((event) -> {
            dialogContainer.getChildren().add(getDialogLabel(userInput.getText()));
            userInput.clear();
        });

        // Scroll down to the end every time the dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        // Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });

        userInput.setOnAction((event) -> {
            handleUserInput();
        });
    }
    /**
     * Iteration 1:
     * Creates a label with the specified text and adds it to the dialog container.
     * @param text String containing text to add.
     * @return a label with the specified text that has the word wrap enabled.
     */

    private Label getDialogLabel(String text) {
        Label textToAdd = new Label(text);
        textToAdd.setWrapText(true);

        return textToAdd;
    }

    /** Iteration 2:
     * Creates 2 dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */

    private void handleUserInput() {
        Label userText = new Label(userInput.getText());
        Label dukeText = new Label(getResponse(userInput.getText()));
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(user)),
                DialogBox.getDukeDialog(dukeText, new ImageView(duke))
        );
        userInput.clear();
    }

    /**
     * Duke response to user input.
     * */

    private String getResponse(String input) {
        return "Duke heard: " + input;
    }

}


