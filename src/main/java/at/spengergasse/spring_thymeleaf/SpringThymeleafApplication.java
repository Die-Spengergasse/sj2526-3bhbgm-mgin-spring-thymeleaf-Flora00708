package at.spengergasse.spring_thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// das ding startet mit der application klasse

@SpringBootApplication //+durch diese notation wird die klasse als spring boot application erkannt, damit wird die main methode automatisch aufgerufen
// sie startet ein framework also ein webserver und außerdem sucht die notion alle klassen die it dieser notaition versehen sind undmacht von denen eine Instanz und verknüpft diese mit anderen klassen, wenn sie in einem Package liegen oder in einem Unterpackage, das ist die sogenannte component scan, damit werden die klassen automatisch miteinander verbunden
// schaut ob noation, startet, und bindet sie ein, inmemory database wird automatisch für mich erstellt, und erstellt 1 tabelle
public class SpringThymeleafApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafApplication.class, args);
    }

}
