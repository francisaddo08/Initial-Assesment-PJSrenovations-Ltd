/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pjsrenovation;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class PJSrenovation extends Application {
// charts

    ObservableList<PieChart.Data> workChartObservableList;
    //general text
    static String promtString = "category";

    //Reports field
    House newHouse = new House();
    Owner newOwner = new Owner();
    ArrayList<String> workCatArrayList = new ArrayList<>(1); // work level array list
    int totalWorkLevelScore = 0;
    String oneCoaString = "one coats";
    String twocoatString = "two coats";
    String newWallString = "new wall";
    String prepLevelString = "prep level";
    Iterator<String> workCatIterator = workCatArrayList.iterator();

    int oneCoat = 0;
    int oneCoatPercentage = 0;
    int twoCoat = 0;
    double twoCoatPercentage = 0;
    int newWall = 0;
    double newWallPercentage = 0;
    int prepLevel = 0;
    double prepLevelPercentage = 0;
    int houseSize = 0;
    int totalRoomsArea = 0;
    int totalLivingRoomArea = 0;
    int totalKitchenArea = 0;
    int totalToiletArea = 0;

    // charts
    Text workLevelHeading;
    Text nameText;
    // report gridpane
    static GridPane reportGridPane;
    static GridPane formsgGridPane;
    static Button reportButton;
    static Button resertButton;
    static HBox addressHBox;
    // report data

    //rooms fields and combobox
    static TextField kingsizeTextField = new NumberTextField(0);
    static TextField doubleroomTextField = new NumberTextField(0);
    static TextField singleroomtTextField = new NumberTextField(0);
    static ComboBox kingsizeComboBox;
    static ComboBox doubleComboBox;
    static ComboBox singlecComboBox;

    // living rooms
    static TextField largelivingTextField = new NumberTextField(0);
    static TextField normallivingTextField = new NumberTextField(0);
    static TextField smalllivingTextField = new NumberTextField(0);
    static ComboBox largeComboBox;
    static ComboBox normmalComboBox;
    static ComboBox smallComboBox;

    //kitchen
    static TextField largeKitchen;
    static TextField normalkitchen;
    static TextField smallkitchen;
    static ComboBox largeKitchenComboBox;
    static ComboBox normmaKitchenlComboBox;
    static ComboBox smalKitchenComboBox;

    //bathrooms toilets
    static TextField toiletbathShowerTextField;
    static TextField bathToiletField;
    static TextField toiletTextField;
    static ComboBox TBSComboBox;
    static ComboBox TBcombBox;
    static ComboBox toiletComboBox;
    //property details
    static TextField addressField;
    static TextField ownerName;
    static TextField postcodeField;
    static Text masterbedText;
    static Text doublebedText;
    static Text singlebedText;
    static Text largeLivingText;
    static Text normalLivingText;
    static Text smallLivingText;
    static Text largeKText;
    static Text normalKText;
    static Text smallKText;
    static Text tbsText;
    static Text tbText;
    static Text toiletText;

    //border panel
    static BorderPane root;

    //formating text firlds to accept only numbers
    @Override
    public void start(Stage primaryStage) {
        //top gride

        //root pane
        VBox topVBox = new VBox(10);
        topVBox.getChildren().addAll(addressBar(), formsgGridPane(), buttonsHBox(), hLine());
        root = new BorderPane();
        root.setTop(topVBox);
        root.setCenter(reportGridPane());

        //button action
        reportButton.setOnAction((event) -> {

            //report data
            //text fileds
            //rooms data
            //house data
            //reports lables
            Text title = new Text("Property Report");
            title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            Text clientNameLabel = new Text("Client Name");
            clientNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            Text clientText = new Text(ownerName.getText());
            Text addressLable = new Text("Address");
            addressLable.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            String fullAddress = addressField.getText() + "  " + postcodeField.getText();
            Text addrText = new Text(fullAddress);

            Text PiechartHeading = new Text("Labour");
            PiechartHeading.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 24));

            //rooms======================================================================
            Text rooms = new Text("Rooms");
            rooms.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 14));
            rooms.setFill(Color.BLUE);
            Text masterbedroom = new Text("Master Bedroom");
            masterbedroom.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            // MASTER BED 
            if (kingsizeTextField.getText().equals("0")) {
                masterbedText = new Text(kingsizeTextField.getText());
                masterbedText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                masterbedText.setFill(Color.DEEPPINK);
            } else {
                if (kingsizeComboBox.getValue() instanceof String) {
                    String kingSizeComboString = kingsizeComboBox.getValue().toString(); // work level
                    newHouse.numbKingSize = Integer.parseInt(kingsizeTextField.getText()); // number of king size rooms
                    masterbedText = new Text(kingsizeTextField.getText() + " " + " " + kingSizeComboString);
                    masterbedText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                    masterbedText.setFill(Color.DEEPPINK);
                    // WORK LEVELS
                    System.out.println("DEFAULT COMBO  " + kingsizeComboBox.getValue());

                    workCatArrayList.add(kingSizeComboString);
                    if (kingSizeComboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbKingSize;

                        System.out.println("room numbers kingsize +" + newHouse.numbKingSize + "  totalworkscore   " + totalWorkLevelScore + " one coat  " + oneCoat); // debuging
                    }
                    if (kingSizeComboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbKingSize;

                        System.out.println("room numbers kingsize +" + newHouse.numbKingSize + "  totalworkscore   " + totalWorkLevelScore + " two coat  " + twoCoat); // debuging
                    }
                    if (kingSizeComboString.equals(newWallString)) {
                        newWall += newHouse.numbKingSize;

                        System.out.println("room numbers kingsize +" + newHouse.numbKingSize + "  totalworkscore   " + totalWorkLevelScore + " new wall  " + newWall); // debuging
                    }
                    if (kingSizeComboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbKingSize;

                        System.out.println("room numbers kingsize +" + newHouse.numbKingSize + "  totalworkscore   " + totalWorkLevelScore + " prep " + prepLevel); // debuging
                    }

                }

            }
            // DOUBLE BED
            Text doubleroom = new Text("Double Bedroom");
            doubleroom.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            if (doubleroomTextField.getText().equals("0")) {

                doublebedText = new Text(doubleroomTextField.getText());
                doublebedText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                doublebedText.setFill(Color.DEEPPINK);

            } else {
                if (doubleComboBox.getValue() instanceof String) {

                    doublebedText = new Text(doubleroomTextField.getText() + " " + doubleComboBox.getValue());
                    doublebedText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                    doublebedText.setFill(Color.DEEPPINK);

                    workCatArrayList.add(doubleComboBox.getValue().toString());
                    String doubleRoomComboString = doubleComboBox.getValue().toString();
                    newHouse.numbDoubleRoom = Integer.parseInt(doubleroomTextField.getText());
                    System.out.println("double room" + newHouse.numbDoubleRoom); // debuging

                    if (doubleRoomComboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbDoubleRoom;

                        System.out.println(" double room percentage" + " totalwc" + totalWorkLevelScore + "onec " + oneCoat); //debuging
                    }
                    if (doubleRoomComboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbDoubleRoom;

                    }
                    if (doubleRoomComboString.equals(newWallString)) {
                        newWall += newHouse.numbDoubleRoom;

                    }
                    if (doubleRoomComboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbDoubleRoom;

                    }

                    System.out.println(" doublecombo  " + doubleComboBox.getValue()); //debuging
                    System.out.println(workCatArrayList); //debuging
                }

            }

            // SINGLE BED 
            Text singleroom = new Text("Single Bedroom");
            singleroom.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            if (singleroomtTextField.getText().equals("0")) {

                singlebedText = new Text(singleroomtTextField.getText());
                singlebedText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                singlebedText.setFill(Color.DEEPPINK);
            } else {

                if (singlecComboBox.getValue() instanceof String) {

                    singlebedText = new Text(singleroomtTextField.getText() + " " + singlecComboBox.getValue());
                    singlebedText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                    singlebedText.setFill(Color.DEEPPINK);
                    //work area
                    newHouse.numbSingleRoom = Integer.parseInt(singleroomtTextField.getText());
                    String singleroomComboString = singlecComboBox.getValue().toString();
                    workCatArrayList.add(singleroomComboString);
                    if (singleroomComboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbSingleRoom;

                        System.out.println(" double room percentage" + " totalwc" + totalWorkLevelScore + "onec " + oneCoat); //debuging
                    }
                    if (singleroomComboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbSingleRoom;

                    }
                    if (singleroomComboString.equals(newWallString)) {
                        newWall += newHouse.numbSingleRoom;

                    }
                    if (singleroomComboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbSingleRoom;

                    }

                }

            }

            //living ====================================================================
            Text livingroom = new Text("Living Room");
            livingroom.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            // large Living room
            Text LargelivingroomLabel = new Text("Large");
            LargelivingroomLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            LargelivingroomLabel.setFill(Color.STEELBLUE);

            if (largelivingTextField.getText().equals("0")) {
                largeLivingText = new Text(largelivingTextField.getText());
                largeLivingText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                largeLivingText.setFill(Color.NAVY);
            } else {
                if (largeComboBox.getValue() instanceof String) {
                    String largeLivingRoomComboString = largeComboBox.getValue().toString();
                    largeLivingText = new Text(largelivingTextField.getText() + " " + largeComboBox.getValue());
                    largeLivingText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                    largeLivingText.setFill(Color.NAVY);
                    workCatArrayList.add(largeComboBox.getValue().toString());

                    newHouse.numbLargeLivingRooms = Integer.parseInt(largelivingTextField.getText()); // numb of large living rooms
                    if (largeLivingRoomComboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbLargeLivingRooms;

                        System.out.println(" double room percentage" + " totalwc" + totalWorkLevelScore + "onec " + oneCoat); //debuging
                    }
                    if (largeLivingRoomComboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbLargeLivingRooms;

                    }
                    if (largeLivingRoomComboString.equals(newWallString)) {
                        newWall += newHouse.numbLargeLivingRooms;

                    }
                    if (largeLivingRoomComboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbLargeLivingRooms;

                    }

                }

            }

            //nomal
            Text normalLivingroomLabel = new Text("Normal");
            normalLivingroomLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            normalLivingroomLabel.setFill(Color.STEELBLUE);

            if (normallivingTextField.getText().equals("0")) {
                normalLivingText = new Text(normallivingTextField.getText());
                normalLivingText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                normalLivingText.setFill(Color.NAVY);
            } else {
                if (normmalComboBox.getValue() instanceof String) {
                    String normalLivingRoomComboString = normmalComboBox.getValue().toString();
                    normalLivingText = new Text(normallivingTextField.getText() + " " + normmalComboBox.getValue());
                    normalLivingText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                    normalLivingText.setFill(Color.NAVY);
                    // work
                    newHouse.numbNormalLivingRooms = Integer.parseInt(normallivingTextField.getText());
                    workCatArrayList.add(normmalComboBox.getValue().toString());
                    if (normalLivingRoomComboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbNormalLivingRooms;

                        System.out.println(" double room percentage" + " totalwc" + totalWorkLevelScore + "onec " + oneCoat); //debuging
                    }
                    if (normalLivingRoomComboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbNormalLivingRooms;

                    }
                    if (normalLivingRoomComboString.equals(newWallString)) {
                        newWall += newHouse.numbNormalLivingRooms;

                    }
                    if (normalLivingRoomComboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbNormalLivingRooms;

                    }

                }
            }

            //small
            Text smallLivingLabel = new Text("Small");
            smallLivingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            smallLivingLabel.setFill(Color.STEELBLUE);
            ;
            if (smalllivingTextField.getText().equals("0")) {
                smallLivingText = new Text(smalllivingTextField.getText());
                smallLivingText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                smallLivingText.setFill(Color.NAVY);

            } else {
                if (smallComboBox.getValue() instanceof String) {
                    String smalllivinComboString = smallComboBox.getValue().toString();
                    smallLivingText = new Text(smalllivingTextField.getText() + " " + smallComboBox.getValue());
                    smallLivingText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                    smallLivingText.setFill(Color.NAVY);
                    //work
                    workCatArrayList.add(smallComboBox.getValue().toString());
                    newHouse.numbSmallLivingRooms = Integer.parseInt(smalllivingTextField.getText());
                    if (smalllivinComboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbSmallLivingRooms;

                        System.out.println(" double room percentage" + " totalwc" + totalWorkLevelScore + "onec " + oneCoat); //debuging
                    }
                    if (smalllivinComboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbSmallLivingRooms;

                    }
                    if (smalllivinComboString.equals(newWallString)) {
                        newWall += newHouse.numbSmallLivingRooms;

                    }
                    if (smalllivinComboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbSmallLivingRooms;

                    }

                }

            }

            //KITCHES================================================
            //living 
            Text kitchen = new Text("KITCHEN");
            kitchen.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            Text largeKLabel = new Text("Large");
            largeKLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            largeKLabel.setFill(Color.STEELBLUE);
            //Large kitchens

            if (largeKitchen.getText().equals("0")) {
                largeKText = new Text(largeKitchen.getText());
                largeKText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                largeKText.setFill(Color.BLUEVIOLET);

            } else {
                if (largeKitchenComboBox.getValue() instanceof String) {
                    largeKText = new Text(largeKitchen.getText() + " " + largeKitchenComboBox.getValue());
                    largeKText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                    largeKText.setFill(Color.BLUEVIOLET);
                    // work cat
                    String largeKitchencomboString = (largeKitchenComboBox.getValue().toString());
                    workCatArrayList.add(largeKitchencomboString);
                    newHouse.numbLargeKitchens = Integer.parseInt(largeKitchen.getText());
                    if (largeKitchencomboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbLargeKitchens;

                    }
                    if (largeKitchencomboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbLargeKitchens;

                    }
                    if (largeKitchencomboString.equals(newWallString)) {
                        newWall += newHouse.numbLargeKitchens;

                    }
                    if (largeKitchencomboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbLargeKitchens;

                    }
                }

            }

            //nomal
            Text normalKLabel = new Text("Normal");
            normalKLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            normalKLabel.setFill(Color.STEELBLUE);

            if (normalkitchen.getText().equals("0")) {
                normalKText = new Text(normalkitchen.getText());
                normalKText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                normalKText.setFill(Color.BLUEVIOLET);

            } else {
                if (normmaKitchenlComboBox.getValue() instanceof String) {
                    normalKText = new Text(normalkitchen.getText() + " " + normmaKitchenlComboBox.getValue());
                    normalKText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                    normalKText.setFill(Color.BLUEVIOLET);
                    newHouse.numbNormalKitchens = Integer.parseInt(normalkitchen.getText());
                    String normalKitchenComboString = normmaKitchenlComboBox.getValue().toString();
                    // work cat
                    workCatArrayList.add(normmaKitchenlComboBox.getValue().toString());
                    if (normalKitchenComboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbNormalKitchens;

                    }
                    if (normalKitchenComboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbNormalKitchens;

                    }
                    if (normalKitchenComboString.equals(newWallString)) {
                        newWall += newHouse.numbNormalKitchens;

                    }
                    if (normalKitchenComboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbNormalKitchens;

                    }

                }

            }

            //small
            Text smallKLabel = new Text("Small");
            smallKLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            smallKLabel.setFill(Color.STEELBLUE);

            if (smallkitchen.getText().equals("0")) {

                smallKText = new Text(smallkitchen.getText());
                smallKText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                smallKText.setFill(Color.BLUEVIOLET);

            } else {
                if (smalKitchenComboBox.getValue() instanceof String) {
                    smallKText = new Text(smallkitchen.getText() + " " + smalKitchenComboBox.getValue());
                    smallKText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                    smallKText.setFill(Color.BLUEVIOLET);
                    // work cat
                    String smallKitchenComboString = smalKitchenComboBox.getValue().toString();
                    newHouse.numbSmallKitchen = Integer.parseInt(smallkitchen.getText());
                    workCatArrayList.add(smalKitchenComboBox.getValue().toString());
                    if (smallKitchenComboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbSmallKitchen;

                    }
                    if (smallKitchenComboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbSmallKitchen;

                    }
                    if (smallKitchenComboString.equals(newWallString)) {
                        newWall += newHouse.numbSmallKitchen;

                    }
                    if (smallKitchenComboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbSmallKitchen;

                    }
                }

            }

            //TOILETS BATHS SHOWERS====================================
            Text bathrooms = new Text("Bath Rooms");
            bathrooms.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            Text tbslabel = new Text("TBS");
            tbslabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            tbslabel.setFill(Color.STEELBLUE);
            // TOILET BATH SHOWERS COMBI

            if (toiletbathShowerTextField.getText().equals("0")) {
                tbsText = new Text(toiletbathShowerTextField.getText());
                tbsText.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
                tbsText.setFill(Color.MAGENTA);
            } else {
                if (TBSComboBox.getValue() instanceof String) {
                    tbsText = new Text(toiletbathShowerTextField.getText() + " " + TBSComboBox.getValue());
                    tbsText.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
                    tbsText.setFill(Color.MAGENTA);
                    // WORK AREA
                    String tbsComboString = TBSComboBox.getValue().toString();
                    newHouse.numbToiletBathShower = Integer.parseInt(toiletbathShowerTextField.getText());
                    workCatArrayList.add(TBSComboBox.getValue().toString());

                    if (tbsComboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbToiletBathShower;

                    }
                    if (tbsComboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbToiletBathShower;

                    }
                    if (tbsComboString.equals(newWallString)) {
                        newWall += newHouse.numbToiletBathShower;

                    }
                    if (tbsComboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbToiletBathShower;

                    }
                }

            }

            // toilet batths only
            Text tbLabel = new Text("TB");
            tbLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            tbLabel.setFill(Color.STEELBLUE);

            if (bathToiletField.getText().equals("0")) {
                tbText = new Text(bathToiletField.getText());
                tbText.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
                tbText.setFill(Color.MAGENTA);

            } else {
                if (TBcombBox.getValue() instanceof String) {
                    tbText = new Text(bathToiletField.getText() + " " + TBcombBox.getValue());
                    tbText.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
                    tbText.setFill(Color.MAGENTA);
                    //work araa
                    newHouse.numbToiletBath = Integer.parseInt(bathToiletField.getText());
                    String tbComboString = TBcombBox.getValue().toString();
                    workCatArrayList.add(TBcombBox.getValue().toString());
                    if (tbComboString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbToiletBath;

                    }
                    if (tbComboString.equals(twocoatString)) {
                        twoCoat += newHouse.numbToiletBath;

                    }
                    if (tbComboString.equals(newWallString)) {
                        newWall += newHouse.numbToiletBath;

                    }
                    if (tbComboString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbToiletBath;

                    }
                }

            }

            // Toilets only
            Text toiletLabel = new Text("Toilet");
            toiletLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            toiletLabel.setFill(Color.STEELBLUE);

            if (toiletTextField.getText().equals("0")) {
                toiletText = new Text(toiletTextField.getText());
                toiletText.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
                toiletText.setFill(Color.MAGENTA);

            } else {
                if (toiletComboBox.getValue() instanceof String) {
                    toiletText = new Text(toiletTextField.getText() + " " + toiletComboBox.getValue());
                    toiletText.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
                    toiletText.setFill(Color.MAGENTA);
                    //work area
                    newHouse.numbToilets = Integer.parseInt(toiletTextField.getText());
                    String toilletCombString = toiletComboBox.getValue().toString();
                    workCatArrayList.add(toiletComboBox.getValue().toString());

                    if (toilletCombString.equals(oneCoaString)) {
                        oneCoat += newHouse.numbToilets;

                    }
                    if (toilletCombString.equals(twocoatString)) {
                        twoCoat += newHouse.numbToilets;

                    }
                    if (toilletCombString.equals(newWallString)) {
                        newWall += newHouse.numbToilets;

                    }
                    if (toilletCombString.equals(prepLevelString)) {
                        prepLevel += newHouse.numbToilets;

                    }
                }

            }
            //=====================COMPUTATION AREA================================================================

