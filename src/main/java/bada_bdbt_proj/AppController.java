package bada_bdbt_proj;

import bada_bdbt_proj.CzlonekDAO;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {

    @Autowired
    private CzlonekDAO dao;
    @Controller
    public class GreetingController {

        @GetMapping("/database")
        public String greeting(Model model) {
            System.out.println("dupasasaassa");
            List<Czlonek> czlonekList =dao.list();
            System.out.println(czlonekList.size());
            model.addAttribute("czlonekList",czlonekList);
            return "database";

        }

    }
    @Controller
    public class CreationConreoller {

        @GetMapping("/new")
        public String showNewForm(Model model) {
            System.out.println("modio");
            Czlonek czlon=new Czlonek();
            model.addAttribute("czlon",czlon);
            return "new_form";

        }

    }
    @Controller
    public class dodawanie {
        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save(@ModelAttribute("czlon") Czlonek czlon) {
            dao.save(czlon);
            System.out.println("dodawanko :)");
            return "redirect:/database";
        }
    }
    @Controller
    public class aktualizacja {
        @RequestMapping(value = "/update", method = RequestMethod.POST)
        public String save(@ModelAttribute("czlon") Czlonek czlon) {
            dao.update(czlon);
            System.out.println("aktualizacja :)");
            return "redirect:/database";
        }
    }
    @Controller
    public class edytowanie{
        @RequestMapping("/edit/{id}")
            public ModelAndView showEditForm(@PathVariable(name="id") int id)
            {
                ModelAndView mav=new ModelAndView("edit_form");
                Czlonek czlon=dao.get(id);
                mav.addObject("czlon",czlon);
                return mav;
            }
    }

    @Controller
    public class usuwanie{
        @RequestMapping("/delete/{id}")
        public String delete(@PathVariable(name="id") int id)
        {
            System.out.println("USUWAM");
            dao.delete(id);
            return "redirect:/database";
        }
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("dupazzzzz");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/database").setViewName("database");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/database_admin").setViewName("admin/database_admin");
        registry.addViewController("/database_user").setViewName("user/database_user");
    }

    @Controller
    public class DashboardController {
        @RequestMapping("/")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")||request.isUserInRole("USER") ) {
                return "redirect:/main";
            } else {
                return "redirect:/login";
            }
        }
    }

    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }


    @RequestMapping(value={"/database_admin"})
    public String showAdminDatabase(Model model) {
        return "admin/database_admin";
    }
    @RequestMapping(value={"/database_user"})
    public String showUserDatabase(Model model) {
        return "user/database_user";
    }
}