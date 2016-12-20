package guru.springframework.actuator.endpoints;


import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 12/19/16.
 */
@Component
public class MyCustomMvcEndpoint extends EndpointMvcAdapter {

    public MyCustomMvcEndpoint(MyCustomEndpoint delegate) {
        super(delegate);
    }
}
