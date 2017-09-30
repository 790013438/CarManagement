package snippets.jee.car_management.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;

import snippets.jee.car_management.dao.InfoDAO;
import snippets.jee.car_management.rest.ws.dto.InfoDTO;
import snippets.jee.car_management.util.PageBean;

@Controller
public class InfoController {

    private int DEFAULT_PAGE = 1;
    private int DEFAULT_SIZE = 5;
    @Autowired
    InfoDAO infoDAO;

    @RequestMapping("/infos")
    public String getInfos (Model model) {
        model.addAttribute("infos", infoDAO.getInfos());
        return "infos";
    }

    @RequestMapping(value="/info", method=RequestMethod.POST)
    public void getInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int page = DEFAULT_PAGE;
        String pageStr = req.getParameter("page");
        if (pageStr != null) {
            try {
                page = Integer.parseInt(pageStr);
                page = page <= 0 ? DEFAULT_PAGE : page;
            } catch (NumberFormatException e) {
            }
        }
        int size = DEFAULT_SIZE;
        PageBean<InfoDTO> pageBean = infoDAO.getInfos(page, size);
        // 1. 将对象转换成JSON格式的字符串返回给浏览器
        String jsonStr = JSON.toJSONString(pageBean);
        // 2. 把JSON字符串输出到浏览器通过MIME类型告诉浏览器这里是JSON格式
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(jsonStr);
        printWriter.close();
    }
}
