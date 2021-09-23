package guru.springframework.services.jms;

import guru.springframework.config.JMSConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/6/16.
 */
@Component
public class JmsTextMessageListener {

    @JmsListener(destination = JMSConfig.textMsgQueue)
    public void onMessage(String msg){
        System.out.println("#### " + msg + " ###" );
    }
}
