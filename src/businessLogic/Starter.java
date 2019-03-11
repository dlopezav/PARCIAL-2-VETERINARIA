/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author dfeli
 */
public class Starter {
    public static ArrayList<Person> personas;
    public static Veterinaria vet;
    
    
    public static void main(String[] args) throws IOException {
        Starter starter = new Starter();
        int x=0;
        personas = new ArrayList<>(); 
        Scanner lectura = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        vet = new Veterinaria();
        
        menu Menu= new menu();
       Boolean r= true;
        while(r){
            System.out.println("Bienvenido a la veterinaria, ingrese lo que desee hacer.");
            starter.ReadPets(vet);
            try{
            x = Menu.Menu();
            }catch(Exception e){
                System.out.println("Ha ingresado mal un dato");
            }
        switch(x){
            case 1:
                System.out.println("Remover mascotas dando id");
                System.out.println("Ingrese el id de la mascota que quiere remover");
                String name = "";
                try{
                name = str.nextLine();
                }catch(Exception e){
                    System.out.println("Ha ingresado un caracter erroneo");
                }
                Iterator<Pet> iter = vet.getPets().iterator();
                    Pet pet = null;
                    while (iter.hasNext()) {
                        Pet peto = iter.next();
                        if (peto.getId().equals(name)){
                            iter.remove();
                            vet.removePet(vet);
                            
                        }
                    }
                    starter.ReadPets(vet);
                    
                    
                
                break;
            case 2:
                int b=0;
                System.out.println("Escoja el tipo de mascota que quiere listar:");
                
                System.out.println("1. Perros\n2. Gatos \n3.Hamsters");
                try{
                    b = lectura.nextInt();
                }catch(Exception e){
                    System.out.println("Ha ingresado un caracter erroneo");
                }
                switch(b){
                    case 1:
                        for(Pet perro: vet.getPets()){
                            if(perro instanceof Dog){
                                System.out.println(((Dog)perro).getName());
                            }
                        }
                        break;
                    case 2:
                        for(Pet cat: vet.getPets()){
                            if(cat instanceof Cat){
                                System.out.println(((Cat)cat).getName());
                            }
                        }
                        break;
                    case 3:
                        for(Pet hm: vet.getPets()){
                            if(hm instanceof Hamster){
                                System.out.println(((Hamster)hm).getName());
                            }
                        }
                        break;
                }
                break;
                case 3:
                {
                int P=0;
                System.out.println("LISTA:");
                
                for(Pet perro: vet.getPets()){
                            if(perro instanceof Dog){
                                System.out.println("Perro: "+((Dog)perro).getName());
                            }
                        }
                  
                for(Pet cat: vet.getPets()){
                            if(cat instanceof Cat){
                                System.out.println("Gato: "+((Cat)cat).getName());
                            }
                        }
               
                for(Pet hm: vet.getPets()){
                            if(hm instanceof Hamster){
                                System.out.println("Hamster: "+((Hamster)hm).getName());
                            }
                        }
                     
                }
                r = false;
                break;
                
        }
        }
    }
    
    public void manageVet(Veterinaria v, String action){
        
    }
    public void ReadPets(Veterinaria v) throws IOException{
        File file = new File("ARCHIVO/pets.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        ArrayList<Pet> petss = new ArrayList();
        FileInputStream fa = new FileInputStream (file); 
        BufferedReader lfa = new BufferedReader(new InputStreamReader(fa));
        while(lfa.ready()){
            String q = lfa.readLine();
        
            if(q.contains("Dog")){
                String x[]=q.split(" ");
                Pet pet = new Dog(x[1],x[2],x[3],x[4]);
                petss.add(pet);
                String dueno = lfa.readLine();
                String y[] = dueno.split(" ");
                boolean bobo=false;
                for(Person xx: personas){
                    if(xx.getId().equals(y[1])){
                        xx.getPets().add(pet);
                        bobo = true;
                    }
                }
                if(bobo==false){
                    ////////////////////////////AQUI SE MIRA QUE LA PERSONA NO EXITA YA ///////////////////////////////////////
                    Person person = new Person(y[0],y[1]);
                    person.getPets().add(pet);
                    personas.add(person);
                }
            }
            if(q.contains("Cat")){
            String x[]=q.split(" ");
                Pet pet = new Cat(parseBoolean(x[4]),x[1],x[2],x[3]);
                
                petss.add(pet);
                String dueno = lfa.readLine();
                String y[] = dueno.split(" ");
                boolean bobo=false;
                for(Person xx: personas){
                    if(xx.getId().equals(y[1])){
                        xx.getPets().add(pet);
                        bobo = true;
                    }
                }
                if(bobo==false){
                    Person person = new Person(y[0],y[1]);
                    person.getPets().add(pet);
                    personas.add(person);
                }
            }
            if(q.contains("Hamster")){
            String x[]=q.split(" ");
                Pet pet = new Hamster(parseDouble(x[4]),x[1],x[2],x[3]);
                petss.add(pet);
                String dueno = lfa.readLine();
                String y[] = dueno.split(" ");
                boolean bobo=false;
                for(Person xx: personas){
                    if(xx.getId().equals(y[1])){
                        xx.getPets().add(pet);
                        bobo = true;
                    }
                }
                if(bobo==false){
                    Person person = new Person(y[0],y[1]);
                    person.getPets().add(pet);
                    personas.add(person);
                }
            }
        }
        lfa.close();
        v.setPets(petss);
    }
}
