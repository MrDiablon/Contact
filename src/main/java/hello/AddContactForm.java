package hello;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddContactForm {

    private int id;

    @NotNull
    @Size(min=2, max=30)
    private String firstName;

    @NotNull
    @Size(min=2, max=30)
    private String lastName;

    @Size (min=0, max=30)
    private String surname;

    @NotNull
    private String mail;

    @NotNull
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "Person(nom: " + this.firstName + ", prénom: " + this.lastName + ")";
    }

    public void setValues(Contact contact){
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.surname = contact.getSurname();
        this.mail = contact.getMail();
        this.number = contact.getNumber();
        this.id = contact.getId();
    }
}
