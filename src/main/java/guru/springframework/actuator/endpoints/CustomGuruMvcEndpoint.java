package guru.springframework.actuator.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 12/3/16.
 */
@Component
public class CustomGuruMvcEndpoint extends EndpointMvcAdapter {

    @Autowired
    public CustomGuruMvcEndpoint(CustomGuruEndpoint customEndpoint) {
        super(customEndpoint);
    }


}
