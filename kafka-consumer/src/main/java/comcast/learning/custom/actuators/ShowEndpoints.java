/*package comcast.learning.custom.actuators;

import org.springframework.stereotype.Component;

import org.springframework.boot.actuate.endpoint.*;

import org.springframework.boot.actuate.endpoint.AbstractEndpoint;



@Component
public class ShowEndpoints extends AbstractEndpoint<List<Endpoint>>{

    private List<Endpoint> endpoints;

    @Autowired
    public ShowEndpoints(List<Endpoint> endpoints) {
        super("showEndpoints");
        this.endpoints = endpoints;
    }

    public List<Endpoint> invoke() {
        return this.endpoints;
    }
}*/