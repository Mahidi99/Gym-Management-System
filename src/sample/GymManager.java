package sample;

import java.io.IOException;
import java.util.List;

public interface GymManager {

        //Adding a new_member
    public void AddingANewMember(DefaultMember MemberOfGym);
        //Deleting a member
    public boolean DeletingAMember(String MembershipNumberOfMember);

    //Printing added members
    public void PrintTheListOfMembers();


    //Opening_GUI_to_visualise_members
    void GUI1();

    //Opening_GUI_to_search_members
    void GUI2();

    //Sorting added members
    public List<DefaultMember> Sorting__TheMembers();

        //store data into a text file
    void SaveInAFile() throws IOException;

}
