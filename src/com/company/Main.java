package com.company;

import java.util.Scanner;

public class Main {
    boolean wroteFullName = false;
    public static void main(String[] args) {
        Main main = new Main();
        while (!main.wroteFullName)
        {
            System.out.print("Please write your full name: ");
            Scanner sc = new Scanner(System.in);
            String fullName = sc.nextLine();
            main.writeNameParts(fullName);
        }
    }
    public String capitalizeString(String capitalizeWord)
    {
        capitalizeWord = capitalizeWord.substring(0, 1).toUpperCase() + capitalizeWord.substring(1).toLowerCase();
        return capitalizeWord;
    }
    public void writeNameParts(String myName)
    {
        String firstName;
        String middleName;
        String lastName;

        int firstWordStartIndex = 0;
        int firstWordEndIndex = myName.indexOf(" ");
        int secondWordStartIndex = myName.indexOf(" ")+1;
        int secondWordEndIndex = myName.lastIndexOf(" ");
        int thirdWordStartIndex = myName.lastIndexOf(" ")+1;

        if (secondWordStartIndex != thirdWordStartIndex)
        {
            if (secondWordStartIndex != -1)
            {
                middleName = myName.substring(secondWordStartIndex, secondWordEndIndex);
                middleName = capitalizeString(middleName);
            }
            else
            {
                System.out.println("Could not find any spaces.");
                middleName = "";
            }
            if (thirdWordStartIndex != -1)
            {
                lastName = myName.substring(thirdWordStartIndex);
                lastName = capitalizeString(lastName);
            }
            else
            {
                lastName = "";
                System.out.println("Could not find any spaces.");
            }
        }
        else
        {
            if (secondWordStartIndex != -1)
            {
                middleName = "";
                lastName = myName.substring(secondWordStartIndex);
                lastName = capitalizeString(lastName);
            }
            else
            {
                System.out.println("Could not find any spaces.");
                middleName = "";
                lastName = "";
            }
        }
        if ((secondWordStartIndex != -1) && (thirdWordStartIndex != -1))
        {
            if (secondWordStartIndex != thirdWordStartIndex)
            {
                firstName = myName.substring(firstWordStartIndex, firstWordEndIndex);
                firstName = capitalizeString(firstName);

                System.out.println("The first name: " + firstName);
                System.out.println("The middle name(s): " + middleName);
                System.out.println("The last name: " + lastName);
                writeFullName(firstName, middleName, lastName);
                wroteFullName = true;
            }
            else
            {
                if (firstWordEndIndex != -1)
                {
                    firstName = myName.substring(firstWordStartIndex, firstWordEndIndex);
                    firstName = capitalizeString(firstName);

                    System.out.println("The first name: " + firstName);
                    System.out.println("The last name: " + lastName);
                    writeFullName(firstName, null, lastName);
                    wroteFullName = true;
                }
                else
                {
                    System.out.println("Does not compute, enter full name please.");
                }
            }

        }
        else
        {
            System.out.println("Does not compute, enter full name please.");
        }
    }
    public void writeFullName(String firstName, String middleName, String lastName)
    {
        if (middleName != null)
        {
            firstName = capitalizeString(firstName);
            middleName = capitalizeString(middleName);
            lastName = capitalizeString(lastName);
            System.out.println("Full name: " + firstName + " " + middleName + " " + lastName);
        }
        else
        {
            firstName = capitalizeString(firstName);
            lastName = capitalizeString(lastName);
            System.out.println("Full name: " + firstName + " " + lastName);
        }
    }
}
