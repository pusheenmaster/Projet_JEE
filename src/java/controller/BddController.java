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

    public ModelAndView listMan(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        return new ModelAndView("resultatManufact").addObject("liste", new MagasinHelper().getManufactures());

    }

    public ModelAndView listProd(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        return new ModelAndView("resultatProduit").addObject("liste", new MagasinHelper().getProduits());

    }

    public ModelAndView add(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView("form_inscription");

        mv.addObject("user", session.getAttribute("user"));
        mv.addObject("discount", new MagasinHelper().getDiscountCode());
        mv.addObject("code", new MagasinHelper().getZipCode());
        return mv;
    }

    public ModelAndView addMan(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView("form_inscription_manufact");

        mv.addObject("user", session.getAttribute("user"));
        return mv;
    }

    public ModelAndView addProd(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView("form_inscription_product");
        mv.addObject("code", new MagasinHelper().getProductCode());
        mv.addObject("manID", new MagasinHelper().getManId());
        mv.addObject("user", session.getAttribute("user"));
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

    public ModelAndView detailMan(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView("detailMan");

        mv.addObject("user", session.getAttribute("user"));
        mv.addObject("client", new MagasinHelper().getManufact(request.getParameter("num")));
        return mv;
    }

    public ModelAndView detailProd(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView("detailProd");

        mv.addObject("user", session.getAttribute("user"));
        mv.addObject("client", new MagasinHelper().getProd(request.getParameter("num")));
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

    public ModelAndView findMan(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv;
        MagasinHelper requeteur = new MagasinHelper();
        if (requeteur.getManufactures(request.getParameter("nom")).isEmpty() || request.getParameter("nom").equals("%")) {
            mv = new ModelAndView("error");
            mv.addObject("erreur", "0 enregistrements");

        } else {
            mv = new ModelAndView("resultatManufact");
            mv.addObject("liste", requeteur.getManufactures(request.getParameter("nom")));

        }

        mv.addObject("user", session.getAttribute("user"));
        return mv;
    }

    public ModelAndView findByIdMan(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv;
        mv = new ModelAndView("error");
        mv.addObject("erreur", "Oops, la recherche par ID n'est pas encore implémenté.");
        return mv;
    }

    public ModelAndView findByIdProd(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv;
        mv = new ModelAndView("error");
        mv.addObject("erreur", "Oops, la recherche par ID n'est pas encore implémenté.");
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

    public ModelAndView formfindMan(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("rechercheMan");
    }

    public ModelAndView formfindProd(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return new ModelAndView("rechercheProd");
    }

    public ModelAndView achats(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView("achats");

        mv.addObject("user", session.getAttribute("user"));
        System.out.println("num " + Integer.parseInt(request.getParameter("numero")));

        mv.addObject("achats", new MagasinHelper().getAchats(Integer.parseInt(request.getParameter("numero"))));
        return mv;
    }

    public ModelAndView saveProduct(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String manId = request.getParameter("manId");
        String code = request.getParameter("product_code");
        String cost = request.getParameter("cost");
        String quantity = request.getParameter("quantity");
        String markup = request.getParameter("markup");
        String available = request.getParameter("available");
        String description = request.getParameter("description");
        new MagasinHelper().insertProduct(manId, code, cost, quantity, markup, available, description);
        return new ModelAndView("confirmProd").addObject("confirm", "Insert OK !");
    }

    public ModelAndView delete(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String idString = request.getParameter("numero");
        int id = Integer.valueOf(idString);
        new MagasinHelper().deleteCustomer(id);
        return new ModelAndView("confirm").addObject("confirm", "Delete OK !");
    }

    public ModelAndView deleteMan(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String idString = request.getParameter("numero");
        int id = Integer.valueOf(idString);
        new MagasinHelper().deleteManufacturer(id);
        return new ModelAndView("confirmManufact").addObject("confirm", "Delete OK !");
    }
    
    public ModelAndView deleteProd(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String idString = request.getParameter("numero");
        int id = Integer.valueOf(idString);
        new MagasinHelper().deleteProduct(id);
        return new ModelAndView("confirmProd").addObject("confirm", "Delete OK !");
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
    
        public ModelAndView saveManufact(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String adresse2 = request.getParameter("adresse2");
        String ville = request.getParameter("ville");
        String state = request.getParameter("state");
        if (state.length() > 2) {
            state = state.substring(0, 2);
        }
        String cp = request.getParameter("cp");
        String phone = request.getParameter("phone");
        String fax = request.getParameter("fax");
        String mail = request.getParameter("mail");
        String rep = request.getParameter("rep");
        new MagasinHelper().insertManufacturer(nom, adresse, adresse2, ville, state, cp, phone, fax, mail, rep);
        return new ModelAndView("confirmManufact").addObject("confirm", "Insert OK !");
    }

    public ModelAndView updateMan(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String idString = request.getParameter("numero");
        int id = Integer.valueOf(idString);
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String adresse2 = request.getParameter("adresse2");
        String ville = request.getParameter("city");
        String state = request.getParameter("state");
        String cp = request.getParameter("zip");
        String phone = request.getParameter("phone");
        String fax = request.getParameter("fax");
        String mail = request.getParameter("mail");
        String rep = request.getParameter("rep");
        new MagasinHelper().updateManufacturer(id, nom, adresse, adresse2, ville, state, cp, phone, fax, mail, rep);
        return new ModelAndView("confirmManufact").addObject("confirm", "Update OK !");
    }
    
    public ModelAndView updateProd(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String idString = request.getParameter("numero");
        int id = Integer.valueOf(idString);
        String manId = request.getParameter("manId");
        String code = request.getParameter("product_code");
        String cost = request.getParameter("cost");
        String quantity = request.getParameter("quantity");
        String markup = request.getParameter("markup");
        String available = request.getParameter("available");
        String description = request.getParameter("description");
        new MagasinHelper().updateProduct(id, manId, code, cost, quantity, markup, available, description);
        return new ModelAndView("confirmProd").addObject("confirm", "Insert OK !");
    }
    
}
