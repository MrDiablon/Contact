package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        return contacts;
    }


    @RequestMapping(value = "/add.htm", method = RequestMethod.GET)
    public String onClickBtnAdd(){
        return "redirect:/addContact/-1";
    }

    @RequestMapping(value = "/delete.htm/{id}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable("id")int id){
        log.info("test");
        log.info(String.valueOf(id));

        repository.delete(id);

        return "redirect:/index";
    }

}
