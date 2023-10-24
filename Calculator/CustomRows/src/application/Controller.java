package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {

	@FXML
    private TableView<Information> table;

    @FXML
    private TableColumn<Information, String> name;

    @FXML
    private TableColumn<Information, ListView> data;

    ListView<String> listView = new ListView<String>();

    ObservableList<Information> info = FXCollections.observableArrayList(
            new Information("test", listView),
            new Information("test1", null)
        );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<Information, String>("name"));
        data.setCellValueFactory(new PropertyValueFactory<Information, ListView>("data"));

        listView.getItems().addAll("test","test2","test3");
        listView.setPrefHeight(80);

        table.setItems(info);
    }
}











