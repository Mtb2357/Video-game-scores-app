/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamesscoresapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mtb23
 */
class Scoreboard {

    private int studentCount;
    private Game[] games;
    private Student[] students;
    private final int MAX_STUDENTS = 100;

    class Stats {

        public int min;
        public int max;
        public double avg;

        public Stats(int min, int max, double avg){
            this.min = min;
            this.max = max;
            this.avg = max;
        }

        public int getMin() {
            return this.min;
        }

        public int getMax() {
            return this.max;
        }

        public double getAvg() {
            return this.avg;
        }

    }

    public Scoreboard() {
        this.studentCount = 0;
        this.games = new Game[10];
        this.students = new Student[this.MAX_STUDENTS];
    }

    public Scoreboard(int studentCount, Game[] g, Student[] s) {
        this.studentCount = studentCount;
        this.students = new Student[this.MAX_STUDENTS];
        for (int i = 0; i > s.length; i++) {
            this.students[i] = s[i];
        }
        this.games = new Game[g.length];
        for (int i = 0; i > g.length; i++) {
            this.games[i] = g[i];
        }
    }
//getters

    public Game[] getGames() {
        return this.games;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.studentCount;
    }

//to do
//setters(missing 1)
    public void setGames(Game[] g) {
        this.games = new Game[g.length];
        for (int i = 0; i > g.length; i++) {
            this.games[i] = g[i];
        }
    }

    public void setStudents(Student[] s) {
        this.students = new Student[this.MAX_STUDENTS];
        for (int i = 0; i > s.length; i++) {
            this.students[i] = s[i];
        }

    }

    public void setStudentCount(int s) {
        this.studentCount = s;
    }

    public void loadGames(String fileName) throws FileNotFoundException {
        File myFile = new File(fileName);
        Scanner myScan = new Scanner(myFile);
        int count = 0;
        while (myScan.hasNext()) {
            String line = myScan.nextLine();
            this.games[count] = Game.fromDataLine(line);

            System.out.println(this.games[count]);
            count++;
        }
        myScan.close();
        this.studentCount = count;
    }

    public void loadScores(String fileName) throws FileNotFoundException {
        File myFile = new File(fileName);
        Scanner myScan = new Scanner(myFile);
        int count = 0;
        while (myScan.hasNext()) {
            String line = myScan.nextLine();
            this.students[count] = Student.fromDataLine(line);
            System.out.println(this.students[count]);
            count++;
        }
        myScan.close();
        this.studentCount = count;
    }

    public void saveGames(String fileName) throws FileNotFoundException, IOException {
        PrintWriter myPrint = new PrintWriter(fileName);
        for (int i = 0; i < this.games.length; i++) {

            myPrint.println(this.games[i]);

        }
        myPrint.close();
    }

    public void saveScores(String fileName) throws FileNotFoundException, IOException {
        PrintWriter myPrint = new PrintWriter(fileName);
        for (int i = 0; i < this.students.length; i++) {
            myPrint.println(this.students[i]);

        }
        myPrint.close();
    }

    public void listGames() {
        for (Game g : this.games) {
            System.out.println(g);
        }
    }

    public void listScores() {
        for (int i = 0; i < this.studentCount; i++) {
            System.out.println(this.students[i]);

        }

    }

    public Student findStudentById(String id) {
        Student s = null;
        for (int i = 0; i < this.studentCount; i++) {
            Student ss = this.students[i];
            if (id.equals(ss.getId())) {
                s = ss;
                break;
            }

        }

        return s;
    }

    public int findGameIndexById(int id) {
        int check = -1;
        for (int i = 0; i < this.games.length; i++) {
            Game s = this.games[i];
            if (id == s.getId()) {
                check = i;
            }
            break;

        }

        return check;
    }

    public void updateScore(String studentId, int gameId, int newScore) {
        Student foundStudent = this.findStudentById(studentId);
        if (foundStudent == null) {
            System.out.println("Not found");

        } else {
            int[] scores = foundStudent.getScores();
            scores[gameId] = newScore;
        }
    }

    public Stats computeStatsForGame(int gameIndex) {
        int[] scoresForAGame = new int[this.studentCount];
        for (int i = 0; i < this.studentCount; i++) {
            Student s = this.students[i];
            int[] allHisScores = s.getScores();
             scoresForAGame[i] = allHisScores[gameIndex];
            
        }
        //compute min, max , avg
        int min = Utilities.findMinMin( scoresForAGame);//
        int max = Utilities.findMaxMax(scoresForAGame);
        double avg = Utilities.findAvgAvg(scoresForAGame);
        
        Stats myStats = new Stats(min, max, avg);
        
        return myStats;

    }
//        int[] ns1 = {120 , 95 , 88 , 77 , 130 , 90 , 100 , 85 , 93 , 110};
//        int[] ns2 = {140 , 82 , 91 , 89 , 121 , 102 , 111 , 88 , 95 , 97};
//        int[] ns3 = {98 , 110 , 105 , 99 , 87 , 120 , 115 , 92 , 101 , 108};
//        Student s1 = new Student("S1", "id1", ns1);
//        Student s2 = new Student("S2", "id2", ns2);
//        Student s3 = new Student("S3", "id3", ns3);
//        Student[] sArr= {s1,s2,s3};

    public Stats compute(int gameIndex) {

        int maxScore = Utilities.findMaxScore(gameIndex, this.students);
        int minScore = Utilities.findMinScore(gameIndex, this.students);
        double avg = Utilities.findAverage(gameIndex, this.students);
        Stats myStats = new Stats(minScore, maxScore,avg );

        return myStats;
    }

}
