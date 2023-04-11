/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import dtos.RenameMeDTO;
import entities.Hobby;
import entities.Person;
import entities.RenameMe;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        PersonFacade pf = PersonFacade.getPersonFacade(emf);
        PersonDTO p1 = new PersonDTO(new Person("First 1", 1));
        pf.create(p1);

        pf.create(new PersonDTO(new Person("First 1", 1)));
        pf.create(new PersonDTO(new Person("First 2", 2)));
        pf.create(new PersonDTO(new Person("First 3", 3)));
        HobbyDTO hdto1 = new HobbyDTO(new Hobby("Hobby 1", "Description 1"));
        HobbyDTO hdto2 = new HobbyDTO(new Hobby("Hobby 1", "Description 1"));
        hdto1 = pf.createHobby(hdto1);
        pf.createHobby(hdto2);
        pf.addHobby(p1.getId(), hdto1.getId());
    }
    
    public static void main(String[] args) {
        populate();
    }
}
