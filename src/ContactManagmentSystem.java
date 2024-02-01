import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class ContactManagmentSystem {
    static ContactList list=new ContactList();
    static String username;

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        File userFile=new File("user.csv");
        UserList userlist=new UserList(userFile);


      loop:  while (true) {
            System.out.println("Enter 1 to LogIn/ 2 to Registration.");
            Scanner in=new Scanner(System.in);
            int input=in.nextInt();

            switch (input){
                case 1:
                       login(userlist);
                       break loop;

                case 2:
                    registerUser(userlist);
                    saveUser(userFile,userlist);

                    break ;

            }
        }

        String filename= username+".csv";
        String filepath="C:\\Users\\iileg\\IdeaProjects\\Contact Management System\\UserList\\"+filename;
        File f=new File(filepath);
        readContactList(f);
        Scanner scan=new Scanner(System.in);
        System.out.println("Welcome"+" "+username);
        while (true){
            System.out.println("\t"+"-----------------Main Menu-------------------------");
            System.out.println("Enter 1 to Add Contact/ 2 to view Contact List/3 to update Contact/ 4 to remove contact/ 0 to exit.");
            int choice= scan.nextInt();
            switch (choice){
                case 1:
                    addContact();
                    System.out.println("Returned to main menu...");
                    break;

                case 2:
                    showContactList();
                    System.out.println("Returned to main menu...");

                    break;

                case 3:
                    list.showContactList();
                    Scanner input=new Scanner(System.in);
                    System.out.println("Enter the number of contact you want to update");
                    int num=input.nextInt();
                    list.updateContactList(num);

                    System.out.println("Returned to main menu...");
                    break;

                case 4:
                    list.showContactList();
                    Scanner input1=new Scanner(System.in);
                    System.out.println("Enter the number of contact you want to delete:");
                    int n=input1.nextInt();
                    list.removeContact(n);
                    System.out.println("Returned to main menu...");
                    break;

                case 0:
                    save(f);
                    System.out.println("Exiting the system.");
                    TimeUnit.SECONDS.sleep(2);
                    System.exit(0);

                default:
                    System.out.println("Invalid Input");
                    System.out.println("Returned to main menu...");
                    break;
            }

        }

    }

    public static void addContact(){
        Contact contact=new Contact();
        Scanner scan=new Scanner(System.in);
        System.out.println("---------Adding Contact----------");
        System.out.println("Enter name:");
        contact.setName(scan.nextLine());
        System.out.println("Enter Ph number:");
        contact.setPhNum(scan.nextLine());
        System.out.println("Enter email:");
        contact.setEmail(scan.nextLine());
        System.out.println("Enter address:");
        contact.setAddress(scan.nextLine());

        list.addContact(contact);
    }

    public static void showContactList(){
        list.showContactList();
        System.out.println("Enter 1 to view contact detail/ 0 to exit.");
        Scanner scan=new Scanner(System.in);
        int i=scan.nextInt();


        switch (i) {
            case 1:
                while (true){

                System.out.println("Enter the number of the contact./ 0 to exit.");
                int index = scan.nextInt();
                if(index==0){
                    break;
                }
                list.showContactDetail(index);
                }
                break;

            case 0:
                return;

            default:
                System.out.println("Invalid input.");
        }

    }

    public static void save(File f) throws FileNotFoundException {
        PrintWriter out=new PrintWriter(f);
        for( Contact c:list){
            out.println(c.getName()+","+c.getPhNum()+","+c.getEmail()+","+c.getAddress());
        }
        out.close();
    }

    public static void readContactList(File f) throws FileNotFoundException {
        Scanner scanner=new Scanner(f);
        while (scanner.hasNextLine()){
            StringTokenizer s=new StringTokenizer(scanner.nextLine(),",");
            if(s.hasMoreTokens()){
            Contact c= new Contact(s.nextToken(),s.nextToken(),s.nextToken(),s.nextToken());
            list.addContact(c);}


        }

    }

    public static void registerUser(UserList userlist) throws FileNotFoundException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("----------Registration----------");
        System.out.println("Enter username:");
        String name=scanner.nextLine();
        System.out.println("Enter password");
        String pw=scanner.nextLine();

        User u=new User(name,pw);
        userlist.add(u);
        String filename=name+".csv";
        String file="C:\\Users\\iileg\\IdeaProjects\\Contact Management System\\UserList\\"+filename;
        File f=new File(file);
        PrintWriter out=new PrintWriter(f);
        out.println(name+","+pw);


    }

    public static void saveUser(File f,UserList userlist) throws FileNotFoundException {
        PrintWriter out=new PrintWriter(f);
        for( User u:userlist){
            out.println(u.getUsername()+","+u.getPassword());
        }
        out.close();


    }

    public static void login(UserList userlist){
        System.out.println("---------Log In----------");
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter username:");
            String name = scan.nextLine();
            System.out.println("Enter password:");
            String password = scan.nextLine();

            if (userlist.authenticateUser(name, password)) {
                username = name;
                break;
            }
            else {
                System.out.println("Incorrect.");
            }

        }
    }
}
