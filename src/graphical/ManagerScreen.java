package graphical;

import XML.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import reservedRestaurant.ReservedTable;
import restaurant.Manager;

import javax.xml.bind.JAXBException;
import java.util.List;

public class ManagerScreen {
    Scene scene;
    Stage stage;
    LoginScreen loginScreen;
    ManagementTables managementTables;
    DishesTable dishesTable;
    ReservationsTable reservationsTable;
    Manager manager = new Manager();
    private Restaurant restaurant;

    public void representation() {

        ImageView image = new ImageView("https://media-cdn.tripadvisor.com/media/photo-s/1a/f3/03/20/our-restaurant.jpg");
        image.setFitHeight(150);
        image.setFitWidth(150);
        Label management = new Label("Manager");
        management.setFont(Font.font("Wingdings", 50));
        Label identity = new Label("Welcome Mr. " + LoginScreen.validUser.getName());
        Label earns = new Label("Total Earns Today is :");
        Label price = new Label();
        Button viewUsers = new Button("View users");
        Button viewDishes = new Button("View dishes");
        Button viewReservations = new Button("View reservations");
        Button logout = new Button("Logout");
        Button calculate = new Button("Calculate today's earnings");

        BorderPane borderPane = new BorderPane();
        StackPane title = new StackPane();
        StackPane imageDisplay = new StackPane();
        VBox buttonsList = new VBox();
        HBox calcuation = new HBox();

        imageDisplay.getChildren().addAll(image);
        title.getChildren().addAll(management);
        buttonsList.getChildren().addAll(identity, viewUsers, viewDishes, viewReservations, calculate, logout);
        calcuation.getChildren().addAll(earns, price);

        title.setStyle("-fx-background-color: #A9A9A9;");
        buttonsList.setSpacing(10);
        calcuation.setSpacing(10);
        title.setMinHeight(100);
        calcuation.setMinHeight(100);

        borderPane.setTop(title);
        borderPane.setBottom(calcuation);
        borderPane.setLeft(buttonsList);
        borderPane.setRight(imageDisplay);

        scene = new Scene(borderPane, 600, 400);

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginScreen.getScene());
            }
        });
        viewUsers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                managementTables.representation();
                stage.setScene(managementTables.getScene());
            }
        });
        viewDishes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dishesTable.representation();
                stage.setScene(dishesTable.getScene());
            }
        });
        viewReservations.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                reservationsTable.representation();
                stage.setScene(reservationsTable.getScene());
            }
        });
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double total = manager.getTotalEarnings();
                price.setText(" " + total + "$");
                price.setTextFill(Color.GREEN);
                price.setFont(Font.font(20));
            }
        });
    }

    public ManagerScreen(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ManagerScreen(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginScreen(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public void setManagementTables(ManagementTables managementTables) {
        this.managementTables = managementTables;
    }

    public void setReservationsTable(ReservationsTable reservationsTable) {
        this.reservationsTable = reservationsTable;
    }

    public void setDishesTable(DishesTable dishesTable) {
        this.dishesTable = dishesTable;
    }
}
