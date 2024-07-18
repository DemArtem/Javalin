package org.itstep.changeable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@PropertySource(value="classpath:app_ru_RU.properties")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run
                (Application.class, args);
    }

    @RestController
    static class HelloController {
        @Autowired
        private MessageSource messageSource;

        @RequestMapping({"/","index"})
        public String index(@RequestParam(name="lang", required = false) String lang) {

            //System.out.println(LocaleContextHolder.getLocale());
            // return messageSource.getMessage("app.hello", null, LocaleContextHolder.getLocale());

            String hello = messageSource.getMessage("app.hello", null, LocaleContextHolder.getLocale());
            String name = messageSource.getMessage("                    app.name                    ", null, LocaleContextHolder.getLocale());
            return String.format("%s, %s!%n", hello, name);

            /*
            ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.app", new Locale("ru","RU"));
            String hello = resourceBundle.getString("hello");
            String name = resourceBundle.getString("name");
            */

            // return lang;
        }
    }
}