package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("/addContact/{id}")
public class addContactController implements WebMvcConfigurer {
    @Autowired
    ContactRepository repository;

    private String btnText = "valider";

    @ModelAttribute("btnText")
    public String getBtnText() {
        return this.btnText;
    }

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

    @RequestMapping(value = "/addContact/index.htm", method = RequestMethod.GET)
    public String onClickBtnIndex(){
        log.info("index");
        return "redirect:/index";
    }

    @GetMapping("/addContact/{id}")
    public String addContactForm( AddContactForm contactForm, @PathVariable("id")int id){
        this.btnText = "Ajouter";

        if(id >= 0){
            Contact contact = repository.findOne(id);
            contactForm.setValues(contact);
            this.btnText = "Modifier";
            log.info("id");
        }

        return "addContact";
    }

    @PostMapping("/addContact/{id}")
    public String checkPersonInfo(@Valid AddContactForm contactForm, BindingResult bindingResult) {

        log.info("mapping");

        if (bindingResult.hasErrors()) {
            return "addContact";
        } else {
            repository.save(new Contact(contactForm));
        }

        return "redirect:/index";
    }

}
