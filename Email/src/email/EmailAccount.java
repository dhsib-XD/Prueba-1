/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email;

/**
 *
 * @author CarlosXl
 */
public class EmailAccount {
    public String direcion;
    public String pass;
    public String nom;
    public Email[] inbox;
    int max = 100;

    public EmailAccount(String direcion, String pass, String nom) {
        this.direcion = direcion;
        this.pass = pass;
        this.nom = nom;
        this.inbox = new Email[max];
    }

    public String getDirecion() {
        return direcion;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return nom;
    }

    public boolean recibirCorreo(Email mail) {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] == null) {
                inbox[i] = mail;
                return true;
            }
        }
        return false;
    }

    public void MInbox() {
        System.out.println("Cuenta: " + direcion + " (" + nom + ")");
        int noleido = 0;
        int tt = 0;

        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null) {
                String estado = inbox[i].isLeido() ? "LEIDO" : "SIN LEER";
                System.out.println((i + 1) + " - " + inbox[i].getSend() + " - " + 
                                   inbox[i].getSub() + " - " + estado);

                if (!inbox[i].isLeido()) noleido++;
                tt++;
            }
        }
        System.out.println("Correos sin leer: " + noleido);
        System.out.println("Total de correos recibidos: " + tt);
    }

    public void leerCorreo(int posicion) {
        int index = posicion - 1;
        if (index >= 0 && index < inbox.length && inbox[index] != null) {
            inbox[index].print();
            inbox[index].isread();
        } else {
            System.out.println("Correo No Existe");
        }
    }

    public void eliminarLeidos() {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null && inbox[i].isLeido()) {
                inbox[i] = null;
            }
        }
        System.out.println("Inbox limpiado con exito.");
    }
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
       

        
    
    
    
    
    
    

