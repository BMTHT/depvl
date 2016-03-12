/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmth.controller;

import com.bmth.DAO.AccountDAO;
import com.bmth.DAO.UserDAO;
import com.bmth.bean.Account;
import com.bmth.bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author quangbach
 */
public class RegisterServlet extends HttpServlet {

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
        String url = "/dangnhap.html";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword =  request.getParameter("confirmPassword");
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String date = (String)request.getParameter("date");
        String gender = request.getParameter("gender");
        User user = new User();
        Account account = new Account();
        String [] d = date.split("-");
        Date birthday;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(d[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(d[1])-1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(d[2]));
        birthday = cal.getTime();
        AccountDAO ac = new AccountDAO();
        UserDAO us = new UserDAO();
        int sex;
        switch(gender){
            case "male": sex = 1; break;
            case "female": sex = 0; break;
            default: sex = 2; break;
        }
       boolean check1 =  us.addUser( fullName, birthday, sex, email);
       boolean check2 =  ac.addAccount(username, password);
       if(check1 && check2){
           request.setAttribute("message", "Dang ky thanh cong");
       }
       else {
           request.setAttribute("message", "Login succes");
           url = "/dangky.html";
       }
       
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        if (dispatcher != null) {
            dispatcher.forward(request, response);
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
