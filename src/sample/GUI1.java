package sample;

import com.sun.org.apache.xpath.internal.operations.String;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GUI1 extends Application {
    private List<DefaultMember> MemberOfGymList = new ArrayList<DefaultMember>();
    Stage window;
    Scene scene__HomePage,SceneUser__Visualise;
        //Graphical User Interface
    @Override
    public void start(Stage primary__Stage) {

        /////////////////////////////////Home__Page////////////////////////////

        window = primary__Stage;
        window.setTitle("Gym Management System");

        GridPane grid__Home = new GridPane(); // to create a grid pane to first page
        grid__Home.setHgap(20);
        grid__Home.setVgap(20);
        grid__Home.setAlignment(Pos.TOP_CENTER);

        grid__Home.setPadding(new Insets(0, 1, 5, 1));
            //adding background image
        Image GUI__BackgroundImage = new Image(getClass().getResourceAsStream("gym2.jpg"));

        BackgroundImage GUI__Theme = new BackgroundImage(GUI__BackgroundImage,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT);

            //create the Background
        Background GUI__background = new Background(GUI__Theme);
        grid__Home.setBackground(GUI__background);

        Image Gym__Logo = new Image(getClass().getResourceAsStream("HomeLogo.png"));
        Label HomeLogo__Label = new Label("", new ImageView(Gym__Logo));
        grid__Home.add(HomeLogo__Label, 2, 3);

        Button visualise__Btn = new Button("Visualise");
        visualise__Btn.setFont(Font.font(25));
        grid__Home.add(visualise__Btn, 2, 7);
        visualise__Btn.setOnAction(event -> window.setScene(SceneUser__Visualise));

        /*Button Search__Btn = new Button(" Search ");
        Search__Btn.setFont(Font.font(25));
        grid__Home.add(Search__Btn, 1, 10);
        Search__Btn.setOnAction(event -> window.setScene(SceneUser__Search));*/


        scene__HomePage = new Scene(grid__Home, 1400, 700);    //Set Scene


        ///////////////////////////////////Visualise////////////////////////////////////

        GridPane grid__Visualise = new GridPane();
        grid__Visualise.setAlignment(Pos.TOP_CENTER);
        grid__Visualise.setHgap(20);
        grid__Visualise.setVgap(20);

        grid__Visualise.setPadding(new Insets(0, 1, 5, 1));

            //Background Image
        GUI__BackgroundImage = new Image(getClass().getResourceAsStream("gym2.jpg"));

        GUI__Theme = new BackgroundImage(GUI__BackgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // creating Background
        GUI__background = new Background(GUI__Theme);
        grid__Visualise.setBackground(GUI__background);


        Image img__Back = new Image(getClass().getResourceAsStream("Back.png"));
        Button Go__back = new Button("", new ImageView(img__Back));
        Go__back.setTextAlignment(TextAlignment.LEFT);
        grid__Visualise.add(Go__back, 1, 5);
        Go__back.setOnAction(event -> window.setScene(scene__HomePage));


            ////////////// Creating Table - visualise//////////////////

        TableView Visualise__TableView = new TableView();
        Visualise__TableView.setMaxWidth(1000);
        Visualise__TableView.setLayoutX(30);
        Visualise__TableView.setLayoutY(100);

        TableColumn<String, MyGymManager> column__1 = new TableColumn<>("Membership Number");
        column__1.setMinWidth(150);
        column__1.setCellValueFactory(new PropertyValueFactory<>("MembershipNumberOfMember"));

        TableColumn<String, MyGymManager> column__2 = new TableColumn<>("Name");
        column__2.setMinWidth(120);
        column__2.setCellValueFactory(new PropertyValueFactory<>("NameOfMember_"));

        TableColumn<String, MyGymManager> column__3 = new TableColumn<>("Membership Start Date");
        column__3.setMinWidth(150);
        column__3.setCellValueFactory(new PropertyValueFactory<>("Start__MembershipDate"));


        List<DefaultMember> member__List = new ArrayList<>();
        DefaultMember member__1= new DefaultMember("W1790252","Mahidi","02/09/2019");
        member__List.add(member__1);

        DefaultMember member__2= new DefaultMember("34A","John","22/06/2018");
        member__List.add(member__2);

        DefaultMember member__3= new DefaultMember("312","Piyumini","12/10/2020");
        member__List.add(member__3);

        DefaultMember member__4= new DefaultMember("98B","Amelia","31/12/2020");
        member__List.add(member__4);

        DefaultMember member__5= new DefaultMember("W1790576","Oshini","13/04/2017");
        member__List.add(member__5);

        DefaultMember member__6= new DefaultMember("199","Madhuvy","27/11/2020");
        member__List.add(member__6);

        DefaultMember member__7= new DefaultMember("A1790","Shemil","16/04/2018");
        member__List.add(member__7);

        ObservableList<DefaultMember> List = FXCollections.observableArrayList(member__List);


        Visualise__TableView.setItems(List);

        Visualise__TableView.getColumns().add(column__1);
        Visualise__TableView.getColumns().add(column__2);
        Visualise__TableView.getColumns().add(column__3);


        grid__Visualise.getChildren().add(Visualise__TableView);

        SceneUser__Visualise = new Scene(grid__Visualise, 1400, 700);


        ///////////////////////////////////////
        window.setScene(scene__HomePage);
        window.show();
        /////////////////////////////////////

    }

    public static void main(String[] args) {
        launch(args);
    }
    private static void launch(String[] args) {
    }
}