package graphical;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClientScreen {
    Scene scene;
    Stage stage;
    LoginScreen loginScreen;
    DishesTable dishesTable;
    ReservationScreen reservationScreen;

    public void representation() {
        ImageView image1 = new ImageView("https://images.template.net/wp-content/uploads/2016/04/22123121/Cool-Restaurant-Logo-Download.jpg");
        image1.setFitHeight(150);
        image1.setFitWidth(150);
        Label client = new Label("Welcome ");
        client.setFont(Font.font("Wingdings", 30));
        Label identity = new Label("Hello Mr. " + LoginScreen.validUser.getName());
        Button reserve = new Button("Make a reservation");
        Button viewDishes = new Button("View dishes");
        Button logout = new Button("Logout");

        BorderPane borderPane = new BorderPane();
        StackPane title = new StackPane();
        StackPane image = new StackPane();
        VBox left = new VBox(identity, reserve, viewDishes, logout);

        image.getChildren().addAll(image1);
        title.getChildren().addAll(client);
        title.setStyle("-fx-background-color: #A9A9A9;");
        title.setMinHeight(100);
        image.setMaxHeight(100);
        left.setSpacing(10);

        borderPane.setTop(title);
        borderPane.setRight(image);
        borderPane.setLeft(left);

        scene = new Scene(borderPane, 600, 400);

        reserve.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(reservationScreen.getScene());
            }
        });

        viewDishes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dishesTable.representation();
                stage.setScene(dishesTable.getScene());
            }
        });

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginScreen.getScene());
            }
        });

        reserve.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                reservationScreen.representation();
                stage.setScene(reservationScreen.getScene());
            }
        });

    }

    public ClientScreen(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginScreen(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public void setDishesTable(DishesTable dishesTable) {
        this.dishesTable = dishesTable;
    }

    public void setReservationScreen(ReservationScreen reservationScreen) {
        this.reservationScreen = reservationScreen;
    }
}
