/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoangnd
 */
@WebServlet(name = "Sender", urlPatterns = {"/Sender"})
public class Sender extends HttpServlet {
    
    private InitialContext initialContext;
    QueueConnectionFactory queueConnectionFactory;
    private QueueConnection queueConnection;
    private QueueSession queueSession;
    private Queue queue;
    private QueueSender queueSender;
    private TextMessage textMessage;    
    
    private void initTextMessage() {
        try {
            initialContext = new InitialContext();
            queueConnectionFactory=(QueueConnectionFactory)initialContext.lookup("myQueueConnectionFactory"); 
            queueConnection = queueConnectionFactory.createQueueConnection();
            queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
            queue=(Queue)initialContext.lookup("jms/MyQueue");  
            queueSender = queueSession.createSender(queue); 
            textMessage = queueSession.createTextMessage();  
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();            
            initTextMessage();
            String message = request.getParameter("message");            
            textMessage.setText(message);
            out.println("<h2>Send message: "+textMessage.toString()+"</h2>");
            queueSender.send(textMessage);
        } catch(Exception e) {
            e.printStackTrace();
        }               
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
