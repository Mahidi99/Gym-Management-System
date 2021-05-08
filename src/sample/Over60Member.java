package sample;

public class Over60Member extends DefaultMember {

    //initializing the age of the member
    private int AgeOfTheMember;

    public Over60Member(String MembershipNumberOfMember, String NameOfMember_, String Start__MembershipDate, int AgeOfTheMember){
        super(MembershipNumberOfMember, NameOfMember_, Start__MembershipDate);
        this.AgeOfTheMember = AgeOfTheMember;
    }

}
