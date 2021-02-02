/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abidjan.experiment;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abidjan.experiment.User;
import java.util.Arrays;
import java.util.ArrayList;
import java.awt.List;
import java.io.FileWriter;
import java.io.*;
/**
 *
 * @author gnana
 */
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
@WebServlet(name = "EtudiantsServlet", urlPatterns = {"/etudiants"})
public class EtudiantsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {            
            /* TODO output your page here. You may use following sample code. */
           
            
           
            

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EtudiantsServlet</title>");            
            out.println("</head>");
            out.println("<body>");           
               
            out.println("<table style='border: 1px solid'>");   
            out.println("<tr>");
            out.println("<th style='padding: 20px'>Gnanago Aimé Brice César</th>");
            out.println("<th style='padding: 20px'>https://github.com/Bricegnanago/TP01_GNANAGO_AIME_BRICE_CESAR.git</th>");
            out.println("<tr>");
            out.println("</tr>"); 
            out.println("</table>"); 
            //out.println("<form style='padding: 100px; max-width: 700%;  border:1px solid; position: absolute; left: 50%;top: 50%;transform: translate(-50%, -50%);' >");
            out.println("<form style='padding: 50px; max-width: 300px; margin: 30px auto;  postition: relative;background-color: #f4f4f4; box-shadow: 1px 4px 6px rgba(0,0,0,0.2); border-radius: 5px' method='POST' action='' >");
                out.println("<h2 style='text-align:center'>Enregistrer un etudiant</h2>");
                out.println("<div style='margin: 15px auto; text-align: center;'  >");                
                    out.println("<input name='last_name' style=' padding: 12px 14px' placeholder='Nom' type='text'/>");
                out.println("</div>");
                out.println("<div style='margin: 15px auto; text-align: center;'  >");
                    out.println("<input name='first_name' type='text' style='padding: 12px 14px' placeholder='Prénom'/>");
                out.println("</div>");
                out.println("<div style='margin: 15px auto; text-align: center;'  >");                
                    out.println("<input name='email' type='email' style='padding: 12px 14px' placeholder='Email'/>");
                out.println("</div>");
                /*out.println("<span class='error'>+${error}</span>");*/
                out.println("<div style='margin: 15px auto; text-align: center;'  >");                
                    out.println("<input name='submit' type='submit' value='Enregistrer' style='padding: 12px 30px;border-style:none; color:white; background-color:#0275d8'/>");
                out.println("</div>");
            out.println("<form>");
            
    // create BufferedReader and read data from csv

                 
        
             
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        user.setFirstName(request.getParameter("first_name")); 
        user.setLastName(request.getParameter("last_name"));
        user.setEmail(request.getParameter("email"));
            
 

        FileWriter csvWriter = new FileWriter("C:/Users/gnana/Documents/NetBeansProjects/TP01_GNANAGO_AIME_BRICE_CESAR/etudiants.csv");        
        csvWriter.append(String.join(",", Arrays.asList(user.getFirstName(), user.getLastName(), user.getEmail())));
        csvWriter.append("\n");


        csvWriter.flush();
        csvWriter.close();
        
/*  if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("home");
        }
        else {
            request.setAttribute("error", "Unknown user, please try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
*/
    }
    
    public void writtingInCSV(User user){
       /* FileWriter csvWriter = new FileWriter("etudiant.csv");
        csvWriter.append("Name");
        csvWriter.append(",");
        csvWriter.append("Prénom");
        csvWriter.append(",");
        csvWriter.append("Email");
        csvWriter.append("\n");
        List<String> rowData =  Arrays.asList("Jean", "author", "Java");


    csvWriter.append(String.join(",", rowData));
    csvWriter.append("\n");

csvWriter.flush();
csvWriter.close();
        */
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
