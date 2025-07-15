package model;

public class User {
    
    private int userId;
    
    private String username;
    private String password;
    
    private boolean admin;

    public User(int userId, String username, String password){    
        
        //prendo il valore autoincrementato da una variabile contatore statica nel main
        this.userId = userId;
        this.username = username;
        
        //va aggiunto l'algoritmo di cifratura
        this.password = password;
        
        this.admin = false;
    }
    
    public int getUserId(){
        return this.userId;
    }
            
    public void setUserId(int id){
        this.userId = id;
    }
    
    public String getUsername(){
        return this.username;
    }
            
    public void setUsername(String username){
        this.username = username;
    }

    //secondo me devono essere privati questi due metodi
    
    //---------------------------//
    public String getPassword(){
        return this.password;
    }
            
    public void setPassword(String password){
        this.password = password;
    }
    //------------------------------------//
    
    public boolean isAdmin(){
        return this.admin;
    }
            
    public void setAdmin(boolean role){
          this.admin = role;
    }
    
    
}
