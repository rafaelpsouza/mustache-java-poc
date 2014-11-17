package br.eng.rafaelsouza.poc.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rafael Souza
 */
public class Main {

    List<Menu> menus() {
        return Arrays.asList(
                new Menu("Menu 1", true, Arrays.asList(new Link("Google", "google.com"), new Link("Facebook", "facebook.com"))),
                new Menu("Menu 2", false, Arrays.asList(new Link("Trello", "trello.com"), new Link("Github", "github.com")))
        );
    }

    static class Menu {

        Menu(String title, Boolean visible, List<Link> links) {
            this.title = title;
            this.visible = visible;
            this.links = links;
        }
        private String title;
        Boolean visible;
        List<Link> links;

        /* Use get for private fields */
        public String getTitle() {
            return title;
        }
        
    }

    static class Link {

        Link(String description, String url) {
            this.description = description;
            this.url = url;
        }
        String description, url;
    }
    
    
    public static void main(String[] args) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        //Mustache mustache = mf.compile("list.mustache");
        //Mustache mustache = mf.compile("if.mustache");
        //Mustache mustache = mf.compile("partials/base.mustache");
        Mustache mustache = mf.compile("inheritance/sub.mustache");
        mustache.execute(new PrintWriter(System.out), new Main()).flush();
    }

}
