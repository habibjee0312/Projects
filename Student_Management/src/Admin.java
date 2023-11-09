import java.io.*;
import java.util.*;

public class Admin implements Serializable{
    private String password;
    private String userName;
    private List<Student> students;

    Admin(String userName, String password) {
        this.password = password;
        this.userName = userName;
        this.students = new ArrayList<>();
        initialize();
    }

    public boolean Verify(String password, String userName) {
        return this.userName.equals(userName) && this.password.equals(password);
    }

    public void SetData(String name, String Id, String department, String semester, String year) {
        Student student = new Student(Id, name, department, semester, year);
        if(!students.isEmpty()) {

            for (Student s : students) {
                if (s.GetId().equals(Id)) {
                    System.out.println("Roll N0 Exist!!");
                    return;
                }
            }
        }
                students.add(student);
                saveStudentData();

    }

    private void saveStudentData() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("file.ser"));
            for (Student s : students) {
                output.writeObject(s);
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void seeData() {
            if (!students.isEmpty()) {
                System.out.println("Name               |  RollNo:  |  Department    | Semester | Year   |");
                for (Student student : students) {

                    System.out.println(student.Getname() + "         | " + student.GetId() + "   | " + student.GetDepartment() + "            | " + student.GetSemester() + "      | " + student.getYear() + "    |");


                }
            }
    }



    public void Delete_data(String rollNo) {

            for (Student student : students) {
                if(rollNo.equals(student.GetId())){
                    students.remove(student);
                    saveStudentData();
                    return;
                }
            }
        System.out.println("Student not Found!!");
    }

    public void removeAll() {

            File file = new File("file.ser");
            students.clear();
            if(file.delete()){
                System.out.println("Record has been cleared!!");
            }

    }

    public void seeSpecific_student(String roll) {

            for (Student student : students) {

                if (roll.equals(student.GetId())) {

                    System.out.println("Name:       " + student.Getname());
                    System.out.println("ID:         " + student.GetId());
                    System.out.println("Department: " + student.GetDepartment());
                    System.out.println("Semester:   " + student.GetSemester());
                    System.out.println("Year:       " + student.getYear());
                    return;
                }
            }
        System.out.println("Student Not Found!!");
    }

    public void initialize() {
        File file = new File("file.ser");
        if (file.exists()) {
            if (file.length() != 0) {

                try {
                    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
                    boolean EOF =false;
                    while (!EOF){
                        try {
                            Student s = (Student) inputStream.readObject();
                            students.add(s);
                        }catch (EOFException e){
                            inputStream.close();
                            EOF=true;
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
