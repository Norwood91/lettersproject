/*
Name: Robert Norwood
Description: This program takes user input, stores that user input into an array
and prints the contents of the array.
date:02/07/2025
Self-grade with explanations: I give myself an A, as the program does what is expected.
Testimony: I have written the code by myself without any help from the unauthorized resources. Robert. 

Implement the methods in the given order. 
Must remove all the given comments and include your own commnets. 10 points
*/

import java.util.*;

public class LettersNorwood 
{
    public static void main(String[] args)
    {
        go();
    }

    public static void go()
    {
        // Calls the desc method to display the program description
        desc();
        
        // Declares an array of characters with size 5
        char[] letters = new char[5];
        
        // Call the populate method and pass the array to fill it with letters
        populate(letters);
        
        // Call the print method and pass the array to display the letters
        print(letters);
    }

    /*
    This method transverses the array of letters to find the letter entered by the user
    Returns true if letter is found and false if not.
    */
    public static boolean found(char[] letters, char input)
    {
        // Loop through each element in the array
        for (int i = 0; i < letters.length; i++)
        {
            // If the letter matches the current element in the array, return true
            if (letters[i] == input)
            {
                return true;
            }
        }
        return false; 
    }

    /*
    This method validates the user's input to check it's a single letter and
    Continues to prompt the user until a valid letter is entered.
    */
    public static char validateInput(Scanner kb)
    {
        String input = "";
        char firstLetter = ' ';  
        boolean done = false;  
        
        while (!done)  // Keep prompting until the user enters a valid letter
        {
            // Prompt the user to enter a letter
            System.out.print("Enter a letter a-z or A-Z: ");
            
            // Read the input from the user
            input = kb.next();
            
            // Ensure the input is a single character
            while (input.length() != 1)
            {
                // Prompt user again
                System.out.println("You must enter a single letter");
                System.out.print("Enter a letter a-z or A-Z: ");
                input = kb.next();
            }
            // Make case insensitive
            input = input.toUpperCase(); 
            // Get the first character of the input
            firstLetter = input.charAt(0);  
            
            // Check if the first letter is a valid character
            if (firstLetter >= 'A' && firstLetter <= 'Z')
            {
                done = true; 
            }
            else
            {
                // Let user know input was incorrect
                System.out.println("You did not enter a valid letter");
            }
        }
        
        return firstLetter;
    }

    /*
    This method populates the array with unique letters from user input.
    It uses the validateInput method to check the letter is valid and 
    not currently in the array.
    */
    public static void populate(char[] letters)
    {
        // Create a Scanner object for user input
        Scanner kb = new Scanner(System.in);
        
        // Loop to fill the array with letters
        for (int i = 0; i < letters.length; i++)
        {
            char letter;
            // Call validateInput to get a valid letter from the user
            letter = validateInput(kb);
            
            // Check if the letter is already in the array
            boolean f = found(letters, letter);
            
            // If the letter is not in the array
            if (!f)
            {
                // Add the letter to the array
                letters[i] = letter;  
                System.out.println("The letter " + letter + " was added to the array");
                System.out.println("You have " + (i + 1) + " letters in the array");
            }
            else
            {
                // If the letter is already in the array, prompt the user again
                System.out.println("You already entered this letter. Try again.");
                // Decrement i
                i--;  
            }
        }
    }

    /*
    This method displays the array's contents in a formatted way, like so:
    {A, D, G, H, I}.
    */
    public static void print(char[] letters)
    {
        System.out.print("\nHere is the list of the distinct letters you entered: {");
        
        // Loop through the array to print each letter
        for (int i = 0; i < letters.length; i++)
        {
            // Prints each letter with commas, except for the last line
            if (i < letters.length - 1)
            {
                System.out.print(letters[i] + ", ");
            }
            else
            {
                System.out.print(letters[i]);
            }
        }
        System.out.println("}");  // Close the bracket after printing all letters
    }

    /*
    This method displays the description of the program and uses a loop to print a line of stars.
    */
    public static void desc()
    {
        // Top line of stars 
        for (int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }
        System.out.println();
        
        // Prints the description
        System.out.print("This program allows you to input and store unique");
        System.out.println(" letters inside an array ");
        System.out.println("and print them in a formatted way");
        
        // Bottom line of stars
        for (int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}
