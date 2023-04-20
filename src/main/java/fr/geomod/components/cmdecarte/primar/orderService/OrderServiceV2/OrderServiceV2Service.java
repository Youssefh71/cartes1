/**
 * OrderServiceV2Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.geomod.components.cmdecarte.primar.orderService.OrderServiceV2;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public interface OrderServiceV2Service extends Service {
    public String getOrderServiceV2Address();

    public OrderServiceV2 getOrderServiceV2() throws ServiceException;

    public OrderServiceV2 getOrderServiceV2(java.net.URL portAddress) throws ServiceException;
}
