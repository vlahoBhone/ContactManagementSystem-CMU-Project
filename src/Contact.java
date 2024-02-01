public class Contact {
    private String name;
    private String phNum;

    private String email;

    private String address;

    public Contact(){

    }
    public  Contact(String name,String phNum,String email,String address){
        this.name=name;
        this.phNum=phNum;
        this.email=email;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return name+"\n"+phNum+"\n"+email+"\n"+address;
    }
}
