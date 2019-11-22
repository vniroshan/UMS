import java.util.Scanner;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String name;
        int age;
        String subject;
        int option;
        int course;
        int id;
        String module;
        String userName;
        String password;
        int sop;

        Connection connection=DBConnection.getInstance().getConnection();
        Scanner input=new Scanner(System.in);

        System.out.println("Welcome to University Management System");
        System.out.println("");
        System.out.println("Please select an option to proceed");
        System.out.println("Press [1] Register as a Student");
        System.out.println("Press [2] Register as a Lecturer");

        option=input.nextInt();
        Subject sub=new Subject();

        switch (option){
            case 1:
                System.out.println("Select [1] for Sign up, [2} for sign in");
                sop=input.nextInt();
                switch (sop) {
                    case 1:
                    System.out.println("Student Registration");
                    System.out.println("");
                    System.out.println("Please Submit following information");
                    System.out.println("Student ID:");
                    id = input.nextInt();
                    System.out.println("1:  Name:");
                    input.nextLine();
                    name = input.nextLine();
                    System.out.println("2:  Age:");
                    age = input.nextInt();
                    System.out.println("User name:");
                    userName = input.next();
                    System.out.println("Password:");
                    password = input.next();
                    System.out.println("3: Select course number from following list,");
                    System.out.println("[1]" + modules.SENG1111_Introduction_to_Programming);
                    System.out.println("[2]" + modules.SENG1112_Fndamantales_of_Engineering);
                    System.out.println("[3]" + modules.SENG1113_Data_Structures_and_Algorithms);
                    course = input.nextInt();
                    Student student = new Student();

                    switch (course) {
                        case 1:
                            sub.setSubName(modules.SENG1111_Introduction_to_Programming);
                            student.setCource(String.valueOf(modules.SENG1111_Introduction_to_Programming));
                            break;
                        case 2:
                            sub.setSubName(modules.SENG1112_Fndamantales_of_Engineering);
                            student.setCource(String.valueOf(modules.SENG1112_Fndamantales_of_Engineering));
                            break;
                        case 3:
                            sub.setSubName(modules.SENG1113_Data_Structures_and_Algorithms);
                            student.setCource(String.valueOf(modules.SENG1113_Data_Structures_and_Algorithms));
                            break;
                        default:
                    }
                    student.setStdAge(age);
                    student.setStdName(name);
                    student.setId(id);
                    student.setPassowrd(password);
                    student.setUserName(userName);
                    PreparedStatement stm = connection.prepareStatement("Insert Into Student Values(?,?,?,?,?,?);");

                    stm.setObject(1, student.getId());
                    stm.setObject(2, student.getStdName());
                    stm.setObject(3, student.getStdAge());
                    stm.setObject(4, student.getUserName());
                    stm.setObject(5, student.getPassowrd());
                    stm.setObject(6, student.getCource());

                    stm.executeUpdate();
                    System.out.println("Student Registration Completed");
                    System.out.println("Name    :" + student.getStdName());
                    System.out.println("Age     :" + student.getStdAge());
                    System.out.println("Subject :" + sub.getSubName());
                    break;
                    case 2:
                        System.out.println("Student Login form");

                        System.out.println("User Name:");
                        userName=input.next();
                        System.out.println("Password:");
                        password=input.next();

                        Statement  stmt=connection.createStatement();
                        ResultSet   rs=stmt.executeQuery( "select * from Student where userName='"+userName+"'and password='"+password+"';");
                        while (rs.next()) {
                            System.out.println( "Hi " + rs.getString(2));
                            System.out.println("You have successfully registered for this course:");
                            System.out.println(" "+rs.getString(6));
                        }
                        break;
                        default:
                }
                break;


            case 2:
                System.out.println("Select [1] for Sign up, [2} for sign in");
                sop=input.nextInt();
                switch (sop) {

                    case 1:
                    System.out.println("Lecturer Registration");
                    System.out.println("");
                    System.out.println("Please Submit following information");
                        System.out.println("Lecturer ID:");
                        id = input.nextInt();
                        System.out.println("1:  Name:");
                        input.nextLine();
                        name = input.nextLine();
                        System.out.println("2:  Age:");
                        age = input.nextInt();
                        System.out.println("User name:");
                        userName = input.next();
                        System.out.println("Password:");
                        password = input.next();
                    System.out.println("3: Select course number from following list,");
                    System.out.println("[1]" + modules.SENG1111_Introduction_to_Programming);
                    System.out.println("[2]" + modules.SENG1112_Fndamantales_of_Engineering);
                    System.out.println("[3]" + modules.SENG1113_Data_Structures_and_Algorithms);
                    course = input.nextInt();
                    Lecturer lecturer = new Lecturer();
                    switch (course) {
                        case 1:
                            sub.setSubName(modules.SENG1111_Introduction_to_Programming);
                            lecturer.setCourse(String.valueOf(modules.SENG1111_Introduction_to_Programming));
                            break;
                        case 2:
                            sub.setSubName(modules.SENG1112_Fndamantales_of_Engineering);
                            lecturer.setCourse(String.valueOf(modules.SENG1112_Fndamantales_of_Engineering));
                            break;
                        case 3:
                            sub.setSubName(modules.SENG1113_Data_Structures_and_Algorithms);
                            lecturer.setCourse(String.valueOf(modules.SENG1113_Data_Structures_and_Algorithms));
                            break;
                        default:
                    }
                    lecturer.setName(name);
                    lecturer.setAge(age);
                    lecturer.setId(id);
                    lecturer.setUserName(userName);
                    lecturer.setPassword(password);
                        PreparedStatement stm = connection.prepareStatement("Insert Into Lecturer Values(?,?,?,?,?,?);");
                        stm.setObject(1, lecturer.getId());
                        stm.setObject(2, lecturer.getName());
                        stm.setObject(3, lecturer.getAge());
                        stm.setObject(4, lecturer.getUserName());
                        stm.setObject(5, lecturer.getPassword());
                        stm.setObject(6, lecturer.getCourse());
                        stm.executeUpdate();
                    System.out.println("Lecturer Registration Completed");
                    System.out.println("Name    :" + lecturer.getName());
                    System.out.println("Age     :" + lecturer.getAge());
                    System.out.println("Subject :" + sub.getSubName());
                    break;
                    case 2:
                        System.out.println("Lecturer Login form");

                        System.out.println("User Name:");
                        userName=input.next();
                        System.out.println("Password:");
                        password=input.next();

                        Statement  stmt=connection.createStatement();
                        ResultSet   rs=stmt.executeQuery( "select * from Lecturer where userName='"+userName+"'and password='"+password+"';");
                        while (rs.next()) {
                            System.out.println( "Hi " + rs.getString(2));
                            System.out.println("You have successfully registered for this course:");
                            System.out.println(" "+rs.getString(6));
                        }
                        break;
                    default:
                }
                break;

        }




    }
}