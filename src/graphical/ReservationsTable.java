package graphical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import reservedRestaurant.ReservedTable;
import restaurant.Manager;
import restaurant.Waiter;

public class ReservationsTable {
    Scene scene;
    Stage stage;
    ManagerScreen managerScreen;
    WaiterScreen waiterScreen;
    ObservableList<ReservedTable> reservedTables;

    public void representation() {
        if (LoginScreen.validUser.getRole().equals("Manager")) {
            Manager manager = new Manager();
            reservedTables = FXCollections.observableList(manager.viewReservations());
        } else {
            Waiter waiter = new Waiter();
            reservedTables = FXCollections.observableList(waiter.viewReservations());
        }

        Label title = new Label("Today's reservations");
        title.setFont(Font.font("Wingdings", 30));
        Button back = new Button("Back");

        BorderPane borderPane = new BorderPane();
        StackPane stackPane = new StackPane();
        AnchorPane anchorPane = new AnchorPane();

        anchorPane.setRightAnchor(back, 10.0);

        TableView<ReservedTable> tableView = new TableView<>();

        TableColumn<ReservedTable, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setMaxWidth(100);

        TableColumn<ReservedTable, String> numberColumn = new TableColumn<>("Number");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        numberColumn.setMaxWidth(100);

        TableColumn<ReservedTable, String> priceColumn = new TableColumn<>("Check");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceColumn.setMaxWidth(100);

        tableView = new TableView<>();
        tableView.setItems(reservedTables);
        tableView.getColumns().addAll(nameColumn, numberColumn, priceColumn);

        stackPane.getChildren().addAll(tableView);
        anchorPane.getChildren().addAll(back);
        anchorPane.setRightAnchor(back, 10.0);

        borderPane.setTop(title);
        borderPane.setCenter(tableView);
        borderPane.setBottom(anchorPane);

        scene = new Scene(borderPane, 600, 400);

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (LoginScreen.validUser.getRole().equals("Manager"))
                    stage.setScene(managerScreen.getScene());
                else
                    stage.setScene(waiterScreen.getScene());
            }
        });

    }

    public ReservationsTable(Stage stage) {
        this.stage = stage;
    }

    public void setManagerScreen(ManagerScreen managerScreen) {
        this.managerScreen = managerScreen;
    }

    public void setWaiterScreen(WaiterScreen waiterScreen) {
        this.waiterScreen = waiterScreen;
    }

    public Scene getScene() {
        return scene;
    }
}
