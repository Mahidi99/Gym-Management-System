package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GUI2 extends Application
{

        //adding_member_details
    private TableView<Member__Details> Search__Table = new TableView<Member__Details>();
    private final ObservableList<Member__Details> details = FXCollections.observableArrayList(
            new Member__Details("W1790252", "Mahidi", "02/09/2019"),
            new Member__Details("34A", "John", "22/06/2018"),
            new Member__Details("312", "Piyumini", "12/10/2020"),
            new Member__Details("98B", "Amelia", "31/12/2020"),
            new Member__Details("W1790576", "Madhuvy", "13/04/2017"),
            new Member__Details("A1790", "Shemil", "16/04/2018")

    );


    @Override
    public void start(Stage Searching__stage) {
        Scene Scene__UserSearch = new Scene(new Group());
        Searching__stage.setTitle("Searching Members");
        //setting_width
        Searching__stage.setHeight(550);
        //setting_height
        Searching__stage.setWidth(550);


            //Creating_Table

        TableColumn column__1b = new TableColumn("Membership Number");
            //set_the_width_of_the_column
        column__1b.setMinWidth(200);
        column__1b.setCellValueFactory(new PropertyValueFactory<Member__Details, String>("MembershipNumberOfMember"));

        TableColumn column__2b = new TableColumn("Name");
            //set_the_width_of_the_column
        column__2b.setMinWidth(100);
        column__2b.setCellValueFactory(new PropertyValueFactory<Member__Details, String>("NameOfMember_"));

        TableColumn column__3b = new TableColumn("Membership Start Date");
            //set_the_width_of_the_column
        column__3b.setMinWidth(200);
        column__3b.setCellValueFactory(new PropertyValueFactory<Member__Details, String>("Start__MembershipDate"));

            //Passing_members'_details_into_a_filtered_list
        FilteredList<Member__Details> FilteredMember__Details = new FilteredList(details, f -> true);
            //Set_the_items_of_the_table
        Search__Table.setItems(FilteredMember__Details);
        Search__Table.getColumns().addAll(column__1b, column__2b, column__3b);

            //Add_a_choiceBox_to_select_any_parameter_to_search
        ChoiceBox<String> ChoiceBoxToSearch = new ChoiceBox();
        ChoiceBoxToSearch.getItems().addAll("Membership Number", "Name", "Membership Start Date");
        ChoiceBoxToSearch.setValue("Membership Number");

            //adding_a_textfield_to_type
        TextField TypingTextField = new TextField();
        TypingTextField.setPromptText("Type here!");
            //Switch_the_value_of_choiceBox
        TypingTextField.setOnKeyReleased(keyEvent -> {
            switch (ChoiceBoxToSearch.getValue())
            {
                    //When_user_select_"Membership Number"
                case "Membership Number":
                    FilteredMember__Details.setPredicate(f -> f.getMembershipNumberOfMember().toLowerCase().contains(TypingTextField.getText().toLowerCase().trim()));
                    break;
                    //When_user_select_"Name"
                case "Name":
                    FilteredMember__Details.setPredicate(f -> f.getNameOfMember_().toLowerCase().contains(TypingTextField.getText().toLowerCase().trim()));
                    break;
                    //When_user_select_"Membership Start Date"
                case "Membership Start Date":
                    FilteredMember__Details.setPredicate(f -> f.getStart__MembershipDate().toLowerCase().contains(TypingTextField.getText().toLowerCase().trim()));
                    break;
            }
        });

            //to_reset_the_TypingTextField_and_table_when_user_select_a_new_choice
        ChoiceBoxToSearch.getSelectionModel().selectedItemProperty().addListener((observableValue,Old__Value,New__Value) ->
        {
            if (New__Value != null)
            {
                TypingTextField.setText("");
                    //Same_as FilteredMember__Details.setPredicate(f->true);//
                FilteredMember__Details.setPredicate(null);
            }
        });

            ///Creating_HBox_and_add_the_choiceBox_and_textField_to_it
        HBox Box = new HBox(ChoiceBoxToSearch, TypingTextField);
            //allign_to_center
        Box.setAlignment(Pos.CENTER);


            //Creating_VBox
        final VBox V_Box = new VBox();
        V_Box.setSpacing(6);
            //set_padding
        V_Box.setPadding(new Insets(9,0,0,9));
        V_Box.getChildren().addAll(Search__Table, Box);

        ((Group) Scene__UserSearch.getRoot()).getChildren().addAll(V_Box);

        Searching__stage.setScene(Scene__UserSearch);
        Searching__stage.show();
    }

    public static class Member__Details {

            //Membership_Number_Of_Member
        private final SimpleStringProperty MembershipNumberOfMember;
            //Name_of_the_member
        private final SimpleStringProperty NameOfMember_;
            //Start_Membership_Date
        private final SimpleStringProperty Start__MembershipDate;

        private Member__Details(String MemNum, String NameOfMem, String Start__MembershipDate) {
                ///Membership_Number_Of_Member
            this.MembershipNumberOfMember = new SimpleStringProperty(MemNum);
                ///Name_of_the_member
            this.NameOfMember_ = new SimpleStringProperty(NameOfMem);
                ///Start_Membership_Date
            this.Start__MembershipDate = new SimpleStringProperty(Start__MembershipDate);
        }

        public String getMembershipNumberOfMember() {
            return MembershipNumberOfMember.get();
        }

        public void setMembershipNumberOfMember(String MemNum) {
            MembershipNumberOfMember.set(MemNum);
        }

        public String getNameOfMember_() {
            return NameOfMember_.get();
        }

        public void setNameOfMember_(String MemNum) {
            NameOfMember_.set(MemNum);
        }

        public String getStart__MembershipDate() {
            return Start__MembershipDate.get();
        }

        public void setStart__MembershipDate(String MemNum) {
            Start__MembershipDate.set(MemNum);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
