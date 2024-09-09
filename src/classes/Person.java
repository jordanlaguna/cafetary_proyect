/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;

/**
 *
 * @author jorda
 */
public class Person {

    private int id_person;

    private Date birth_date;

    private String identification;

    private String name;

    private String lastName;

    private String secondName;

    private int telephone;

    /**
     * @param id_person A id_person of the person
     * @param birth_date = dateBirth: An attribute of type Date that stores the
     * date of birth of the person.
     * @param identification = A String type attribute that stores the person's
     * ID number
     * @param name = A String attribute that stores the name of the person.
     * @param lastName = A String attribute that stores the person's first last
     * name.
     * @param secondName = A String attribute that stores the person's second
     * last name.
     * @param telephone = A String attribute that stores the person's second
     * last name.
     */
    public Person(int id_person, Date birth_date, String identification, String name,
            String lastName, String secondName, int telephone) {
        this.id_person = id_person;
        this.birth_date = birth_date;
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.secondName = secondName;
        this.telephone = telephone;
    }

    public Person() {

    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

}
