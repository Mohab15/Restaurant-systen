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

public class CookerScreen {
    Scene scene;
    Stage stage;
    LoginScreen loginScreen;
    DishesTable dishesTable;
    ReservationsTable reservationsTable;

    public void representation() {
        ImageView image1 = new ImageView("https://image.freepik.com/free-vector/chef-logo-vector_20448-270.jpg");
        image1.setFitHeight(150);
        image1.setFitWidth(150);
        ImageView image2 = new ImageView("https://previews.123rf.com/images/vectortwins/vectortwins1510/vectortwins151000003/46665505-love-cooking-logo-chef-logo.jpg");
        image2.setFitHeight(150);
        image2.setFitWidth(150);
        Label chef = new Label("Chef");
        chef.setFont(Font.font("Wingdings", 30));
        Label identity = new Label("Hello Mr. " + LoginScreen.validUser.getName());
        Button viewDishes = new Button("View dishes");
        Button logout = new Button("Logout");

        BorderPane borderPane = new BorderPane();
        StackPane title = new StackPane();
        StackPane image = new StackPane();
        VBox left = new VBox(image1, identity, viewDishes, logout);

        image.getChildren().addAll(image2);
        title.getChildren().addAll(chef);
        title.setStyle("-fx-background-color: #A9A9A9;");
        title.setMinHeight(100);
        image.setMaxHeight(100);
        left.setSpacing(10);
        left.setPrefWidth(100);

        borderPane.setTop(title);
        borderPane.setLeft(left);
        borderPane.setRight(image);

        scene = new Scene(borderPane, 600, 400);

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
    }

    public CookerScreen(Stage stage) {
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

    public void setDishesTable(DishesTable dishesTable) {
        this.dishesTable = dishesTable;
    }
}
