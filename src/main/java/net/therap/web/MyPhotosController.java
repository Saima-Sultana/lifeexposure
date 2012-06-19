package net.therap.web;

import net.therap.domain.Photo;
import net.therap.domain.User;
import net.therap.service.PhotoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: saima
 * Date: 6/11/12
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("myphotos.html")
public class MyPhotosController {
    private static final Logger log = LoggerFactory.getLogger(MyPhotosController.class);

    @Autowired
    private PhotoManager photoManager;

    @RequestMapping(method = RequestMethod.GET)
    public String showPhotos(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("User") == null) {
            return "redirect:loginform.html";
        }

        User user = (User) session.getAttribute("User");
        List<Photo> photoList = photoManager.getPhotos(user);
        log.info("listSize", photoList.size());

        model.addAttribute("photoList", photoList);
        model.addAttribute("loginName", user.getLoginName());
        model.addAttribute("userId", user.getUserId());
        return "myphotos";
    }
}
