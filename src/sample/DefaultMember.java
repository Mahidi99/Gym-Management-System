package sample;

import java.util.Objects;

public class DefaultMember implements Comparable<DefaultMember> {
    private String MembershipNumberOfMember;
    private String NameOfMember_;
    private String Start__MembershipDate;

    public DefaultMember (String MembershipNumberOfMember, String NameOfMember_, String Start__MembershipDate){
        super();
        this.MembershipNumberOfMember = MembershipNumberOfMember;
        this.NameOfMember_ = NameOfMember_;
        this.Start__MembershipDate = Start__MembershipDate;
    }

    public String getMembershipNumberOfMember(){
        return MembershipNumberOfMember;
    }

    public void setMembershipNumberOfMember(String MembershipNumberOfMember){
        this.MembershipNumberOfMember = MembershipNumberOfMember;
    }

    public String getNameOfMember_(){
        return NameOfMember_;
    }

    public void setNameOfMember_(String NameOfMember_){
        this.NameOfMember_ = NameOfMember_;
    }

    public String getStart__MembershipDate(){
        return Start__MembershipDate;
    }

    public void setStart__MembershipDate(String Start__MembershipDate){
        this.Start__MembershipDate = Start__MembershipDate;
    }

    @Override
    public int compareTo(DefaultMember n) {
        //
        return this.MembershipNumberOfMember.compareTo(n.getMembershipNumberOfMember()) ;
    }
}
