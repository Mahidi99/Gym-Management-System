package sample;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyGymManager implements GymManager {

    private List<DefaultMember> MemberOfGymList = new ArrayList<DefaultMember>();

    ////////////////////////////////// Adding a new member ////////////////////////////////////

    @Override
    public void AddingANewMember(DefaultMember MemberOfGym){
        System.out.println("\nNumber of added members : "+(1 + MemberOfGymList.size()));
        System.out.println("Number of free spaces : "+(99 - MemberOfGymList.size()));

        //checking the list is full or not
        if (MemberOfGymList.size() < 100){
            MemberOfGymList.add(MemberOfGym);
        } else {
            System.out.println("Sorry! no spaces for another new member.");
        }
    }

    ////////////////////////////////// Deleting a new member ////////////////////////////////////

    @Override
    public boolean DeletingAMember(String MembershipNumberOfMember) {
        boolean DeleteMethod = false;

        //deleting a member who is in the MemberOfGymList
        for (DefaultMember MemberOfGym: MemberOfGymList){
            //checking the entered membership number is in the list or not
            if (MemberOfGym.getMembershipNumberOfMember().equals(MembershipNumberOfMember)){
                DeleteMethod = true;
                MemberOfGymList.remove(MemberOfGym);

                System.out.println("\nThis member is successfully removed!");
                System.out.print("\tName : "+MemberOfGym.getNameOfMember_()
                        + " |\tMembership Number : " + MembershipNumberOfMember);
                if (MemberOfGym instanceof StudentMember){
                    System.out.println(" |\tType of Member : StudentMember");
                } else if (MemberOfGym instanceof Over60Member){
                    System.out.println(" |\tType of Member : Over60Member");
                } else {
                    System.out.println(" |\tType of Member : DefaultMember");
                }

                //making the user know about the free spaces and number of added members
                System.out.println("\nNumber of added members : "+MemberOfGymList.size());
                System.out.println("Number of free spaces : "+(100-MemberOfGymList.size()));

                break;
            }
        }
        //when the user input a wrong membership number
        if (!DeleteMethod){
            System.out.println("Sorry! no member with this Membership Number.");
        }
        return DeleteMethod;
    }


    ////////////////////////////////// Printing the list of members ////////////////////////////////////

    @Override
    public void PrintTheListOfMembers() {
        //printing all the details of members who are in the MemberOfGymList
        for (DefaultMember MemberOfGym: MemberOfGymList){
            System.out.println("");
            System.out.print("\tName : "+MemberOfGym.getNameOfMember_() + " |\tMembership Number : " +
                    MemberOfGym.getMembershipNumberOfMember() + " |\tMembership start date : "+MemberOfGym.getStart__MembershipDate());
            if (MemberOfGym instanceof StudentMember){
                System.out.println(" |\tType of Member : StudentMember");
            } else if (MemberOfGym instanceof Over60Member){
                System.out.println(" |\tType of Member : Over60Member");
            } else {
                System.out.println(" |\tType of Member : DefaultMember");
            }
        }

        //when the 'MemberOfGymList' is empty
        if (MemberOfGymList.size() == 0){
            System.out.println("Nothing to print !");
        }
    }
    /////////////////////////////////////////Opening_GUI_to_visualise_members//////////////////////////////////////////////////
    @Override
    public void GUI1 () {
        new Thread() {
                //to run the interface
            @Override
            public void run() {
                //
                javafx.application.Application.launch(GUI1.class);
            }
        }
        //
        .start();
    }

    /////////////////////////////////////////Opening_GUI_to_search_members//////////////////////////////////////////////////
    @Override
    public void GUI2 () {
        new Thread() {
            //to run the interface
            @Override
            public void run() {
                //
                javafx.application.Application.launch(GUI2.class);
            }
        }
                //
                .start();
    }

    //////////////////////////////////Sorting_the_members////////////////////////////////////

    @Override
    public List<DefaultMember> Sorting__TheMembers() {

        DefaultMember[] ArrayInList = MemberOfGymList.toArray(new DefaultMember[] {});

        Arrays.sort(ArrayInList);
        List<DefaultMember> SortedList = Arrays.asList(ArrayInList);

        //sorting the members who are in MemberOf GymList, by name
        for(DefaultMember name : SortedList){

            System.out.print("\t");
                //Printing sorted members' names
            System.out.println(name.getNameOfMember_());

        }
        //when the 'MemberOfGymList' is empty
        if (MemberOfGymList.size() == 0){
            System.out.println("Nothing to sort !");
        }
        return SortedList;
    }

    //////////////////////////////////Saving_the_details_of_members ////////////////////////////////////

    @Override
    //storing data into 'Member_Details' text file
    public void SaveInAFile() throws IOException {
            //creating a text file
        File txtDoc =  new File("Member_Details.txt");
            //creating a file writer object
        FileWriter WriteMemberDetails =  null;
            //appending
        WriteMemberDetails =  new FileWriter(txtDoc,true);
            ////creating a new print writer object and auto flushing
        PrintWriter MemberDetails =  new PrintWriter(WriteMemberDetails, true);

        //saving details of all the members in MemberOfGymList
        for (DefaultMember MemberOfGym: MemberOfGymList){

            //writing data in the text file
            MemberDetails.write("\nMembership Number : " + MemberOfGym.getMembershipNumberOfMember()
                                + " |\tName:" + MemberOfGym.getNameOfMember_()
                                + " |\tStart Membership Date:" + MemberOfGym.getStart__MembershipDate());
            MemberDetails.println();

            if (MemberOfGym instanceof StudentMember){
                MemberDetails.write("\t" + MemberOfGym.getNameOfMember_() + " is a StudentMember");
                MemberDetails.println();
            } else if (MemberOfGym instanceof Over60Member){
                MemberDetails.write("\t" + MemberOfGym.getNameOfMember_() + " is a Over60Member");
                MemberDetails.println();
            } else {
                MemberDetails.write("\t" + MemberOfGym.getNameOfMember_() + " is a DefaultMember");
                MemberDetails.println();
            }
        }
        //when_the_'MemberOfGymList'_is_empty
        if (MemberOfGymList.size() == 0){
            System.out.println("Sorry! the list is empty !");
        } else {
            System.out.println("Details of members are successfully saved in 'Member_Details' text file.");
        }
    }
    }

