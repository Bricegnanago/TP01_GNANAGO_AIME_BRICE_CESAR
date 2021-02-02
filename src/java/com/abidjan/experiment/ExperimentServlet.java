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
import java.net.InetAddress;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpSession;



/**
 *
 * @author gnana
 */
@WebServlet(name = "ExperimentServlet", urlPatterns = {"/experiment"})
public class ExperimentServlet extends HttpServlet {

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
            String  browserDetails  =   request.getHeader("User-Agent");
            /* TODO output your page here. You may use following sample code. */
             
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExperimentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style='text-align: center'> Ma première servlet </h1>");
            
            out.println("<h2>Information concernant l'adresse IP et le navigateur utilisé par le client:</h2>");            
            out.println("<p><Strong><u>Adresse IP du client: </u></Strong>" + request.getRemoteAddr() +"</p>");
            out.println("<p><Strong><u>Navigateur du client: </u></Strong> " + getBrowserUsedByClient(browserDetails) +"</p>");
            
            out.println("<h2>Information concernant la requête du client:</h2>");
            out.println("<p><Strong><u>Méthode: </u></Strong> " + request.getMethod() + "</p>");
            out.println("<p><Strong><u>Protocole: </u></Strong> " + request.getProtocol()+ "</p>");
            out.println("<p><Strong><u>Uri: </u></Strong> " + request.getRequestURI() + "</p>");
            
            
            out.println("<h2>Information concernant l'entête de la requête:</h2>");
            out.println("<p><Strong><u>User Agent: </u></Strong>" + request.getHeader("User-Agent") +"</p>");
            out.println("<p><Strong><u>Host: </u></Strong>" + request.getServerName() +"</p>");
            out.println("<p><Strong><u>accept:</u></Strong> " + request.getHeader("Accept") +"</p>");
            out.println("<p><Strong><u>accept-encoding:</u></Strong> " + request.getHeader("Accept-Encoding") +"</p>");
            out.println("<p><Strong><u>accept-charset:</u></Strong> " + request.getHeader("Accept-Charset") +"</p>");
            out.println("<p><Strong><u>keep-alive:</u></Strong> " + request.getHeader("Keep-Alive") +"</p>");
            out.println("<p><Strong><u>Connexion:</u></Strong> " + request.getHeader("Connexion") +"</p>");
            out.println("</body>");
            out.println("</html>");            
        }
    }
    
    public String getBrowserUsedByClient(String browserDetails){        
        String  userAgent       =   browserDetails;
        String  user            =   userAgent.toLowerCase();

        String os = "";
        String browser = "";

       
        //=================OS=======================
         if (userAgent.toLowerCase().indexOf("windows") >= 0 )
         {
             os = "Windows";
         } else if(userAgent.toLowerCase().indexOf("mac") >= 0)
         {
             os = "Mac";
         } else if(userAgent.toLowerCase().indexOf("x11") >= 0)
         {
             os = "Unix";
         } else if(userAgent.toLowerCase().indexOf("android") >= 0)
         {
             os = "Android";
         } else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
         {
             os = "IPhone";
         }else{
             os = "UnKnown, More-Info: "+userAgent;
         }
         //===============Browser===========================
        if (user.contains("msie"))
        {
            String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
            browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
        } else if (user.contains("safari") && user.contains("version"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else if ( user.contains("opr") || user.contains("opera"))
        {
            if(user.contains("opera"))
                browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
            else if(user.contains("opr"))
                browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
        } else if (user.contains("chrome"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
        {
            //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
            browser = "Netscape-?";

        } else if (user.contains("firefox"))
        {
            browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        } else if(user.contains("rv"))
        {
            browser="IE-" + user.substring(user.indexOf("rv") + 3, user.indexOf(")"));
        } else
        {
            browser = "UnKnown, More-Info: "+userAgent;
        }        
        return browser;
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
        processRequest(request, response);
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
