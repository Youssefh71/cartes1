/**
 * UserManagementService.java
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.geomod.components.cmdecarte.primar.UserManagementService;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface UserManagementService extends Remote {
    public String getUserFullName(String username) throws RemoteException;
    public Integer[] getVesselsForUser(String username) throws RemoteException;
    public String[] getUsersForVessel(Integer vesselId) throws RemoteException;
    public void setUserPassword(String username, String password) throws RemoteException;
    public void setUserFullName(String username, String name) throws RemoteException;
    public void addUserToVessel(String username, Integer vesselId) throws RemoteException;
    public void removeUserFromVessel(String username, Integer vesselId) throws RemoteException;
    public void createUser(String username, String name, String password) throws RemoteException;
}
