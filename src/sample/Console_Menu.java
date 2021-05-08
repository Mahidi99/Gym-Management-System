package sample;

import java.io.IOException;
import java.util.Scanner;

public class Console_Menu {

    private final static MyGymManager managerOfGym = new MyGymManager();
    //initializing the variable MaxNoOfMembers to count the members
    private static int MaxNoOfMembers = 0;

    public static void main(String[] args) throws IOException {

        Scanner option = new Scanner(System.in);
        int choice = 0;

        //options the user can select
        do {
            System.out.println("\nYou can select one of the following management actions...");
            System.out.println("\t1)Add a new member");
            System.out.println("\t2)Delete a member");
            System.out.println("\t3)Print the list of members");
            System.out.println("\t4)Sort the item");
            System.out.println("\t5)Write/Save in a file");
            System.out.println("\t6)Open GUI to visualise members");
            System.out.println("\t7)Open GUI to search members");
            System.out.println("\t8)Exit program");

            // Enter an option number
            System.out.print("\nWhat is your option > ");

            //when the input of user is a letter of something else
            while (!option.hasNextInt()) {
                System.out.println("\nYour input is invalid! Please enter an option number.");
                System.out.print("What is your option > ");
                option.next();
            }
            choice = option.nextInt();

            switch (choice) {
                //when the user inputs "1"
                case 1:
                    AddingNewMembers_2();
                    break;
                //when the user inputs "2"
                case 2:
                    DeletingAMember();
                    break;
                //when the user inputs "3"
                case 3:
                    managerOfGym.PrintTheListOfMembers();
                    break;
                //when the user inputs "4"
                case 4:
                    managerOfGym.Sorting__TheMembers();
                    break;
                //when the user inputs "5"
                case 5:
                    managerOfGym.SaveInAFile();
                    break;
                //when the user inputs "6"
                case 6:
                    managerOfGym.GUI1();
                    System.out.println("Graphical User Interface is successfully opened !");
                    break;
                //when the user inputs "7"
                case 7:
                    managerOfGym.GUI2();
                    System.out.println("Graphical User Interface is successfully opened !");
                    break;
                //when the user inputs "7"
                case 8:
                    System.out.println("_Exit the System_");
                    System.exit(0);
                //when the user inputs a wrong number
                default:
                    System.out.println("\nYour input number is invalid!! Please re-enter an option number between 1-8!");
            }

        } while (choice != 8);
    }

    ////////////////////////////// For adding members /////////////////////////

    private static void AddingNewMembers_2(){
        Scanner InputData = new Scanner(System.in);
        //checking there are free spaces or not
        if (MaxNoOfMembers < 100){
                // MaxNoOfMembers = Number of added members
            System.out.print("\nEnter the Membership Number : ");
            String MembershipNumberOfMember = InputData.next();
            System.out.print("Enter the Name : ");
            String NameOfMember_ = InputData.next();
            System.out.print("Enter the Membership Start Date (DD/MM/YYYY) : ");
            String Start__MembershipDate = InputData.next();
            System.out.print("\tD or d - Default Member\n\tS or s - Student Member\n\tO or o - Over60 Member\n");
            System.out.print("Enter the Member Type : ");
            String type = InputData.next();
            DefaultMember MemberOfGym = null;

            switch (type){
                    //when the user inputs "D"
                case "D":
                    //when the user inputs "d"
                case "d":
                    MemberOfGym = new DefaultMember(MembershipNumberOfMember, NameOfMember_, Start__MembershipDate);
                    break;

                    //when the user inputs "S"
                case "S":
                    //when the user inputs "s"
                case "s":
                    System.out.print("Enter the School name : ");
                    String School__Name = InputData.next();
                    MemberOfGym = new StudentMember(MembershipNumberOfMember, NameOfMember_, Start__MembershipDate, School__Name);
                    break;
                    //when the user inputs "O"
                case "O":
                    //when the user inputs "o"
                case "o":
                    System.out.print("Enter the member age : ");
                    int AgeOfTheMember = InputData.nextInt();

                    //when the age is less than to 60
                    while (AgeOfTheMember < 60) {
                        System.out.println("\nThis age doesn't belong to Over60Member type. Try Again !");
                        System.out.print("Enter the correct member age again : ");
                        AgeOfTheMember = InputData.nextInt();
                    }

                    MemberOfGym = new Over60Member(MembershipNumberOfMember, NameOfMember_, Start__MembershipDate, AgeOfTheMember);
                    break;
                default:
                    System.out.println("Your input is invalid !!");
            }

            managerOfGym.AddingANewMember(MemberOfGym);
            MaxNoOfMembers++; //increasing by one
        } else {
            System.out.println("Sorry! no free spaces for a new member");
        }
    }

    ////////////////////////////// For deleting members /////////////////////////

    private static void DeletingAMember(){
        Scanner InputDelete = new Scanner(System.in);
        System.out.print("\nEnter the Membership Number of member you want to delete : ");
        String MembershipNumberOfMember = InputDelete.next();
        boolean DeletedResult = managerOfGym.DeletingAMember(MembershipNumberOfMember);
        if (DeletedResult){
            MaxNoOfMembers--; //decreasing by one
        }
    }
}
