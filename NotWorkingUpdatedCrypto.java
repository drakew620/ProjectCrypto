/*
This will be a program that can encrypt and decrypt user text. It will use multiple methods to accomplish this task.
*/
import java.util.*;

public class NotWorkingUpdatedCrypto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner shift = new Scanner(System.in);
        Scanner group = new Scanner(System.in);

        System.out.println("What text would you like encrypted?");
        String toBeEncrypted = input.nextLine();
        System.out.println("What would you like the shift value to be? (Integer only.)");
        int sh = Integer.parseInt(shift.next());
        System.out.println("What would you like the group size to be? (Integer only.)");
        int gr = Integer.parseInt(group.next());

    String encryptedText = encryptString(toBeEncrypted, sh, gr);
    System.out.println(encryptedText);

    }
    public static String normalizeText(String s) {
        // A method that will force all text to become capitalized and remove all spaces and punctuation from it.

        String s2 = s.toUpperCase().replace(".","").replace(" ","").replace(",","").replace(":","").replace(";","").replace
            ("'","").replace("\"","").replace(")","").replace("(","").replace("!","").replace("?","");

        return s2;

    }
    public static String obify(String addOB) {
        //A method that inserts the letters 'OB' before every vowel, including 'Y', in a passed string.
        String oBified = "";
        int length = addOB.length(); //gives an integer that is equal to the amount of characters in string addOB.
        for (int i = 0; i < length; i++) {
            char ch = addOB.charAt(i); // makes a new char ch that is equal to the char at i in the string addOB.
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'Y') {
                oBified += "OB" + ch; //if the char at i in addOB is A, E, I, O, U or Y, it will updated string oBified to 
                                      //current oBified + "OB" + ch.
            } else {
                oBified += ch;
            }
            }
        return oBified;

    }
    public static String caesarify(String s, int shift) {
        //A method that will take a string as input for 's' and a shift amount as input for 'shift' and move the letters
        //that many places in the alphabet. Example: ""ABC", 1" would return "BCD".
        String shiftedWords = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char letters = s.charAt(i);
            char c = (char)(letters+shift);
            if (c > 'Z') {
                shiftedWords += (char)(letters - (26 - shift));
            } else if (c < 'A') {
                shiftedWords += (char)(letters + (26 + shift));
            } else {
                shiftedWords += (char)(letters + shift);
            }
        }
             return shiftedWords;

    }
    public static String groupify(String b, int nLetters) {
        //A method that will separate a passed String into groups of letters based on the passed integer. Example: "ABCDEF", 2 
        //would output "AB CD EF".
        //If the last group of letters doesn't have enough to make a full group, it will add 'x''s to the group to complete it. 
        //"ABCDEF", 4 = "ABCD EFxx".
        String groupedText = "";
        int length = b.length();
        for (int i = 0; i < length; i++) {
            char ch = b.charAt(i);
            if (i % nLetters == 0 && i > 0) {
                groupedText += " " + ch;
            } else {
                groupedText += ch;
            }
        }
        while (length % nLetters != 0) {
            groupedText +='x';
            length++;
        }
        return groupedText;

    }
    public static String encryptString(String encrypt, int shiftValue, int groupSize) {
        //This method will put everything together and call the methods needed in the proper order. It will output the encrypted
        //text.
        String cypherText = normalizeText(encrypt);
        String cypherText2 = obify(cypherText);
        String cypherText3 = caesarify(cypherText2, shiftValue);
        String cypherText4 = groupify(cypherText3, groupSize);
        return cypherText4;

    }

    }
