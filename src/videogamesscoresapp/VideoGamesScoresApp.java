/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videogamesscoresapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mtb23
 */
public class VideoGamesScoresApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
//        int[] ns1 = {120 , 95 , 88 , 77 , 130 , 90 , 100 , 85 , 93 , 110};
//        int[] ns2 = {140 , 82 , 91 , 89 , 121 , 102 , 111 , 88 , 95 , 97};
//        int[] ns3 = {98 , 110 , 105 , 99 , 87 , 120 , 115 , 92 , 101 , 108};
//        Student s1 = new Student("S1", "id1", ns1);
//        Student s2 = new Student("S2", "id2", ns2);
//        Student s3 = new Student("S3", "id3", ns3);
//        
//        Student[] sArr= {s1,s2,s3};
//        Game g1 = new Game(1,"Galaxy Wars","Shooter","NovaSoft");
//        Game g2 = new Game();
//        Game g3 = new Game();
//        Game g4 = new Game();
//        Game g5 = new Game();
//        Game g6 = new Game();
//        Game g7 = new Game();
//        Game g8 = new Game();
//        Game g9 = new Game();
//        Game g10 = new Game();
//        Game[] gArr = {g1,g2,g3,g4,g5,g6,g7,g8,g9,g10};
//        Scoreboard test = new Scoreboard(10,gArr, sArr);
//        
//        int minT = test.compute(4).getMin();
//        int maxT = test.compute(4).getMax();
//        double avgT= test.compute(4).getAvg();
//        
//        System.out.printf("%d, %d, %.2f", minT, maxT, avgT);
//        
//        
//        
//        
//        
//        
//        
        
        
        Scanner key = new Scanner(System.in);
        Scoreboard myScoreboard = new Scoreboard();
        myScoreboard.loadGames("C:\\Users\\mtb23\\Escritorio\\asdf\\java\\VideoGamesScoresApp\\src\\videogamesscoresapp\\games.txt");
        myScoreboard.loadScores("C:\\Users\\mtb23\\Escritorio\\asdf\\java\\VideoGamesScoresApp\\src\\videogamesscoresapp\\scores.txt");
        int[] num = {120 , 95 , 88 , 77 , 130 , 90 , 100 , 85 , 93 , 110};
        myScoreboard.saveScores("asdf.txt");
        Student myS = new Student("S001" , "Arbis  Jaidon" ,num);
        
//        String aaa = myS.toDataLine(myS);
//        System.out.println(aaa);
        System.out.println(myS);               
        int choice = -1;
        do {

            printMenu();
            choice = Utilities.getUserChoice("Enter your choice : ");
            
            switch (choice) {
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            case 1:
                handleListGames(myScoreboard);
                break;
            case 2:
                handleListStudents(myScoreboard);
                break;
            case 3:
                handleStudentReport();
                break;
            case 4:
                handleTopNforAgame();
                break;
            case 5:
                updateStudentScore();
                break;
            case 6:
                handleGameStats();
                break;
            case 7:
                handleAddNewStudent();
                break;
            case 8:
                handleSaveData();
                break;
        }
            

        } while ((choice > 0) && (choice < 8));

        
    }
    public static void printMenu(){
    System.out.print("====Video GameScoreboard====\n"
                    +"1) List Games\n"
                    +"2) List Students\n"
                    +"3) Show a students's report\n"
                    +"4) Show top N for a game\n"
                    +"5) Update a student's score\n"
                    +"6) Game stats (min/max/avg)\n"
                    +"7) Add a new student\n"
                    +"8) Save data\n"
                    +"0) Exit\n");
    
    }
    
    
    public static void handleListGames(Scoreboard sb) {
        System.out.print("Handling list game choice");
        sb.listGames();
    }

    public static void handleListStudents(Scoreboard sb) {
        System.out.print("Handling list student choice ");
        sb.listScores();
    }

    public static void handleStudentReport() {
        System.out.print("Handling list student report choice");
    }

    public static void handleTopNforAgame() {
        System.out.print("Handling top N for a game choice");
    }

    public static void updateStudentScore() {
        System.out.print("Handling update student score choice");
    }

    public static void handleGameStats() {
        System.out.print("Handling list game stats choice");
    }

    public static void handleAddNewStudent() {
        System.out.print("Handling new student choice");
    }

    public static void handleSaveData() {
        System.out.print("Handling save data choice");
    }
    
    
}
