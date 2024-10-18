package com.gowri.Util;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQConnectionFactoryCustomizer;
import org.springframework.stereotype.Component;
/*
 * @author NaveenWodeyar
 * @date 18-10-2024
 */

@Component
public class MessageSenderUtil {
    private String brokerUrl;
    private String queueName;

    // Constructor
    public MessageSenderUtil(String brokerUrl, String queueName) {
        this.brokerUrl = brokerUrl;
        this.queueName = queueName;
    }

    public void sendMessage(String messageText) {
        Connection connection = null;
        Session session = null;
        try {
            // Create a connection factory
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactoryCustomizer(brokerUrl);

            // Create a connection
            connection = connectionFactory.createConnection();
            connection.start();

            // Create a session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (queue)
            Destination destination = session.createQueue(queueName);

            // Create a message producer
            MessageProducer producer = session.createProducer(destination);

            // Create a text message
            TextMessage message = session.createTextMessage(messageText);

            // Send the message
            producer.send(message);
            System.out.println("Message sent successfully!");

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            // Clean up
            try {
                if (session != null) session.close();
                if (connection != null) connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
