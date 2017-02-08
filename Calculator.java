/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author patel
 */
@WebServlet(urlPatterns = {"/Calculator"})
public class Calculator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String OutputStr = "";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String select = (String) request.getParameter("select");
            if (select.equals("Calculator")) {
                String num = (String) request.getParameter("num");
                Float dobnum = Float.parseFloat(num);
                String rate = (String) request.getParameter("rate");
                Float dobrate = Float.parseFloat(rate)/1200;
                String monpay = (String) request.getParameter("monpay");
                Float dobmonpay = Float.parseFloat(monpay);
                int month = 0;
                int year =0;
                Float interset = new Float(0.0);
                        
                while(dobnum>0){
                    interset = interset + dobnum*dobrate;
                    dobnum = ( dobnum * (1 + dobrate)) - dobmonpay;
                    System.out.println("*********"+dobnum.toString());
                    month = month +1;
                    if (month == 12)
                    {
                        year ++;
                        month = 0;                                
                    }
                }
                
                OutputStr = OutputStr+"***********************************<br/>";
                OutputStr = OutputStr+"Principal Amount::"+num+"<br/>";
                OutputStr = OutputStr+"Interest Rate::"+rate+"<br/>";
                OutputStr = OutputStr+"Monthly Payment::"+monpay+"<br/>";
                OutputStr = OutputStr+"Total numbber of "+year+" and month "+month+"<br/>";
                OutputStr = OutputStr+"Total interset paid "+interset.toString()+"<br/>";
                
                
                String out1 = "Total numbber of "+year+" and month "+month;
                String out2 = "Total interset paid "+interset.toString();
                
                request.setAttribute("out1", out1);
                request.setAttribute("out2", out2);
            }
            else if(select.equals("clearall")){
                OutputStr = "0.0";
               
            }
            request.setAttribute("OutputStr", OutputStr);
            String url = "home.jsp";
            RequestDispatcher view = request.getRequestDispatcher(url);
            view.forward(request, response);
                
                      
                      
                        
                
                
                
                
            
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
