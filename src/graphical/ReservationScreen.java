package graphical;

import XML.Dish;
import XML.Table;
import XML.XMLReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import reservedRestaurant.ReservedTable;
import reservedRestaurant.XMLSaver;
import reservedRestaurant.savedXMLLoader;
import restaurant.*;

import javax.xml.bind.JAXBException;
import java.util.List;

public class ReservationScreen {
    Stage stage;
    Scene scene;
    ClientScreen clientScreen;
    Client client = new Client();
    Meal meal = new Meal();
    Order plates = new Order();
    Dish[] myDishes = new Dish[30];
    int count = 0;
    double check = 0;
    private List<Dish> dishes_list = client.viewDishes();
    private List<Table> tables_list = client.viewTables();
    private List<ReservedTable> reservedTableList = client.viewReserved();
    ObservableList<Table> tables = FXCollections.observableList(tables_list);
    XMLSaver xmlSaver = new XMLSaver();


    public void representation() {
        Label reservationScreen = new Label("Reservation");
        reservationScreen.setFont(Font.font("Wingdings", 30));
        Label ordering = new Label("Please place your order");
        Label choosingTable = new Label("Please choose your table\nfrom the available ones");
        Label price = new Label();
        Label error = new Label();
        Button record = new Button("Record");
        Button calculate = new Button("Calculate");
        Button save = new Button("Save");
        Button cancel = new Button("Cancel");

        ChoiceBox<String> appetizers = new ChoiceBox<>();
        ChoiceBox<String> mainCourse = new ChoiceBox<>();
        ChoiceBox<String> dessert = new ChoiceBox<>();
        ChoiceBox<String> tableChoice = new ChoiceBox<>();

        for (int i = 0; i < dishes_list.size(); i++) {
            if (dishes_list.get(i).getType().equals("appetizer"))
                appetizers.getItems().add(dishes_list.get(i).getName());
            else if (dishes_list.get(i).getType().equals("main_course"))
                mainCourse.getItems().add(dishes_list.get(i).getName());
            else if (dishes_list.get(i).getType().equals("desert"))
                dessert.getItems().add(dishes_list.get(i).getName());
        }

        for (int i = 0; i < tables_list.size(); i++) {
            int flag = 0;
            for (int j = 0; j < reservedTableList.size(); j++) {
                if (tables_list.get(i).getNumber() == reservedTableList.get(j).getNumber())
                    flag++;
            }
            if (flag == 0)
                tableChoice.getItems().add(Integer.toString(tables_list.get(i).getNumber()));

        }

        TableView<Table> tableView;
        TableColumn<Table, String> numberColumn = new TableColumn<>("Number");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        numberColumn.setMaxWidth(80);

        TableColumn<Table, String> seatsColumn = new TableColumn<>("Seats");
        seatsColumn.setCellValueFactory(new PropertyValueFactory<>("number_of_seats"));
        seatsColumn.setMaxWidth(80);

        TableColumn<Table, String> smokingColumn = new TableColumn<>("Smoking");
        smokingColumn.setCellValueFactory(new PropertyValueFactory<>("smoking"));
        smokingColumn.setMaxWidth(100);


        tableView = new TableView<>();
        tableView.setItems(tables);
        tableView.getColumns().addAll(numberColumn, seatsColumn, smokingColumn);

        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new AnchorPane();
        StackPane title = new StackPane();
        HBox choices = new HBox(appetizers, mainCourse, dessert);
        HBox cash = new HBox(calculate, price);
        VBox order = new VBox(ordering, choices, record);
        VBox tabel = new VBox(choosingTable, tableChoice);
        HBox hBox = new HBox(tabel, tableView);
        HBox last = new HBox(save, cancel);
        VBox totalScreen = new VBox(order, hBox, error, cash);

        title.getChildren().addAll(reservationScreen);
        anchorPane.getChildren().addAll(last);

        anchorPane.setRightAnchor(last, 10.0);
        cash.setSpacing(10);
        choices.setSpacing(10);
        order.setSpacing(10);
        tabel.setSpacing(10);
        hBox.setSpacing(20);
        last.setSpacing(10);
        totalScreen.setSpacing(18);

        borderPane.setTop(title);
        borderPane.setCenter(totalScreen);
        borderPane.setBottom(anchorPane);

        scene = new Scene(borderPane, 600, 400);

        record.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String appetizer = appetizers.getValue();
                String mainDish = mainCourse.getValue();
                String desert = dessert.getValue();

                if (appetizer != null) {
                    Dish dish = meal.getMeal(appetizer);
                    myDishes[count] = new Dish();
                    myDishes[count] = dish;
                    count++;
                }
                if (mainDish != null) {
                    Dish dish = meal.getMeal(mainDish);
                    myDishes[count] = new Dish();
                    myDishes[count] = dish;
                    count++;
                }
                if (desert != null) {
                    Dish dish = meal.getMeal(desert);
                    myDishes[count] = new Dish();
                    myDishes[count] = dish;
                    count++;
                }
                appetizers.getSelectionModel().clearSelection();
                mainCourse.getSelectionModel().clearSelection();
                dessert.getSelectionModel().clearSelection();
            }
        });
        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                check = client.getCheck(myDishes, count);
                price.setText(" " + check + "$");
                price.setTextFill(Color.GREEN);
                price.setFont(Font.font(20));
            }
        });

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                count = 0;
                stage.setScene(clientScreen.getScene());
            }
        });
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String tableChoiceValue = tableChoice.getValue();
                int tableNumber;
                if (tableChoiceValue != null) {
                    tableNumber = Integer.parseInt(tableChoiceValue);
                    plates.setName(LoginScreen.validUser.getName());
                    plates.setPrice(check);
                    plates.setTableNumber(tableNumber);
                    String[] makeOrder = new String[count];
                    for (int i = 0; i < count; i++) {
                        makeOrder[i] = new String();
                        makeOrder[i] = myDishes[i].getName();
                    }
                    plates.setOrder(makeOrder);

                    try {
                        xmlSaver.save(plates);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    stage.setScene(clientScreen.getScene());
                } else {
                    error.setText("Choose a table");
                    error.setTextFill(Color.RED);
                    error.setFont(Font.font(20));
                }
            }
        });
    }

    public ReservationScreen(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setClientScreen(ClientScreen clientScreen) {
        this.clientScreen = clientScreen;
    }
}
