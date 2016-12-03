package guru.springframework.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jt on 12/3/16.
 */
@Component
public class CustomGuruEndpoint extends AbstractEndpoint<List<String>> {

    public CustomGuruEndpoint() {
        //id (path) / is sensitive
        super("customGuruEndpoint", false);
    }

    @Override
    public List<String> invoke() {

        List<String> list = new ArrayList<>(3);
        list.add("Umphrey's");
        list.add("McGee");
        list.add("Zonkey rocks!");
        return list;
    }
}
