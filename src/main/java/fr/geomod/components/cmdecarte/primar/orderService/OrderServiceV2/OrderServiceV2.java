/**
 * OrderServiceV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.geomod.components.cmdecarte.primar.orderService.OrderServiceV2;

import fr.geomod.components.cmdecarte.primar.orderService.BeanService.OrderReport;
import fr.geomod.components.cmdecarte.primar.orderService.BeanService.OrderRequest;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OrderServiceV2 extends Remote {
    public boolean updateOrderReportDistMargin(Integer orderId, BigDecimal percent) throws RemoteException;
    public int placeOrderSENC(OrderRequest orderRequest) throws RemoteException;
    public boolean activateOrderAndSendPermitsByMail(Integer orderId) throws RemoteException;
    public boolean activateOrderAndSendPermitsByMailForYearAndWeek(Integer orderId, int year, int week) throws RemoteException;
    public int placeOrder(OrderRequest orderRequest) throws RemoteException;
    public boolean activateOrder(Integer orderId) throws RemoteException;
    public boolean cancelOrder(Integer orderId) throws RemoteException;
    public OrderReport getOrderReport(Integer orderId) throws RemoteException;
    public boolean getIsQuotation(Integer orderId) throws RemoteException;
}
