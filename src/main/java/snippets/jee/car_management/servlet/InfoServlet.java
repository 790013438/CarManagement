package snippets.jee.car_management.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import snippets.jee.car_management.rest.ws.dto.InfoDTO;
import snippets.jee.car_management.util.PageBean;

@WebServlet("/info")
public class InfoServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SIZE = 5;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        PageBean<InfoDTO> pageBean = (PageBean<InfoDTO>) getInfoService().listAllInfo(page, size);
        // 1. 将对象转换成JSON格式的字符串返回给浏览器
        String jsonStr = JSON.toJSONString(pageBean);
        // 2. 把JSON字符串输出到浏览器通过MIME类型告诉浏览器这里是JSON格式
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(jsonStr);
        printWriter.close();
    }

}
