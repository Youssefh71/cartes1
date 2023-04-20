package fr.geomod.components.cmdecarte.primar.orderService.OrderServiceV2;

import fr.geomod.components.cmdecarte.primar.orderService.BeanService.OrderReport;
import fr.geomod.components.cmdecarte.primar.orderService.BeanService.OrderRequest;

import java.math.BigDecimal;
import java.rmi.RemoteException;

public class OrderServiceV2Proxy implements OrderServiceV2 {
  private String _endpoint = null;
  private OrderServiceV2 orderServiceV2 = null;
  
  public OrderServiceV2Proxy() {
    _initOrderServiceV2Proxy();
  }
  
  public OrderServiceV2Proxy(String endpoint) {
    _endpoint = endpoint;
    _initOrderServiceV2Proxy();
  }
  
  private void _initOrderServiceV2Proxy() {
    try {
      orderServiceV2 = (new OrderServiceV2ServiceLocator()).getOrderServiceV2();
      if (orderServiceV2 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)orderServiceV2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)orderServiceV2)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (orderServiceV2 != null)
      ((javax.xml.rpc.Stub)orderServiceV2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public OrderServiceV2 getOrderServiceV2() {
    if (orderServiceV2 == null)
      _initOrderServiceV2Proxy();
    return orderServiceV2;
  }
  
  public boolean updateOrderReportDistMargin(Integer orderId, BigDecimal percent) throws RemoteException {
    if (orderServiceV2 == null)
      _initOrderServiceV2Proxy();
    return orderServiceV2.updateOrderReportDistMargin(orderId, percent);
  }
  
  public int placeOrderSENC(OrderRequest orderRequest) throws RemoteException{
    if (orderServiceV2 == null)
      _initOrderServiceV2Proxy();
    return orderServiceV2.placeOrderSENC(orderRequest);
  }
  
  public boolean activateOrderAndSendPermitsByMail(Integer orderId) throws RemoteException{
    if (orderServiceV2 == null)
      _initOrderServiceV2Proxy();
    return orderServiceV2.activateOrderAndSendPermitsByMail(orderId);
  }
  
  public boolean activateOrderAndSendPermitsByMailForYearAndWeek(Integer orderId, int year, int week) throws RemoteException{
    if (orderServiceV2 == null)
      _initOrderServiceV2Proxy();
    return orderServiceV2.activateOrderAndSendPermitsByMailForYearAndWeek(orderId, year, week);
  }
  
  public int placeOrder(OrderRequest orderRequest) throws RemoteException{
    if (orderServiceV2 == null)
      _initOrderServiceV2Proxy();
    return orderServiceV2.placeOrder(orderRequest);
  }
  
  public boolean activateOrder(Integer orderId) throws RemoteException{
    if (orderServiceV2 == null)
      _initOrderServiceV2Proxy();
    return orderServiceV2.activateOrder(orderId);
  }
  
  public boolean cancelOrder(Integer orderId) throws RemoteException{
    if (orderServiceV2 == null)
      _initOrderServiceV2Proxy();
    return orderServiceV2.cancelOrder(orderId);
  }
  
  public OrderReport getOrderReport(Integer orderId) throws RemoteException{
    if (orderServiceV2 == null)
      _initOrderServiceV2Proxy();
    return orderServiceV2.getOrderReport(orderId);
  }
  
  public boolean getIsQuotation(Integer orderId) throws RemoteException{
    if (orderServiceV2 == null)
      _initOrderServiceV2Proxy();
    return orderServiceV2.getIsQuotation(orderId);
  }
  
  
}