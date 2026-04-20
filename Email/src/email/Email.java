/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package email;

/**
 *
 * @author CarlosXl
 */
  
import java.util.Scanner;
  
public class Email {
    public String send;
    public String sub;
    public String content;
    public boolean leido;

    public Email(String send, String sub, String content) {
        this.send = send;
        this.sub = sub;
        this.content = content;
        this.leido = false;
    }

    public String getSend() {
        return send;
    }

    public String getSub() {
        return sub;
    }

    public String getContent() {
        return content;
    }

    public boolean isLeido() {
        return leido;
    }
    
    public void isread(){
        this.leido = true;
    }
    
    public void print(){
        System.out.println("DE: " + send);
        System.out.println("ASUNTO: " + sub);
        System.out.println(content);
    }
    
    
    
    
    
    
    
    
    
    
    
 
}
