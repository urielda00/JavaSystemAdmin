import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 8;
    private String email;
    private String companySuffix = "company.com";

    // constructor to receive the first & last name
     public  Email(String firstName, String lastName){
         this.firstName = firstName;
         this.lastName = lastName;
         System.out.println("Email created: " + this.firstName + " " + this.lastName);

         // called a method asking for the department - return the department
         this.department = setDepartment();
         System.out.println("Department is: " + this.department);

         // call a method that returns a random password
         this.password = randomPassword(defaultPasswordLength);
         System.out.println("Your password is: " + this.password);

         // combine elements to generate email
         if(this.department.isEmpty()){
             email = "Email not set, please enter a valid department first";
         }else{
             email = firstName.toLowerCase() + "." + lastName.toLowerCase()  + "@" + department + "." + companySuffix;
         }
         System.out.println("Your email is: " + email);
     }
    // ask for department
       private String setDepartment(){
           System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
           Scanner in = new Scanner(System.in);
           int depChioce = in.nextInt();
           return switch (depChioce) {
               case 1 -> "sales";
               case 2 -> "dev";
               case 3 -> "acc";
               default -> "";
           };

       }
    // create a random pass
       private String randomPassword(int length){
         if(this.department.isEmpty()){
             return "Not set. Please reach for department first";
         }
         String passwordSet = "ABCDEFGHIJKLMNOPQRSTWUXYZ123456789!@#$%";
         char[] password = new char[length];
         for (int i = 0; i< length; i ++){
             int rand = (int) (Math.random() * passwordSet.length());
             password[i] = passwordSet.charAt(rand);
         }
         return new String(password);
       }
    // set the mailbox capacity
      public void setMailCapacity(int capacity){
         this.mailboxCapacity = capacity;
      }
    // set the alternate email
    public void setAlternateEmail(String altEmail){
         this.alternateEmail = altEmail;
    }

    // change the password
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
         return "Name: " + firstName + " " + lastName  +
                "\nCompany Email: " + email + " " +
                 "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}
