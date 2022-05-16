package graphical;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import XML.User;
import XML.Restaurant;
import restaurant.ValidUser;

public class LoginScreen {
    Scene scene;
    Stage stage;
    ManagerScreen managerScreen;
    CookerScreen cookerScreen;
    WaiterScreen waiterScreen;
    ClientScreen clientScreen;
    LoginScreen loginScreen;

    public static ValidUser validUser = new ValidUser();

    public void representation() {
        Label username = new Label("Username:");
        Label password = new Label("Password:");
        username.setTextFill(Color.WHITE);
        password.setTextFill(Color.WHITE);

        Label result = new Label();
        TextField usernameTextField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button login = new Button("Login");
        ImageView image = new ImageView("https://assets.cairo360.com/app/uploads/2019/03/Saigon-Restaurant-Copy.jpg?fbclid=IwAR2Z0Rc33fGWXnaOzEpZAQ0W1Y9MzTzSenc03yrd6QTKqVZfJIJANqFLWFU");
        StackPane screen = new StackPane();

        GridPane grid = new GridPane();
        grid.add(username, 0, 1);
        grid.add(password, 0, 2);
        grid.add(usernameTextField, 1, 1);
        grid.add(passwordField, 1, 2);
        grid.add(login, 1, 3);
        grid.add(result, 2, 2);
        screen.getChildren().addAll(image, grid);


        scene = new Scene(screen, 400, 200);

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event1) {
                result.setText("");
                String username = usernameTextField.getText();
                String password = passwordField.getText();
                LoginValidation validation = new LoginValidation();
                User valid = validation.validation(username, password);
                if (valid != null) {
                    validUser.setName(valid.getName());
                    validUser.setRole(valid.getRole());
                    validUser.setUsername(valid.getUsername());
                    validUser.setPassword(valid.getPassword());
                    if (valid.getRole().equals("Manager")) {
                        managerScreen.representation();
                        stage.setScene(managerScreen.getScene());
                    } else if (valid.getRole().equals("Cooker")) {
                        cookerScreen.representation();
                        stage.setScene(cookerScreen.getScene());
                    } else if (valid.getRole().equals("Waiter")) {
                        waiterScreen.representation();
                        stage.setScene(waiterScreen.getScene());
                    } else if (valid.getRole().equals("Client")) {
                        clientScreen.representation();
                        stage.setScene(clientScreen.getScene());
                    } else
                        result.setText("Invalid Role");
                } else {
                    result.setText("Wrong username or password");
                    result.setFont(Font.font("Verdanna", FontWeight.BOLD, 13));
                    result.setTextFill(Color.RED);

                }
                usernameTextField.setText("");
                passwordField.setText("");
            }

        });
    }

    public LoginScreen(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setManagerScreen(ManagerScreen managerScreen) {
        this.managerScreen = managerScreen;
    }

    public void setCookerScreen(CookerScreen cookerScreen) {
        this.cookerScreen = cookerScreen;
    }

    public void setWaiterScreen(WaiterScreen waiterScreen) {
        this.waiterScreen = waiterScreen;
    }

    public void setClientScreen(ClientScreen clientScreen) {
        this.clientScreen = clientScreen;
    }
}
