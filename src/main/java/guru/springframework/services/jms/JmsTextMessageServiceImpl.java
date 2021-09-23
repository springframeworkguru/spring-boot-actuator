package guru.springframework.services.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

/**
 * Created by jt on 5/6/16.
 */
@Service
public class JmsTextMessageServiceImpl implements JmsTextMessageService {

    private Queue textMessageQueue;
    private JmsTemplate jmsTemplate;

    public JmsTextMessageServiceImpl(Queue textMessageQueue, JmsTemplate jmsTemplate) {
        this.textMessageQueue = textMessageQueue;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendTextMessage(String msg) {
        this.jmsTemplate.convertAndSend(this.textMessageQueue, msg);
    }
}
