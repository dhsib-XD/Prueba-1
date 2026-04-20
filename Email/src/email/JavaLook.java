/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package email;

import java.util.Scanner;

/**
 *
 * @author CarlosXl
 */
public class JavaLook {
    private static EmailAccount[] cuentas = new EmailAccount[100];
    private static EmailAccount cuentaActiva = null;
    private static Scanner lea = new Scanner(System.in);

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        while (true) {
            if (cuentaActiva == null) {
                menuInicial();
            } else {
                menuPrincipal();
            }
        }
    }

    private static void menuInicial() {
        System.out.println("\n1. Login\n2. Crear cuenta\n3. Salir\nSeleccione:");
        int op = lea.nextInt();
        lea.nextLine();

        if (op == 1) login();
        else if (op == 2) crearCuenta();
        else if (op == 3) System.exit(0);
    }

    private static void login() {
        System.out.print("Correo: ");
        String c = lea.nextLine();
        System.out.print("Contrasena: ");
        String p = lea.nextLine();

        for (EmailAccount acc : cuentas) {
            if (acc != null && acc.getDirecion().equals(c) && acc.getPass().equals(p)) {
                cuentaActiva = acc;
                System.out.println("Sesion iniciada.");
                return;
            }
        }
        System.out.println("Credenciales incorrectas.");
    }

    private static void crearCuenta() {
        System.out.print("Correo: ");
        String c = lea.nextLine();
        for (EmailAccount acc : cuentas) {
            if (acc != null && acc.getDirecion().equals(c)) {
                System.out.println("El correo ya existe.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String n = lea.nextLine();
        System.out.print("Password: ");
        String p = lea.nextLine();

        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = new EmailAccount(c, p, n);
                cuentaActiva = cuentas[i];
                System.out.println("Cuenta creada.");
                return;
            }
        }
    }

    private static void menuPrincipal() {
        System.out.println("\n1. Ver inbox\n2. Mandar correo\n3. Leer correo\n4. Limpiar inbox\n5. Cerrar sesion");
        int op = lea.nextInt();
        lea.nextLine();

        switch (op) {
            case 1:
                cuentaActiva.MInbox();
                break;
            case 2:
                mandarCorreo();
                break;
            case 3:
                System.out.print("Posicion: ");
                int p = lea.nextInt();
                cuentaActiva.leerCorreo(p);
                break;
            case 4:
                cuentaActiva.eliminarLeidos();
                break;
            case 5:
                cuentaActiva = null;
                System.out.println("Sesion cerrada.");
                break;
        }
    }

    private static void mandarCorreo() {
        System.out.print("Para: ");
        String para = lea.nextLine();
        System.out.print("Asunto: ");
        String as = lea.nextLine();
        System.out.print("Contenido: ");
        String cont = lea.nextLine();

        Email mail = new Email(cuentaActiva.getDirecion(), as, cont);
        for (EmailAccount acc : cuentas) {
            if (acc != null && acc.getDirecion().equals(para)) {
                if (acc.recibirCorreo(mail)) System.out.println("Enviado con exito.");
                else System.out.println("Inbox del destinatario lleno.");
                return;
            }
        }
        System.out.println("Destinatario no existe.");
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}