// ROOMS
            newHouse.rooms = newHouse.numbKingSize + newHouse.numbDoubleRoom + newHouse.numbSingleRoom;
            int totalKingSizeRoomsArea = (newHouse.numbKingSize) * (newHouse.kingSizeWallArea + newHouse.kingSizeceilingArea);
            int totalDoubleRoomsArea = (newHouse.numbDoubleRoom) * (newHouse.doubleRoomWallArea + newHouse.doubleRoomCeilingArea);
            int totalSingleRoomsArea = (newHouse.numbSingleRoom) * (newHouse.singleRoomWallArea + newHouse.singleRoomCeilingArea);
            // LIVING ROOMS

            // KITCHEN
            //BATH TOILET SHOWER
            // totalWorkLevelScore = workCatArrayList.size();
            // CALCULATE PERCENTAGES =============================================
            totalWorkLevelScore = oneCoat + twoCoat + newWall + prepLevel;
            System.out.println("total score   " + totalWorkLevelScore);// debuging

            //===========================================PIE CHART=====LABOUR=====================================================================
            oneCoatPercentage = oneCoat;
            twoCoatPercentage = twoCoat;
            newWallPercentage = newWall;
            prepLevelPercentage = prepLevel;

            workChartObservableList = FXCollections.observableArrayList(
                    new PieChart.Data(oneCoaString, oneCoatPercentage),
                    new PieChart.Data(twocoatString, twoCoatPercentage),
                    new PieChart.Data(newWallString, newWallPercentage),
                    new PieChart.Data(prepLevelString, prepLevelPercentage)
            );
            final PieChart chart = new PieChart(workChartObservableList);

            //====================================================BAR CHART===== AREA======================================
            System.out.println("numbero rooms " + newHouse.getRooms());
            System.out.println("twocoat  " + twoCoat);
            System.out.println("one percent" + oneCoatPercentage);
            System.out.println("two " + twoCoatPercentage);
