import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String email;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    private int defaultPasswordLength = 10;
    private int mailboxCapacity;

    //Constructor to receive the firstname and lastname
    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("Email created " + this.firstname + " " + this.lastname);

        //Call a method for the a department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //Call a method thet the returnes a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password: " + this.password);

        //Combine elements to generate email
        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + email);
    }

    //Ask for the departname
    private String setDepartment() {
        System.out.println("New worker " + firstname + ". Department Codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){
            return "sales";
        }else if(depChoice == 2){
            return "dev";
        }else if(depChoice == 3){
            return "acct";
        }else return "";
    }

    //Ganerate a random password
    private String randomPassword(int length){
        String passwordSet = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789!@#$%";
        char[] password = new char[length];

        for (int i = 0; i <length; i++ ){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public  void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return ("\nDisplay name: " +firstname + " "  + lastname + "\nCampany email: " + email + "\nMailbox capacity: " +  mailboxCapacity + "mb");
    }
}
