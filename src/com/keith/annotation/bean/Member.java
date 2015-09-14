package com.keith.annotation.bean;

/**
 * Created by Keith on 9/14/15.
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String handle;

    static int memberCount;
    public String getHandle() {
        return handle;
    }
    public String getFirstName () {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString () {
        return handle;
    }

    public Integer getAge() {
        return age;
    }

    public static void main (String args[]) {
        Member member = new Member();
        System.out.println(member.getFirstName());
        member.toString();
    }
}
