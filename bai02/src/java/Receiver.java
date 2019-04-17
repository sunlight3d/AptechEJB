
import javax.jms.*;
import javax.naming.InitialContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Receiver {
    private InitialContext initialContext;
    QueueConnectionFactory queueConnectionFactory;
    private QueueConnection queueConnection;
    private QueueSession queueSession;
    private Queue queue;
    private QueueReceiver queueReceiver;
    private TextMessage textMessage; 
    public void connectAndReceiveMessages() {
        try {
            initialContext = new InitialContext();
            queueConnectionFactory=(QueueConnectionFactory)initialContext.lookup("myQueueConnectionFactory"); 
            queueConnection = queueConnectionFactory.createQueueConnection();
            queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
            queue=(Queue)initialContext.lookup("jms/MyQueue");  
            queueReceiver = queueSession.createReceiver(queue); 
            textMessage = queueSession.createTextMessage();  
            MyListener listener=new MyListener();  
            queueReceiver.setMessageListener(listener);                
            System.out.println("Receiver1 is ready, waiting for messages...");  
            System.out.println("press Ctrl+c to shutdown...");  
            while(true){                  
                Thread.sleep(1000);  
            }              
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        receiver.connectAndReceiveMessages();
    }
}