//================================================================================================================================
            // Grid pane
            reportGridPane = new GridPane();
            reportGridPane.setVgap(10);
            reportGridPane.setHgap(10);
            //  reportGridPane.setGridLinesVisible(true);

            reportGridPane.add(title, 3, 0);
            reportGridPane.add(clientNameLabel, 1, 1);
            reportGridPane.add(clientText, 2, 1);
            reportGridPane.add(addressLable, 1, 2);
            reportGridPane.add(addrText, 2, 2);
            //  property details
            //reportGridPane.add(rooms, 2, 3);
            // reportGridPane.add(new Text(newHouse.getNumbRooms_texString()), 3, 3, 2,1); // TOTALL NUMBER OF ROOMS
            reportGridPane.add(masterbedroom, 3, 4);
            reportGridPane.add(masterbedText, 4, 4);
            reportGridPane.add(doubleroom, 3, 5);
            reportGridPane.add(doublebedText, 4, 5);
            reportGridPane.add(singleroom, 3, 6);
            reportGridPane.add(singlebedText, 4, 6);

            //living room 
            reportGridPane.add(livingroom, 11, 4);

            reportGridPane.add(LargelivingroomLabel, 11, 5);
            reportGridPane.add(largeLivingText, 12, 5);
            reportGridPane.add(normalLivingroomLabel, 11, 6);
            reportGridPane.add(normalLivingText, 12, 6);

            reportGridPane.add(smallLivingLabel, 11, 7);
            reportGridPane.add(smallLivingText, 12, 7);

            // KITCHEN ======================================================
            reportGridPane.add(kitchen, 17, 4);
            reportGridPane.add(largeKLabel, 17, 5);
            reportGridPane.add(largeKText, 18, 5);
            reportGridPane.add(normalKLabel, 17, 6);
            reportGridPane.add(normalKText, 18, 6);

            reportGridPane.add(smallKLabel, 17, 7);
            reportGridPane.add(smallKText, 18, 7);

            // BATHS=========================================
            reportGridPane.add(bathrooms, 19, 4);
            reportGridPane.add(tbslabel, 19, 5);
            reportGridPane.add(tbsText, 20, 5);
            reportGridPane.add(tbLabel, 19, 6);
            reportGridPane.add(tbText, 20, 6);

            reportGridPane.add(toiletLabel, 19, 7, 1, 1);
            reportGridPane.add(toiletText, 20, 7, 1, 1);
            reportGridPane.add(hLine(), 0, 8, 170, 1);
            // chart pie chart
            reportGridPane.add(PiechartHeading, 0, 9, 1, 1);
            reportGridPane.add(chart, 0, 10, 8, 8);

            //  root pane
            root.setCenter(reportGridPane);

            oneCoat = 0;
            oneCoatPercentage = 0;
            twoCoat = 0;
            twoCoatPercentage = 0;
            newWall = 0;
            newWallPercentage = 0;
            prepLevel = 0;
            prepLevelPercentage = 0;
            totalWorkLevelScore = 0;
            workCatArrayList.clear();
        });

        // RESERT BUTTONS=======================================EVENT=========================
        resertButton.setOnAction((event) -> {
            kingsizeComboBox.valueProperty().set(null);
            doubleComboBox.valueProperty().set(null);
            singlecComboBox.valueProperty().set(null);
            largeComboBox.valueProperty().set(null);
            normmalComboBox.valueProperty().set(null);
            smallComboBox.valueProperty().set(null);
            largeKitchenComboBox.valueProperty().set(null);
            normmaKitchenlComboBox.valueProperty().set(null);
            smalKitchenComboBox.valueProperty().set(null);
            TBSComboBox.valueProperty().set(null);
            TBcombBox.valueProperty().set(null);
            toiletComboBox.valueProperty().set(null);
            // RESET TEXT FIELD
            kingsizeTextField.setText("0");
            doubleroomTextField.setText("0");;
            singleroomtTextField.setText("0");
            //reset living room
            largelivingTextField.setText("0");
            normallivingTextField.setText("0");
            smalllivingTextField.setText("0");
            // reset  kitchen
            largeKitchen.setText("0");
            normalkitchen.setText("0");
            smallkitchen.setText("0");
            // baths=====================
            toiletbathShowerTextField.setText("0");
            bathToiletField.setText("0");
            toiletTextField.setText("0");

            // reset data
            oneCoat = 0;
            oneCoatPercentage = 0;
            twoCoat = 0;
            twoCoatPercentage = 0;
            newWall = 0;
            newWallPercentage = 0;
            prepLevel = 0;
            prepLevelPercentage = 0;
            totalWorkLevelScore = 0;
            workCatArrayList.clear();
        });

        //Report Panel
        Scene scene = new Scene(root, 1400, 600);

        primaryStage.setTitle("PJS renovations quick project assesment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static GridPane formsgGridPane() {

        formsgGridPane = new GridPane();

        formsgGridPane.setHgap(10);

        // formsgGridPane.add(addressHBox, 1, 0);
        //add separator to grid
        formsgGridPane.add(hLine(), 0, 1, 12, 1);

        //rooms form
        Text roomformheading = new Text(" Enter  rooms & Work category");
        formsgGridPane.add(roomformheading, 1, 2);
        formsgGridPane.add(roomsFormHBox(), 1, 3);

        //living rooms
        Text livingRoomHeading = new Text("Enter Living rooms  & Work category");
        formsgGridPane.add(livingRoomHeading, 3, 2);
        formsgGridPane.add(livingRoomFormBox(), 3, 3);

        //kitchen
        Text kitchenHeading = new Text("Enter Kitchen & work category");
        formsgGridPane.add(kitchenHeading, 5, 2);
        formsgGridPane.add(kitchenFormBox(), 5, 3);

        //baths toilets
        Text bathsheadText = new Text("Enter Bath, toilets & work category");
        formsgGridPane.add(bathsheadText, 7, 2);
        formsgGridPane.add(bathFormBox(), 7, 3);

        return formsgGridPane;

    }

    static HBox roomsFormHBox() {
        //rooms fields
        kingsizeTextField.setText("0");
        doubleroomTextField.setText("0");
        singleroomtTextField.setText("0");
        VBox vBoxrooms = new VBox(10);
        vBoxrooms.getChildren().addAll(kingsizeTextField, doubleroomTextField, singleroomtTextField);
        //rooms combo box
        kingsizeComboBox = new ComboBox();
        kingsizeComboBox.setPromptText(promtString);
        kingsizeComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");
        doubleComboBox = new ComboBox();
        doubleComboBox.setPromptText(promtString);
        doubleComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");
        singlecComboBox = new ComboBox();
        singlecComboBox.setPromptText(promtString);
        singlecComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");

        VBox roomsCBox = new VBox(10);
        roomsCBox.getChildren().addAll(kingsizeComboBox, doubleComboBox, singlecComboBox);
        // labels vbox
        Label kingsize = new Label("KingSize");
        Label doubleroom = new Label("Double");
        Label Singleroom = new Label("Single");
        VBox roomlables = new VBox(15);
        roomlables.getChildren().addAll(kingsize, doubleroom, Singleroom);
        //hbox for forms
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(roomlables, vBoxrooms, roomsCBox);
        return hBox;

    }

    static HBox livingRoomFormBox() {
        // living rooms field
        largelivingTextField.setText("0");
        normallivingTextField.setText("0");
        smalllivingTextField.setText("0");
        VBox vBoxrooms = new VBox(10);
        vBoxrooms.getChildren().addAll(largelivingTextField, normallivingTextField, smalllivingTextField);
        //rooms combo box
        largeComboBox = new ComboBox();
        largeComboBox.setPromptText(promtString);
        largeComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");
        normmalComboBox = new ComboBox();
        normmalComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");
        normmalComboBox.setPromptText(promtString);
        smallComboBox = new ComboBox();
        smallComboBox.setPromptText(promtString);
        smallComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");

        VBox roomsCBox = new VBox(10);
        roomsCBox.getChildren().addAll(largeComboBox, normmalComboBox, smallComboBox);
        // labels vbox
        Label kingsize = new Label("Large ");
        Label doubleroom = new Label("Normal ");
        Label Singleroom = new Label("Small ");
        VBox roomlables = new VBox(15);
        roomlables.getChildren().addAll(kingsize, doubleroom, Singleroom);
        //hbox for forms
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(roomlables, vBoxrooms, roomsCBox);
        return hBox;

    }

    static HBox kitchenFormBox() {

        //formfields
        largeKitchen = new NumberTextField(0);
        largeKitchen.setText("0");
        normalkitchen = new NumberTextField(0);
        normalkitchen.setText("0");
        smallkitchen = new NumberTextField(0);
        smallkitchen.setText("0");
        VBox kitchenFormvbox = new VBox(10);
        kitchenFormvbox.getChildren().addAll(largeKitchen, normalkitchen, smallkitchen);
        //combo boxes for kitchen
        largeKitchenComboBox = new ComboBox();
        largeKitchenComboBox.setPromptText(promtString);
        largeKitchenComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");
        normmaKitchenlComboBox = new ComboBox();
        normmaKitchenlComboBox.setPromptText(promtString);
        normmaKitchenlComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");
        smalKitchenComboBox = new ComboBox();
        smalKitchenComboBox.setPromptText(promtString);
        smalKitchenComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");
        VBox vBoxKitchen = new VBox(10);
        vBoxKitchen.getChildren().addAll(largeKitchenComboBox, normmaKitchenlComboBox, smalKitchenComboBox);
        // labels vbox
        Label largLabel = new Label("Large ");
        Label normaLabel = new Label("Normal ");
        Label smalllaLabel = new Label("Small ");
        VBox kitchenlableBox = new VBox(15);
        kitchenlableBox.getChildren().addAll(largLabel, normaLabel, smalllaLabel);
        //hbox
        HBox kitchenhBox = new HBox(10);
        kitchenhBox.getChildren().addAll(kitchenlableBox, kitchenFormvbox, vBoxKitchen);
        return kitchenhBox;
    }

    static HBox bathFormBox() {

        // bath formfields
        bathToiletField = new NumberTextField(0);
        bathToiletField.setText("0");
        toiletbathShowerTextField = new NumberTextField(0);
        toiletbathShowerTextField.setText("0");
        toiletTextField = new NumberTextField(0);
        toiletTextField.setText("0");
        VBox bathFormvbox = new VBox(10);
        bathFormvbox.getChildren().addAll(toiletbathShowerTextField, bathToiletField, toiletTextField);
        //combo boxes for kitchen
        TBSComboBox = new ComboBox();
        TBSComboBox.setPromptText(promtString);
        TBSComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");
        TBcombBox = new ComboBox();
        TBcombBox.setPromptText(promtString);
        TBcombBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");
        toiletComboBox = new ComboBox();
        toiletComboBox.setPromptText(promtString);
        toiletComboBox.getItems().addAll("one coats", "two coats", "new wall", "prep level");
        VBox vBoxCombo = new VBox(10);
        vBoxCombo.getChildren().addAll(TBSComboBox, TBcombBox, toiletComboBox);
        // labels vbox
        Label TBSLabel = new Label("T B S ");
        Label TBLabel = new Label("T B ");
        Label toiletlabel = new Label("Toilet ");
        VBox tbsvBoxlabel = new VBox(15);
        tbsvBoxlabel.getChildren().addAll(TBSLabel, TBLabel, toiletlabel);
        //hbox
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(tbsvBoxlabel, bathFormvbox, vBoxCombo);
        return hBox;
    }

    static Separator hLine() {

        Separator addressSep = new Separator();
        addressSep.setMaxWidth(40);
        addressSep.setValignment(VPos.CENTER);
        addressSep.setMaxWidth(Double.MAX_VALUE);
        return addressSep;

    }

    static HBox addressBar() {
        //address bar
        Label addreLabel = new Label("Enter Address ");
        Text ownerLabel = new Text("Owner");
        Text postcode = new Text("enter post code");

        addressField = new TextField();
        addressField.setText("");
        addressField.setPrefWidth(200);
        addressField.setMaxWidth(200);
        ownerName = new TextField();
        postcodeField = new TextField();

        addressHBox = new HBox(20);
        addressHBox.setPadding(new Insets(0, 10, 0, 10));
        addressHBox.getChildren().addAll(ownerLabel, ownerName, addreLabel, addressField, postcode, postcodeField);
        return addressHBox;

    }

    static HBox buttonsHBox() {
        // Buttoms
        reportButton = new Button("G Report");
        reportButton.setMaxWidth(Double.MAX_VALUE);
        resertButton = new Button("Resert");
        HBox buttonsHBox = new HBox(10);
        buttonsHBox.setPadding(new Insets(0, 10, 0, 10));
        buttonsHBox.getChildren().addAll(reportButton, resertButton);
        return buttonsHBox;

    }

    static GridPane reportGridPane() {

        return reportGridPane;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
