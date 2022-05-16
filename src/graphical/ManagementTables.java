package graphical;

import XML.*;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import restaurant.Manager;

public class ManagementTables {
    Scene scene;
    Stage stage;
    ManagerScreen managerScreen;
    Manager manager = new Manager();
    private Restaurant restaurant;
    ObservableList<User> users = FXCollections.observableList(manager.viewUsers());

    public void representation() {
        Label titleLabel = new Label("Users");
        titleLabel.setFont(Font.font("Wingdings", 30));
        Button back = new Button("Back");

        BorderPane borderPane = new BorderPane();
        StackPane stackPane = new StackPane();
        StackPane title = new StackPane();
        AnchorPane anchorPane = new AnchorPane();

        TableView<User> tableView;

        TableColumn<User, String> nameCoulomn = new TableColumn<>("Name");
        nameCoulomn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCoulomn.setMaxWidth(200);

        TableColumn<User, String> roleColomn = new TableColumn<>("Role");
        roleColomn.setCellValueFactory(new PropertyValueFactory<>("role"));
        roleColomn.setMaxWidth(100);

        tableView = new TableView<>();
        tableView.setItems(users);
        tableView.getColumns().addAll(nameCoulomn, roleColomn);
        tableView.setMaxWidth(275);

        title.getChildren().addAll(titleLabel);
        stackPane.getChildren().addAll(tableView);
        anchorPane.getChildren().addAll(back);

        title.setMinHeight(100);
        anchorPane.setRightAnchor(back, 10.0);
        anchorPane.setMinHeight(65);
        stackPane.setMaxHeight(175);

        borderPane.setTop(title);
        borderPane.setCenter(tableView);
        borderPane.setBottom(anchorPane);

        scene = new Scene(borderPane, 600, 400);

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(managerScreen.getScene());
            }
        });
    }

    public ManagementTables(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setManagerScreen(ManagerScreen managerScreen) {
        this.managerScreen = managerScreen;
    }
}
