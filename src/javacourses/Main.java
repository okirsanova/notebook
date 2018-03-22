package javacourses;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Person> records = new ArrayList<>();

    public static void main(String[] args) {
        commandLoop();
    }

    private static void commandLoop() {
        for (; ; ) {
            String cmd = askString("cmd> ");

            switch (cmd.toLowerCase()) {
                case "exit":
                    return;
                case "create":
                    create();
                    break;
                case "list":
                    list();
                case "help":
                    help();
                    break;
                default:
                    System.out.println("Type HELP if need help, or CREATE to create new record.");
            }
        }
    }

    private static void list() {
        for (Person p : records) {
            System.out.println(p);
        }
    }

    private static void help() {
        for (; ; ) {
            String type = askString("Need help? Type YES if needed or NO to exit: ");

            switch (type.toLowerCase()) {
                case "exit":
                    return;
                case "yes":
                    System.out.println("You can create list of persons. Use keywords: LIST to review or CREATE to add new person. Type EXIT to close program" +
                            ".");
                    return;
                case "no":
                    return;
                default:
                    System.out.println("Unknown type");
            }
        }
    }

    private static void create() {
        for (; ; ) {
            String type = askString("type: ");

            switch (type.toLowerCase()) {
                case "exit":
                    return;
                case "person":
                    createPerson();
                    return;
                default:
                    System.out.println("Need help?");
                case "YES":
                    System.out.println("Type CREATE than PERSON to create new record, and follow instructions.");
                    return;
                case "NO":
                return;

            }
        }
    }

    private static void createPerson() {
        String firstName = askString("First Name: ");
        String lastName = askString("Last Name: ");
        String phone = askString("Phone: ");
        String email = askString("Email: ");


        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhone(phone);
        person.setEmail(email);
        records.add(person);
    }

    private static String askString(String message) {
        System.out.print(message);
        return scanner.next();
    }
}
