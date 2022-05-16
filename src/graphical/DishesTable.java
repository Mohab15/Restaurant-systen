package graphical;

import XML.Dish;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import restaurant.Client;
import restaurant.Cooker;
import restaurant.Manager;

public class DishesTable {
    Scene scene;
    Stage stage;
    ManagerScreen managerScreen;
    CookerScreen cookerScreen;
    ClientScreen clientScreen;
    ObservableList<Dish> dishes;

    public void representation() {
        if (LoginScreen.validUser.getRole().equals("Manager")) {
            Manager manager = new Manager();
            dishes = FXCollections.observableList(manager.viewDishes());
        } else if (LoginScreen.validUser.getRole().equals("Cooker")) {
            Cooker cooker = new Cooker();
            dishes = FXCollections.observableList(cooker.viewDishes());
        } else if (LoginScreen.validUser.getRole().equals("Client")) {
            Client client = new Client();
            dishes = FXCollections.observableList(client.viewDishes());
        }

        TableView<Dish> tableView;

        Label titleLabel = new Label("Available Dishes ");
        Button back = new Button("Back");
        Label taxes = new Label("Taxes");
        Label appetizers = new Label("Appetizers --> 10%");
        Label mainCourse = new Label("Main Courses --> 15%");
        Label desserts = new Label("Desserts --> 20%");

        BorderPane borderPane = new BorderPane();
        StackPane stackPane = new StackPane();
        StackPane title = new StackPane();
        AnchorPane anchorPane = new AnchorPane();
        VBox taxesPercentages = new VBox(taxes, appetizers, mainCourse, desserts);

        titleLabel.setFont(Font.font("Wingdings", 50));
        taxes.setFont(Font.font("Verdanna", FontWeight.BOLD, 20));
        taxes.setTextFill(Color.RED);


        TableColumn<Dish, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setMaxWidth(250);

        TableColumn<Dish, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeColumn.setMaxWidth(200);

        TableColumn<Dish, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceColumn.setMaxWidth(100);

        tableView = new TableView<>();
        tableView.setItems(dishes);
        tableView.getColumns().addAll(nameColumn, typeColumn, priceColumn);
        tableView.setMaxWidth(285);

        title.getChildren().addAll(titleLabel);
        stackPane.getChildren().addAll(tableView);
        anchorPane.getChildren().addAll(back);

        title.setMinHeight(100);
        anchorPane.setRightAnchor(back, 10.0);
        anchorPane.setMinHeight(65);
        stackPane.setMaxHeight(175);
        taxesPercentages.setMaxWidth(150);

        borderPane.setTop(title);
        borderPane.setRight(taxesPercentages);
        borderPane.setCenter(tableView);
        borderPane.setBottom(anchorPane);

        scene = new Scene(borderPane, 600, 400);

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (LoginScreen.validUser.getRole().equals("Manager"))
                    stage.setScene(managerScreen.getScene());
                else if (LoginScreen.validUser.getRole().equals("Cooker"))
                    stage.setScene(cookerScreen.getScene());
                else if (LoginScreen.validUser.getRole().equals("Client"))
                    stage.setScene(clientScreen.getScene());
            }
        });
    }

    public DishesTable(Stage stage) {
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

    public void setClientScreen(ClientScreen clientScreen) {
        this.clientScreen = clientScreen;
    }
}

