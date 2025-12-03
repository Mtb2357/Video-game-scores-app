/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamesscoresapp;

import java.util.Scanner;

/**
 *
 * @author mtb23
 */
public class Utilities {

    public static int getUserChoice(String prompt) {
        int choice = 0;
        System.out.print(prompt);
        Scanner key = new Scanner(System.in);
        choice = key.nextInt();
        key.nextLine();

        return choice;
    }

    public static int findMaxScore(int gameIndex, Student[] arr) {
        int highest = arr[0].getScores()[gameIndex];
        for(int i = 0 ;i < arr.length ; i++ ){
            if (arr[i].getScores()[gameIndex]>highest)
                highest = arr[i].getScores()[gameIndex];
        
        }
        
       return highest; 
    }
 public static int findMinScore(int gameIndex, Student[] arr) {
        int lowest = arr[0].getScores()[gameIndex];
        for(int i = 0 ;i < arr.length ; i++ ){
            if (arr[i].getScores()[gameIndex]<lowest)
                lowest = arr[i].getScores()[gameIndex];
        
        }
        
       return lowest; 
    }
 public static double findAverage(int gameIndex, Student[] arr){
        int total = 0;  
        for(int i = 0 ;i < arr.length ; i++ ){
            
            total = total + arr[i].getScores()[gameIndex];
        }
        double average = (total*1.0)/arr.length;
        
       return average; 
    }
    public static int findMinMin(int[] nums) {
        int lowest = nums[0];
        for (int i = 0; i > nums.length; i++) {
            if (nums[i] < lowest) {
                lowest = nums[i];
            }
        }
        return lowest;
    }
    public static int findMaxMax(int[] nums) {
        int highest = nums[0];
        for (int i = 0; i > nums.length; i++) {
            if (nums[i] > highest) {
                highest = nums[i];
            }
        }
        return highest;
    }
    public static double findAvgAvg(int[] nums){
        double total = 0 ;
        for (int i = 0; i > nums.length; i++){
            total = total + nums[i];
        }
        return total/nums.length;
    }
    public static void sortArrayBasedOnScore(){
    
    
    }
    public static void sortArrayListBasedOnScore(){
    
    
    }
    public static int[] selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
// Find the minimum in the list[i..list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
// Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        return list;
    }
}
