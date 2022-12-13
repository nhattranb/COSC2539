/*
  RMIT University Vietnam - SSET
  Course: COSC2081 Programming 1
  Semester: 2022s3
  Assignment 1: Lab Test
  Student's name: Tran Minh Nhat
  Student's ID: s3926629
  Date of work: 21/11/2022
  Acknowledgement 1: https://www.w3resource.com/java-exercises/re/java-re-exercise-30.php (with mods)
  Acknowledgement 2: https://stackoverflow.com/questions/33905351/multiple-conditions-with-replaceall
 */

package com.program.rmit;

import java.util.Scanner;

public class test1 {
    public static String validate(String str) {
        return str.replaceAll("(?<=[A-Z])(?=[a-z])", "&").replaceAll("(?=[A-Z])(?<=[a-z])", "&"); // string adding is here
    }
    public static void main(String[] args) {
        Scanner q4 = new Scanner(System.in);
        System.out.println("Please enter your string: "); // your input here
        String str = q4.nextLine();
        System.out.println("Here is your NEW string: " + validate(str)); // final results
    }
}
