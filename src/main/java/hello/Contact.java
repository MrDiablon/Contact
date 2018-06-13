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

    public Contact(AddContactForm contactForm) {
        this.id = contactForm.getId();
        this.firstName = contactForm.getFirstName();
        this.lastName = contactForm.getLastName();
        this.surname = contactForm.getSurname();
        this.mail = contactForm.getMail();
        this.number = contactForm.getNumber();
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}
