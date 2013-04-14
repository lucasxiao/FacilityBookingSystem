/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookingDAO;
import dao.CustomerDAO;
import dao.FacilityDAO;
import entity.Customer;
import entity.Facility;
import entity.FacilityInstances;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author naresh
 */
@WebServlet(name = "ControllerServlet", 
        urlPatterns = {
            "/index", 
            "/facility",
            /*"/login",
            "/logout",
            "/book", 
            "/view", 
            "/user-profile", 
            "/user-bookings", 
            "/cancel-booking"*/})
public class ControllerServlet extends HttpServlet {
    
    @EJB 
    CustomerDAO customerDAO;
    
    @EJB
    BookingDAO bookingDAO;    
    
    @EJB
    FacilityDAO facilityDAO;
    
    
    @Override
    public void init() throws ServletException {
        super.init();

        // store category list in servlet context. They are same for all users
        getServletContext().setAttribute("facilities", facilityDAO.findAll());
    }

    
   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        System.out.println(" in get " + userPath);
        Customer loggedInUser = (Customer) session.getAttribute("customer");
        
        if (userPath.equals("index")){
            //do nothing
        }
        // if category page is requested
        else if (userPath.equals("/facility")) {

            // get categoryId from request
            String facilityId = request.getQueryString();
            if (facilityId != null && !facilityId.isEmpty()) {
                // get selected facility
                Facility selectedFacility = 
                        facilityDAO.find(Integer.parseInt(facilityId));
                // place selected category in session scope
                session.setAttribute("selectedFacility", selectedFacility);
            }
        }
        else if (userPath.equals("/register")) {
            /*
             * just redirect user to register.jsp
             */
        }
        else if (userPath.equals("/login")){
            /*
             * Just redirect user to index
             */
            response.sendRedirect("index");
            return;
        }
        else if (userPath.equals("/logout")){
            /*
             * clear the session variable & redirect to index.jsp
             */
            session.removeAttribute("customer");
            response.sendRedirect("index");
            return;
        }
        
        // use RequestDispatcher to forward request
       String url =  "jsp" + userPath + ".jsp";
       System.out.println(url);
        try 
        {
            request.getRequestDispatcher(url).forward(request, response);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(ControllerServlet.class.getName()).log(
                    Level.SEVERE, null, ex);
        }        

    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
