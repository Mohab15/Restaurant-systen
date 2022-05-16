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

public class WaiterScreen {
    Scene scene;
    Stage stage;
    LoginScreen loginScreen;
    ReservationsTable reservationsTable;

    public void representation() {
        ImageView image1 = new ImageView("https://cdn2.vectorstock.com/i/1000x1000/43/21/waiter-vector-7134321.jpg");
        image1.setFitHeight(150);
        image1.setFitWidth(150);
        ImageView image2 = new ImageView("https://cdn3.vectorstock.com/i/1000x1000/78/67/waiter-and-waitress-holding-a-serving-tray-vector-13607867.jpg");
        image2.setFitHeight(150);
        image2.setFitWidth(150);
        Label waiter = new Label("Waiter");
        waiter.setFont(Font.font("Wingdings", 30));
        Label identity = new Label("Hello Mr. " + LoginScreen.validUser.getName());
        Button viewReservations = new Button("View reservations");
        Button logout = new Button("Logout");

        BorderPane borderPane = new BorderPane();
        StackPane title = new StackPane();
        StackPane image = new StackPane();
        VBox left = new VBox(image1, identity, viewReservations, logout);

        image.getChildren().addAll(image2);
        title.getChildren().addAll(waiter);
        title.setStyle("-fx-background-color: #A9A9A9;");
        title.setMinHeight(100);
        image.setMaxHeight(100);
        left.setSpacing(10);
        left.setPrefWidth(100);

        borderPane.setTop(title);
        borderPane.setLeft(left);
        borderPane.setRight(image);

        scene = new Scene(borderPane, 600, 400);

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginScreen.getScene());
            }
        });
        viewReservations.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                reservationsTable.representation();
                stage.setScene(reservationsTable.getScene());

            }
        });
    }

    public WaiterScreen(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginScreen(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public void setReservationsTable(ReservationsTable reservationsTable) {
        this.reservationsTable = reservationsTable;
    }
}
