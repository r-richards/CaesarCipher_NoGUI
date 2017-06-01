import java.util.Objects;
import java.util.Scanner;
class MainApplication {
    private static final Scanner input = new Scanner(System.in);
    private static final int setting = 18;
    private static String CryptMessage(int key, String message) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (Character.isLetter(message.charAt(i))) {
                int num = (int) message.charAt(i);
                num = num + key;
                if (Character.isUpperCase(message.charAt(i))) {
                    if (num > (int) ('Z')) {
                        num = num - 26;
                    } else if (num < (int) ('A')) {
                        num = num + 26;
                    }
                }
                if (Character.isLowerCase(message.charAt(i))) {
                    if (num > (int) ('z')) {
                        num = num - 26;
                    } else if (num < (int) ('a')) {
                        num = num + 26;
                    }
                }
                temp.append((char) num);
            } else {
                temp.append(message.charAt(i));
            }
        }
        message = temp.toString();
        return message;
    }
    private static void encrypt(){
        int key = setting;
        System.out.println("Please enter a message to encrypt: ");
        String message = input.nextLine();
        System.out.println(CryptMessage(key, message));
    }
    private static void decrypt(){
        int key = -setting;
        System.out.println("Please enter a message to decrypt: ");
        String message = input.nextLine();
        System.out.println(CryptMessage(key, message));
    }
    public static void main(String[] args){
        System.out.println("Message Encryption System 3.0");
        System.out.println("Please select an option:");
        System.out.println("[1] - Encrypt Message");
        System.out.println("[2] - Decrypt Message");
        System.out.println("[3] - View Current Key");
        System.out.println("[4] - Exit");
        String opt = input.nextLine();
        if(Objects.equals(opt, "1")){
            encrypt();
        }
        else if(Objects.equals(opt, "2")){
            decrypt();
        }
        else if(Objects.equals(opt, "3")){
            System.out.println("The current key setting is: "+setting);
        }
        else if(Objects.equals(opt, "5")){
            System.exit(0);
        }
        else{
            System.out.println("Invalid input.");
            MainApplication.main(new String[]{});
        }
    }
}
