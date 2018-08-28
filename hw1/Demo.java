package code;
// Name: Alfonso Miguel Santos-Tankia
// Class: CS5405
// Student ID: 12432809
// HW 1

//Note: To compile: javac -d . <filepath>
//      To run:     java code.Demo

import java.util.Scanner;

public class Demo{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Please input your real name: ");
        String name = scan.nextLine();

        System.out.print("Please input your phone number: ");
        String phone = scan.nextLine();

        System.out.print("Please input your address: ");
        String address = scan.nextLine();

        System.out.printf("\nHello %s, your current address is %s and your phone number is %s\n", name, address, phone);
    }
}