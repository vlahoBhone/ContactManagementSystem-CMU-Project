import java.util.ArrayList;
import java.util.Scanner;

public class ContactList extends ArrayList<Contact> {

    public  ContactList(){

    }

    //---------------------------------------Add-------------------------------------------------------
    public void addContact(Contact c){
        this.add(c);
    }


  //--------------------------------------Remove-----------------------------------------------------------------
    public void removeContact(int i){

        if(i<=0 || i>this.size()){
            System.out.println("Invalid Input.");
            return;
        }
        this.remove(i-1);
        System.out.println("Contact Removed!");
    }
//--------------------------------------------Clear All-----------------------------------------------------------
    public void clearContactList(){
        this.clear();
    }


    //-------------------------------------------Show List---------------------------------------------------------
    public void showContactList(){
        System.out.println("\t"+"--------Contact List----------");
        int i=1;
        for (Contact c : this){
            System.out.println("\t"+i+"."+c.getName());
            i++;
        }
        System.out.println("\t"+"-------------------------------");
    }


//-----------------------Update--------------------------------------------------------------------
    public void updateContactList(int i) {
        if (i > this.size() || i<=0) {
            System.out.println("This contact doesn't exist");
            return;
        }
        Contact contact = this.get(i-1);
        Scanner scan = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("Updating "+contact.getName());
            System.out.println("Enter 1/ to update Name,/ 2 to update phone/ 3 to update email,/ 4 to update address/ 0 to exit.");
            Scanner scan1=new Scanner(System.in);
            int num=scan1.nextInt();
            switch (num) {
                case 1:
                System.out.println("Enter name:");
                contact.setName(scan.nextLine());
                    System.out.println("Updated");
                break ;


                case 2:
                System.out.println("Enter Ph number:");
                contact.setPhNum(scan.nextLine());
                    System.out.println("Updated");
                break ;

                case 3:
                System.out.println("Enter email:");
                contact.setEmail(scan.nextLine());
                    System.out.println("Updated");
                break ;

                case 4:
                System.out.println("Enter address:");
                contact.setAddress(scan.nextLine());
                    System.out.println("Updated");
                break ;

                case 0:
                  break loop;

                default:
                    System.out.println("Invalid");
                    break ;
            }
        }
    }



//---------------------------------------Show Detail--------------------------------------------------
    public void showContactDetail(int i){
        if(i<=0 || i>this.size()){
            System.out.println("Invalid input.");
            return;
        }
        Contact contact= this.get(i-1);
        System.out.println("\t"+"----------Contact Detail-----------");
        System.out.println("\t"+"Name:"+contact.getName());
        System.out.println("\t"+"Phone:"+contact.getPhNum());
        System.out.println("\t"+"Email:"+contact.getEmail());
        System.out.println("\t"+"Address:"+contact.getAddress());
        System.out.println("\t"+"------------------------------------");

    }
}
