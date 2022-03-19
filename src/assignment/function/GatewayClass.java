/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.function;

/**
 *
 * @author howard
 */
public class GatewayClass {
    String gateway_id;
    String location;

    public GatewayClass(String gateway_id, String location) {
        this.gateway_id = gateway_id;
        this.location = location;
    }

    public String getGateway_id() {
        return gateway_id;
    }

    public void setGateway_id(String gateway_id) {
        this.gateway_id = gateway_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
