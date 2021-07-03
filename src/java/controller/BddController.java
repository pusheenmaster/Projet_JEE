/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.*;
import service.User;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.*;
import javax.servlet.*;

/**
 *
 * @author faycal
 */
public class BddController extends MultiActionController {

    private String login;
    private String pwd;
    private User utilisateur;
    private HttpSession session;

    public BddController() {
    }

    public ModelAndView menu(HttpServletRequest request,
            HttpServletResponse response) {

        login = request.getUserPrincipal().getName();

        //pwd=request.getParameter("password");
        utilisateur = new User(login);

        session = request.getSession();
        session.setAttribute("user", utilisateur);
        System.out.println("nbuser=" + User.getCompteur());
        return new ModelAndView("menu").addObject("user", utilisateur);

    }

    public ModelAndView logout(HttpServletRequest request,
            HttpServletResponse response) {

        request.getSession().invalidate();

        return new ModelAndView("deconnexion");

    }

    public ModelAndView list(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        return new ModelAndView("resultat").addObject("liste", new MagasinHelper().getClients());

    }

    public ModelAndView add(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView("form_inscription");

        mv.addObject("user", session.getAttribute("user"));
        mv.addObject("discount", new MagasinHelper().getDiscountCode());
        mv.addObject("code", new MagasinHelper().getZipCode());
        return mv;
    }

    public ModelAndView detail(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView("detail");

        mv.addObject("user", session.getAttribute("user"));
        mv.addObject("code", new MagasinHelper().getDiscountCode());

        mv.addObject("client", new MagasinHelper().getClient(request.getParameter("num")));
        return mv;
    }

    public ModelAndView find(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv;
        MagasinHelper requeteur = new MagasinHelper();
        if (requeteur.getClients(request.getParameter("nom")).isEmpty() || request.getParameter("nom").equals("%")) {
            mv = new ModelAndView("error");
            mv.addObject("erreur", "0 enregistrements");

        } else {
            mv = new ModelAndView("resultat");
            mv.addObject("liste", requeteur.getClients(request.getParameter("nom")));

        }

        mv.addObject("user", session.getAttribute("user"));
        return mv;
    }
    
    public ModelAndView findById(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv;
        MagasinHelper requeteur = new MagasinHelper();
        String test = request.getParameter("num");
        if (requeteur.getClientsById(request.getParameter("num")).isEmpty() || request.getParameter("num").equals("%")) {
            mv = new ModelAndView("error");
            mv.addObject("erreur", "0 enregistrements");

        } else {
            mv = new ModelAndView("resultat");
            mv.addObject("liste", requeteur.getClientsById(request.getParameter("num")));

        }

        mv.addObject("user", session.getAttribute("user"));
        return mv;
    }

    public ModelAndView formfind(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("recherche");
    }

    public ModelAndView achats(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView("achats");

        mv.addObject("user", session.getAttribute("user"));
        System.out.println("num " + Integer.parseInt(request.getParameter("numero")));

        mv.addObject("achats", new MagasinHelper().getAchats(Integer.parseInt(request.getParameter("numero"))));
        return mv;
    }

    public ModelAndView save(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String param1 = request.getParameter("nom");
        String param2 = request.getParameter("adresse");
        String param21 = request.getParameter("adresse2");
        String param3 = request.getParameter("telephone");
        String param4 = request.getParameter("email");
        String param5 = request.getParameter("code_remise");
        String param6 = request.getParameter("CP");
        new MagasinHelper().insertCustomer(param1, param2, param21, param3, param4, param5.charAt(0), param6);
        return new ModelAndView("confirm").addObject("confirm", "Insert OK !");

    }

    public ModelAndView delete(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String idString = request.getParameter("numero");
        int id = Integer.valueOf(idString);
        new MagasinHelper().deleteCustomer(id);
        return new ModelAndView("confirm").addObject("confirm", "Delete OK !");
    }

    public ModelAndView update(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String idString = request.getParameter("numero");
        int id = Integer.valueOf(idString);
        String param1 = request.getParameter("nom");
        String param2 = request.getParameter("adresse");
        String param21 = request.getParameter("adresse2");
        String param3 = request.getParameter("telephone");
        String param4 = request.getParameter("email");
        String param5 = request.getParameter("code_remise");
        String param6 = request.getParameter("zip");
        new MagasinHelper().updateCustomer(id, param1, param2, param21, param3, param4, param5.charAt(0), param6);
        return new ModelAndView("confirm").addObject("confirm", "Update OK !");
    }
}
