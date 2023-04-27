/**
 * UserManagementServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.geomod.components.cmdecarte.primar.UserManagementService;

import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import java.net.URL;

public interface UserManagementServiceService extends Service {
    public String getUserManagementServiceAddress();

    public UserManagementService getUserManagementService() throws ServiceException;

    public UserManagementService getUserManagementService(URL portAddress) throws ServiceException;
}
