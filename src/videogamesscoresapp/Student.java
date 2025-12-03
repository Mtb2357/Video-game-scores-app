/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamesscoresapp;

/**
 *
 * @author mtb23
 */
public class Student {
    private String id;
    private String name;
    private int[] scores = new int[10];
    
    //constructors
    public Student() {
        this.id = "";
        this.name = "";
        for (int i = 0; i < this.scores.length; i++) {
            this.scores[i] = 0;
        }
    }
    public Student(String id, String n, int[] scArr) {
        this.id = id;
        this.name = n;
        for (int i = 0; i < this.scores.length; i++) {
            this.scores[i] = scArr[i];
        }
    }
    //getters
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int[] getScores(){
        return this.scores;
    }
    
    //setters
    public void setId(String id){
        this.id = id;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setScores(int[] scArray){
        this.scores = scArray;
    }
    
    //methods
    public int getTotal(){
        int total = 0;
        for(int i = 0 ; i<this.scores.length ; i++ ){
            total = total + scores[i];
        }
        return total;
    }
    public double getAverage(){
        double avg = 0;
        int total = 0;
        for(int i = 0 ; i<this.scores.length ; i++ ){
            total = total + this.scores[i];
        }
        avg = (total*1.0)/this.scores.length;
        return avg;
    }
    public static String toDataLine(Student stu) {
        String str = "";
        String idd = stu.getId();
        String nme = stu.getName();
        String scc = "";
        int[] scArr = new int[10];
        for (int i = 0; i < stu.getScores().length; i++) {
            if (i == 9) {
                scc = scc + stu.getScores()[i];
            } else {
                scc = scc + stu.getScores()[i] + " , ";
            }
        }
        str = String.format("%s , %s , %s", idd, nme, scc);
        return str;
    }
    public static Student fromDataLine(String line){
        String[] parts = line.split(",");
        int[] scores = new int[10];  
        String str="";
            for(int i=2; i<parts.length ;i++){
                str = parts[i].trim();
                scores[i-2] = Integer.parseInt(str);
            }
            
        
        Student myStu = new Student(parts[0].trim(), parts[1].trim(),scores );
        return myStu;
    }
    public boolean equals(Student stu){
        boolean check = false;
        if(this.getId().equals(stu.getId())&& 
           this.getName().equals(stu.getName())&&
           this.getScores() == stu.getScores());
        
        return check;
    }
    public String scoresToString(){
        String str = "";
        String scc = "";
        int[] scArr = new int[10];
        for (int i = 0; i < this.getScores().length; i++) {
            if (i == 9) {
                scc = scc + this.getScores()[i];
            } else {
                scc = scc + this.getScores()[i] + " , ";
            }
        }
        
        
        str= String.format("%s ,  %s  , %s", this.getId(), this.getName(), scc);
    return str;
    }
    public String toString(){
         String str = "";
//        String scc = "";
//        int[] scArr = new int[10];
//        for (int i = 0; i < this.getScores().length; i++) {
//            if (i == 9) {
//                scc = scc + this.getScores()[i];
//            } else {
//                scc = scc + this.getScores()[i] + " , ";
//            }
//        }
        
        
        str= String.format("%s ,  %s", this.getId(), this.getName());
    return str;
    }
}
 