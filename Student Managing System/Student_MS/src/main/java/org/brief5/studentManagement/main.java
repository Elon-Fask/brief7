package org.brief5.studentManagement;

import java.sql.*;

import org.brief5.dao.srcDAO;
import org.brief5.impl.dao.Impl_dao;

import javafx.application.Application;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class main extends Application {
    // List of contact table properties
   private String[] propertyName = {"idStudent", "First name", "Last Name", "Email", "Adresse", "Contact"};
   private String[] propertyLabel = {"idStudent","First name", "Last Name", "Email", "Adresse", "Contact"};
   private Impl_dao contact = new Impl_dao();
   private final GridPane gridPane = new GridPane();
   private final Label lblName = new Label("Search by Name");
   private final TextField searchField = new TextField();
   private ObservableList<student> observableNames;
   private FilteredList<student> filteredData;
   private SortedList<student> sortedData;
   private ListView<student> listView;
   TableView<student> contactTableView =
      new TableView<>();
   public void Maincode2() {
      lblName.setTextFill(Color.web("#0076a3"));
      observableNames = FXCollections.observableArrayList
         (contact.getAllInfo());
      filteredData = new FilteredList<>
         (observableNames, p -> true);
      sortedData = new SortedList<>(filteredData);
      listView = new ListView<>(sortedData);
   }
   @Override
   public void start(Stage primaryStage) {
      primaryStage.setTitle("Address Book");
      primaryStage.setMaximized(true);
      BorderPane borderPane = new BorderPane();
      Scene scene = new Scene(borderPane,650,400,true);
      gridPane.setPadding(new Insets(10));
      gridPane.setHgap(5);
      gridPane.setVgap(5);
      gridPane.add(lblName, 0, 0);
      gridPane.add(searchField, 0, 1);
      // Search TextField event handling
      searchField.textProperty()
         .addListener((observable, oldValue, newValue) ->
            filteredData.setPredicate(str -> {
               if (newValue == null || newValue.isEmpty())
                  return true;
               if (str.getFName().toLowerCase().contains
                     (newValue.toLowerCase()))
                  return true;
               return false;
      }));   
   
      
      listView.getSelectionModel().setSelectionMode
      (SelectionMode.SINGLE);
   listView.setPrefHeight(Integer.MAX_VALUE);
   // Sets a new cell factory to use in the ListView.
   // This throws away all old list cells and new ListCells
   // created with the new cell factory.
   listView.setCellFactory(listView-> {
      Tooltip tooltip = new Tooltip();
      ListCell<student> cell = new
            ListCell<student>() {
         public void updateItem(student student,Boolean empty) {
            super.updateItem(student, empty);
            if (student != null) {
               setText(student.getFName());
               tooltip.setText(student.getLName());
               setTooltip(tooltip);
            } else
               setText( null);
         }
      };
      return cell;
   });
   gridPane.add(listView, 0, 2);
   // Create and initializing TableView
   ObservableList<student> contactPeopleList
      = FXCollections.observableArrayList();
   contactTableView.setItems(contactPeopleList);
   contactTableView.setColumnResizePolicy(
      TableView.CONSTRAINED_RESIZE_POLICY);
   for (int i = 0; i <
         propertyLabel.length; i++) {
      TableColumn<student, Object> col
         = new TableColumn<>(propertyLabel[i]);
      col.setCellValueFactory(new
         PropertyValueFactory<>(propertyName[i]));
      contactTableView.getColumns().add(col);
   }
   borderPane.setCenter(contactTableView);
   borderPane.setLeft(gridPane);
   // TableView will populate from the contactPeopleList
   // contactPeopleList will have value according to the
   // item selected in the ListView
   listView.getSelectionModel()
      .selectedItemProperty()
      .addListener(new ChangeListener<student>() {
         @Override
         public void changed(
            ObservableValue<? extends
               student> observable,
            student oldValue, student newValue) {
            if (observable != null &&
                  observable.getValue() != null) {
               contactPeopleList.clear();
               contactPeopleList.addAll(
                  contact.getStudentById
                     (newValue.getIdStudent()));
               }
            }
         });
   primaryStage.setScene(scene);
   primaryStage.show();
}

   
   public static void Maincode(String[] args) {
   launch (args);
}

      
   
   
}   
   
   
   
   
   
   