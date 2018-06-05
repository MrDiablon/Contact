package hello;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName, lastName, surname, mail, number;

    protected Contact(){}

    public Contact(String fistname, String lastname, String surname, String mail, String number) {
        this.firstName = fistname;
        this.lastName = lastname;
        this.surname = surname;
        this.mail = mail;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getNumber() {
        return number;
    }
}
