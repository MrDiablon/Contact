package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;

@Controller
@SessionAttributes("/index")
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    @Autowired
    ContactRepository repository;

    @GetMapping("/index")
    public String index(){

        return "index";
    }

    @ModelAttribute("allContact")
    public Iterable<Contact> getAllContact(){

        Iterable<Contact> contacts = repository.findAll();
        /*for (Contact customer : contacts) {
            log.info(customer.toString());
        }*/
        return contacts;
    }

}
