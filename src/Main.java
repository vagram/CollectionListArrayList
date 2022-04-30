import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String regEx = "(ADD)?(LIST)?(EDIT)?(DELETE)?";
    public static String regExNumbofList = "\\d+";
    //public static String regExADD = "[А-Я]?[а-я]+\\s*\\d+[\\.,]?\\d+?\\s*[А-Я]?[а-я]+\\s*?[А-Я]?[а-я]+\\W+?";
    public static String regExADD = "ADD";
    public static String regExEDIT = "EDIT";
    public static String regExLIST = "LIST";
    public static String regExDELETE = "DELETE";
    public static String command;
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static String addMessage;
    public static Integer numbOfList;


    public static void main(String[] args) {
        while (true) {
            commandImplement();
        }
    }

    public static void enterValidCommand() {
        command = new Scanner(System.in).nextLine();
        command = command.replaceAll("\\p{Space}", "");
        command = command.replaceAll("\\p{Punct}", "");
        if (command.matches(regEx)) {
        } else System.out.println("\u001B[31mWrong command\u001B[0m");
    }

    public static void commandImplement() {

        enterValidCommand();
        if (command.matches(regExADD)) {
            System.out.println("Enter ADD message:" + "\n");
            addMessage = new Scanner(System.in).nextLine();
            arrayList.add(addMessage);
            System.out.println("List to do: ");
            arrayList.forEach(System.out::println);
        } else if (command.matches(regExEDIT)) {
            System.out.println("Enter EDIT message:");
            addMessage = new Scanner(System.in).nextLine();
            System.out.println("Enter number of list to EDIT: ");
            numbOfList = Integer.parseInt(new Scanner(System.in).next());
            if (String.valueOf(numbOfList).matches(regExNumbofList)) {
                if (numbOfList <= arrayList.size()) {
                    if (arrayList.indexOf(numbOfList) == arrayList.indexOf(numbOfList)) {
                        arrayList.add(0, "");
                        arrayList.set(numbOfList, addMessage);
                        arrayList.forEach(System.out::println);
                    } else System.out.println("Wrong numb of list!");
                } else System.out.println("Wrong number of list!");
            } else System.out.println("Test");
        } else if (command.matches(regExLIST)) {
            System.out.println("List to do: ");
            arrayList.forEach(System.out::println);
        } else if (command.matches(regExDELETE)) {
            System.out.println("Enter number of list to \u001B[31m DELETE \u001B[0m :");
            numbOfList = Integer.parseInt(new Scanner(System.in).nextLine());
            if (String.valueOf(numbOfList).matches(regExNumbofList)) {
                if (numbOfList <= arrayList.size()) {
                    if (arrayList.indexOf(numbOfList) == arrayList.indexOf(numbOfList) && arrayList.size() != 0) {
                        arrayList.remove(arrayList.get(numbOfList));
                        System.out.println("The list number of " + "\u001B[31m" + numbOfList + "\u001B[0m" + " has been " + "\u001B[31mDELETED\u001B[0m!");
                        arrayList.forEach(System.out::println);
                    } else if (arrayList.size() == 0) {
                        arrayList.add(0, "");
                        arrayList.remove(arrayList.get(numbOfList));
                        System.out.println("The list number of " + "\u001B[31m" + numbOfList + "\u001B[0m" + " has been " + "\u001B[31mDELETED\u001B[0m!");
                    }

                } else System.out.println("Wrong number of list!");
            }

        }

    }
}

