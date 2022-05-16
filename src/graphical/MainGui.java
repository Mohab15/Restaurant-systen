package graphical;

import javafx.application.Application;
import javafx.stage.Stage;
import XML.*;
import reservedRestaurant.ReservedRestaurant;
import reservedRestaurant.ReservedTable;
import reservedRestaurant.ReservedTables;
import reservedRestaurant.savedXMLLoader;
import restaurant.ValidUser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MainGui extends Application {
    public static ValidUser validUser;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Restaurant");

        LoginScreen loginScreen = new LoginScreen(primaryStage);
        ManagerScreen managerScreen = new ManagerScreen(primaryStage);
        CookerScreen cookerScreen = new CookerScreen(primaryStage);
        WaiterScreen waiterScreen = new WaiterScreen(primaryStage);
        ClientScreen clientScreen = new ClientScreen(primaryStage);
        ManagementTables managementTables = new ManagementTables(primaryStage);
        ReservationsTable reservationsTable = new ReservationsTable(primaryStage);
        ReservationScreen reservationScreen = new ReservationScreen(primaryStage);
        DishesTable dishesTable = new DishesTable(primaryStage);

        loginScreen.setManagerScreen(managerScreen);
        loginScreen.setCookerScreen(cookerScreen);
        loginScreen.setWaiterScreen(waiterScreen);
        loginScreen.setClientScreen(clientScreen);
        managerScreen.setLoginScreen(loginScreen);
        managerScreen.setDishesTable(dishesTable);
        managerScreen.setManagementTables(managementTables);
        managerScreen.setReservationsTable(reservationsTable);
        managementTables.setManagerScreen(managerScreen);
        cookerScreen.setLoginScreen(loginScreen);
        cookerScreen.setDishesTable(dishesTable);
        cookerScreen.setReservationsTable(reservationsTable);
        waiterScreen.setLoginScreen(loginScreen);
        waiterScreen.setReservationsTable(reservationsTable);
        clientScreen.setLoginScreen(loginScreen);
        clientScreen.setDishesTable(dishesTable);
        clientScreen.setReservationScreen(reservationScreen);
        dishesTable.setManagerScreen(managerScreen);
        dishesTable.setClientScreen(clientScreen);
        dishesTable.setCookerScreen(cookerScreen);
        reservationScreen.setClientScreen(clientScreen);
        reservationsTable.setManagerScreen(managerScreen);
        reservationsTable.setWaiterScreen(waiterScreen);

        loginScreen.representation();

        primaryStage.setScene(loginScreen.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        new XML.XMLReader();
        new reservedRestaurant.savedXMLLoader();
        launch(args);
    }
}
