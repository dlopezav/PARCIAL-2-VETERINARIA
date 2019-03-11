/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.Scanner;

/**
 *
 * @author DIEGO FELIPE LOPEZ AVILA
 */
public class menu {

    public menu() {
    }
    
    public int Menu(){
        int y=0;
        System.out.println("1. Remover mascotas dando id\n2. Escoja el tipo de mascota que quiere listar\n3. Finalizar ventana y listar mascotas");
        Scanner x = new Scanner(System.in);
        try{
        y = x.nextInt();
        }catch(Exception e){
            System.out.println("Ha ingresado mal el dato");
        }
        return y;
    }
            
}
