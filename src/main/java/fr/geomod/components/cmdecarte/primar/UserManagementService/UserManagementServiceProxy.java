package fr.geomod.components.cmdecarte.primar.UserManagementService;

import org.apache.axis.client.Stub;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;


public class UserManagementServiceProxy implements UserManagementService {
  private String _endpoint = null;
  private UserManagementService userManagementService = null;
  
  public UserManagementServiceProxy() {
    _initUserManagementServiceProxy();
  }
  
  public UserManagementServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initUserManagementServiceProxy();
  }
  
  private void _initUserManagementServiceProxy() {
    try {
      userManagementService = (new UserManagementServiceServiceLocator()).getUserManagementService();
      if (userManagementService != null) {
        if (_endpoint != null)
          ((Stub)userManagementService)._setProperty("service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((Stub)userManagementService)._getProperty("service.endpoint.address");
      }

    }
    catch (ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (userManagementService != null)
      ((Stub)userManagementService)._setProperty("service.endpoint.address", _endpoint);
    
  }
  
  public UserManagementService getUserManagementService() {
    if (userManagementService == null)
      _initUserManagementServiceProxy();
    return userManagementService;
  }
  
  public String getUserFullName(String username) throws RemoteException {
    if (userManagementService == null)
      _initUserManagementServiceProxy();
    return userManagementService.getUserFullName(username);
  }
  
  public Integer[] getVesselsForUser(String username) throws RemoteException{
    if (userManagementService == null)
      _initUserManagementServiceProxy();
    return userManagementService.getVesselsForUser(username);
  }
  
  public String[] getUsersForVessel(Integer vesselId) throws RemoteException{
    if (userManagementService == null)
      _initUserManagementServiceProxy();
    return userManagementService.getUsersForVessel(vesselId);
  }
  
  public void setUserPassword(String username, String password) throws RemoteException{
    if (userManagementService == null)
      _initUserManagementServiceProxy();
    userManagementService.setUserPassword(username, password);
  }
  
  public void setUserFullName(String username, String name) throws RemoteException{
    if (userManagementService == null)
      _initUserManagementServiceProxy();
    userManagementService.setUserFullName(username, name);
  }
  
  public void addUserToVessel(String username, Integer vesselId) throws RemoteException{
    if (userManagementService == null)
      _initUserManagementServiceProxy();
    userManagementService.addUserToVessel(username, vesselId);
  }
  
  public void removeUserFromVessel(String username, Integer vesselId) throws RemoteException{
    if (userManagementService == null)
      _initUserManagementServiceProxy();
    userManagementService.removeUserFromVessel(username, vesselId);
  }
  
  public void createUser(String username, String name, String password) throws RemoteException{
    if (userManagementService == null)
      _initUserManagementServiceProxy();
    userManagementService.createUser(username, name, password);
  }
  
  
}