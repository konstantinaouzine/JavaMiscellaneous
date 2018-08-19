package Annotations_Training.Example2_DBCreate_According_To_Class;

@DBTable(name = "MEMBER")
public class MemberClass {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String handle;

    static int memberCount;

    public String getHandle(){return handle;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public Integer getAge(){return age;}

    public String toString(){return handle;}
}
