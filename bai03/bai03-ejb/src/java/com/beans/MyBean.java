/*
 Message Driven Bean

 */
package com.beans;

import java.util.logging.*;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MyQueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MyBean implements MessageListener {
    
    public MyBean() {
        
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage)message;
            System.out.println("message = "+textMessage.getText());
        } catch(JMSException e) {
            Logger.getLogger(MyBean.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
