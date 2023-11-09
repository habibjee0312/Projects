import java.io.*;

public class Student implements Serializable{
    private String Id;
    private String name;
    private String department;
    private String semester;
    private String year;
    public Student(){}
    public Student(String id, String name, String department, String semester, String year) {
        Id = id;
        this.name = name;
        this.department = department;
        this.semester = semester;
        this.year = year;
    }
    public String Getname(){
        return name;
    }
    public String GetId(){
        return Id;
    }
    public String GetDepartment(){
        return department;
    }
    public String GetSemester(){
        return semester;
    }
    public String getYear(){
        return year;
    }

}
