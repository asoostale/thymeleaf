package hello.thymeleaf.basic;

import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello &lt;b&gt;Spring&lt;/b&gt;");
        return "basic/text-basic";
    }

    @GetMapping("text-unescaped")
    public String unescaped(Model model) {
        model.addAttribute("data", "Hello <b>Spring</b>");
        return "basic/text-unescaped";
    }

    @GetMapping("/variable")
    public String variable(Model model) {

        User userA = new User(1,"userA", 10);
        User userB = new User(2,"userB", 20);

        List<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        Map<String, User> store = new HashMap<>();
        store.put("userA", userA);
        store.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", store);

        return "basic/variable";
    }

    @GetMapping("/basic-date")
    public String basicObjects(Model model) {

        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/basic-date";

    }

    @GetMapping("/link")
    public String link(Model model) {

        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "basic/link";

    }

    @GetMapping("/elvis")
    public String elvis(Model model) {

        model.addAttribute("null", null);
        model.addAttribute("name", "Joo");
        return "basic/elvis";

    }

    @GetMapping("/attribute")
    public String attribute() {
        return "basic/attribute";
    }


    @GetMapping("/each")
    public String each(Model model) {
        addUsers(model);
        return "basic/basic-each";
    }

    @GetMapping("/block")
    public String block(Model model) {
        addUsers(model);
        return "basic/basic-block";
    }

    @GetMapping("/javascript")
    public String javascript(Model model) {
        model.addAttribute("user", new User(11,"userA", 10));
        addUsers(model);

        return "basic/javascript";
    }

    private void addUsers(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"주수영", 33));
        list.add(new User(2,"둘리", 10));
        list.add(new User(3,"신용권", 53));
        list.add(new User(4,"김대철", 43));
        list.add(new User(5,"이시언", 8));
        list.add(new User(6,"이시아", 6));
        list.add(new User(7,"주리아", 35));
        list.add(new User(8,"박정란", 63));
        list.add(new User(9,"박솔", 33));
        list.add(new User(10,"정두울", 29));

        model.addAttribute("users", list);


    }

    @Data
    static class User {
        private int id;
        private String username;
        private int age;

        public User(int id, String username, int age) {
            this.id = id;
            this.username = username;
            this.age = age;
        }
    }


}
