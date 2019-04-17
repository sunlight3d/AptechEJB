/**

 */
import javax.jms.*;
public class MyListener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage)message;
            System.out.println("Message is received:" + textMessage.getText());
        } catch (JMSException e) {
            System.out.println(e);
        }
    }
       
}
