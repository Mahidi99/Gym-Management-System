package sample;

public class StudentMember extends DefaultMember {

    //initializing School name of member
    private String School__Name;

    public StudentMember(String MembershipNumberOfMember, String NameOfMember_, String Start__MembershipDate, String School__Name){
        super(MembershipNumberOfMember, NameOfMember_, Start__MembershipDate);
        this.School__Name = School__Name;
    }
}
