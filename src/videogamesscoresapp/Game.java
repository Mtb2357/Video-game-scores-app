/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogamesscoresapp;

import java.util.Locale;

/**
 *
 * @author mtb23
 */
public class Game {
    private int id;
    private String title;
    private String genre;
    private String publisher;
    
    //constructors
    public Game(){
        this.id = 0;
        this.title = "";
        this.genre = "";
        this.publisher = "";
    }
    
    public Game(int i, String t, String g, String p){
        this.id = i;
        this.title = t;
        this.genre = g;
        this.publisher = p;
    }
    //getters
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getGenre(){
        return this.genre;
    }
    public String getPublisher(){
        return this.publisher;
    }
    
    //Setters
    public void setId(int i){
        this.id = i ;
    }
    
    public void setTitle(String t){
        this.title = t;
    }
    public void setGenre(String g){
        this.genre = g;
    }
    public void setPublisher(String p){
        this.publisher = p;
    }
    
    public String toDataLine(Game h){
        
        int idObj = h.getId();
        String titObj = h.getTitle();
        String genObj = h.getGenre();
        String pubObj = h.getPublisher();
        String sss = String.format("%d, %s, %s, %s", idObj,titObj,genObj,pubObj);
        
   return sss;
    }
    public static Game fromDataLine(String s){
        String[] parts = s.split(",");
        int localId = Integer.parseInt(parts[0]);
        
        
    Game mygame = new Game(localId, parts[1], parts[2], parts[3]);
    return mygame;
    }
    public String toString(){
        String str = "";
        str = String.format("%5d, %20s, (%15s, %15s)", this.getId(), this.getTitle(), this.getGenre(), this.getPublisher());
    
    return str;
    }
    public boolean equals(Game g) {
        boolean result = false;
        if (g.getId() == this.getId() && g.getTitle().equals(this.getTitle())
                && g.getGenre().equals(this.getGenre())
                && g.getPublisher().equals(this.getPublisher())) {
            result = true;
        }
        return result;
    }
}
