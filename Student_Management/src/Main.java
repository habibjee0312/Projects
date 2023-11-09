import java.util.*;
public class Main {

    public static void clearScreen(){
        for(int i=0;i<50;i++){
            System.out.println();
        }
    }
    public static void Adddata(Admin adim){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your name: ");
            String name = scan.nextLine();
            System.out.println("Enter your Id: ");
            String Id = scan.nextLine();
            System.out.println("Enter your Department: ");
            String department = scan.nextLine();
            System.out.println("Ente your semester: ");
            String semester = scan.nextLine();
            System.out.println("Enter year of Study: ");
            String year = scan.nextLine();
            adim.SetData(name, Id, department, semester, year);

            Scanner ss=new Scanner(System.in);


    }
    public static void Delete(Admin a){
        Scanner ss=new Scanner(System.in);
        System.out.println("Enter roll Number to delete the data of Student: ");
        String roll=ss.nextLine();
        a.Delete_data(roll);
    }

    public static void SeeData_of_specific_stu(Admin admin){
        Scanner check=new Scanner(System.in);
        System.out.println("Enter rollNo of Student which you want to See: ");
        String roll=check.nextLine();
        admin.seeSpecific_student(roll);
    }





    public static void main(String[] args) {
        Admin admin=new Admin("admin","password");
        while (true) {
            System.out.println("1) Enter data of Student ");
            System.out.println("2) Delete data of Student ");
            System.out.println("3) Delete data of All of Student ");
            System.out.println("4) see All Students Student ");
            System.out.println("5) see Student data with rollNumber ");
            System.out.println("6) Exit! ");
            Scanner cc=new Scanner(System.in);
            int choice=cc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        Adddata(admin);
                        break;
                    case 2:
                        clearScreen();
                        Delete(admin);
                        break;
                    case 3:
                        clearScreen();
                        admin.removeAll();
                        break;
                    case 4:
                        clearScreen();
                        admin.seeData();
                        break;
                    case 5: {
                        SeeData_of_specific_stu(admin);
                        break;
                    }

                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice: ");
                }
            }catch (Exception e){
                e.printStackTrace();
            }


        }
    }
}