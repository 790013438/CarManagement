package snippets.jee.car_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import snippets.jee.car_management.dao.InfoDAO;

@Controller
public class InfoController {

    @Autowired
    InfoDAO infoDAO;

    @RequestMapping("/infos")
    public String getCourses (Model model) {
        model.addAttribute("infos", infoDAO.getInfos());
        return "infos";
    }

}
