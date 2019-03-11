/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import static businessLogic.Starter.personas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;

/**
 *
 * @author DIEGO FELIPE LOPEZ AVILA
 */
public class Veterinaria {

    private ArrayList<Pet> pets;

    public Veterinaria() {
        this.pets = new ArrayList<>();
    }
    
    
    public void removePet(Veterinaria v) throws IOException{
        
        File file = new File("ARCHIVO/pets.txt");
        file.createNewFile();
        ArrayList<Pet> petss = new ArrayList();
        FileInputStream fa = new FileInputStream (file); 
        BufferedReader lfa = new BufferedReader(new InputStreamReader(fa));
        PrintWriter pw = new PrintWriter(new FileWriter(file));
        for(Pet pet: v.getPets()){
            if(pet instanceof Dog){
                pw.print("\nDog"+" "+pet.getId()+" "+pet.getName()+" "+pet.getHairColor()+" "+((Dog) pet).getBreed());
                for(Person persona: personas){
                if(persona.getPets().contains(pet))
                    pw.print("\n"+persona.getName()+" "+persona.getId());
                }
            }
            if(pet instanceof Cat){
                pw.print("\nCat"+" "+pet.getId()+" "+pet.getName()+" "+pet.getHairColor()+" "+((Cat) pet).isIsHunter());
                for(Person persona: personas){
                if(persona.getPets().contains(pet))
                    pw.print("\n"+persona.getName()+" "+persona.getId());
                }
                
            }
            if(pet instanceof Hamster){
                pw.print("\nHamster"+" "+pet.getId()+" "+pet.getName()+" "+pet.getHairColor()+" "+((Hamster)pet).getWeight());
                for(Person persona: personas){
                if(persona.getPets().contains(pet))
                    pw.print("\n"+persona.getName()+" "+persona.getId());
                }
            }
        }
        pw.close();
        lfa.close();
    }

    private ArrayList<Pet> ShowPetsByType(String type){
        return pets;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
    
    
}