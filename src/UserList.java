import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserList extends ArrayList<User> {
    public  UserList(File file) throws FileNotFoundException {
        Scanner scanner=new Scanner(file);
        while (scanner.hasNextLine()){

            StringTokenizer s=new StringTokenizer(scanner.nextLine(),",");
            if(s.hasMoreTokens()){
            User user=new User(s.nextToken(),s.nextToken());
            this.add(user);}

            else {
                System.out.println("Register.");
            }
        }


    }
    public boolean authenticateUser(String username,String password){
        boolean found=true;
        for(User u:this){
            if(u.getUsername().contains(username)){
                if(u.getPassword().contains(password)){
                    return true;
                }
            }
            else {
                found=false;
            }
        }
        return found;

    }
}
