package com.hael.wsClient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2012-11-03T12:11:27.812-04:00
 * Generated source version: 2.7.0
 * 
 */
@WebService(targetNamespace = "http://evetool.hael.com/", name = "JumpCalculator")
@XmlSeeAlso({ObjectFactory.class})
public interface JumpCalculator {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getNpcKillsFor", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.GetNpcKillsFor")
    @WebMethod
    @ResponseWrapper(localName = "getNpcKillsForResponse", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.GetNpcKillsForResponse")
    public java.util.List<com.hael.wsClient.MapSolarSystemNpcKillLog> getNpcKillsFor(
        @WebParam(name = "solarSystem", targetNamespace = "")
        com.hael.wsClient.SolarSystem solarSystem,
        @WebParam(name = "from", targetNamespace = "")
        javax.xml.datatype.XMLGregorianCalendar from,
        @WebParam(name = "to", targetNamespace = "")
        javax.xml.datatype.XMLGregorianCalendar to
    ) throws NotARealSolarSystemException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "shortestRoute", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.ShortestRoute")
    @WebMethod
    @ResponseWrapper(localName = "shortestRouteResponse", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.ShortestRouteResponse")
    public java.util.List<com.hael.wsClient.SolarSystem> shortestRoute(
        @WebParam(name = "from", targetNamespace = "")
        java.lang.String from,
        @WebParam(name = "to", targetNamespace = "")
        java.lang.String to,
        @WebParam(name = "minSecurity", targetNamespace = "")
        float minSecurity,
        @WebParam(name = "maxSecurity", targetNamespace = "")
        float maxSecurity
    ) throws NoPathExistsException_Exception, IOException_Exception, NotARealSolarSystemException, NotEnoughArgumentsException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getJumpsFor", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.GetJumpsFor")
    @WebMethod
    @ResponseWrapper(localName = "getJumpsForResponse", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.GetJumpsForResponse")
    public java.util.List<com.hael.wsClient.MapSolarSystemJumpLog> getJumpsFor(
        @WebParam(name = "solarSystem", targetNamespace = "")
        com.hael.wsClient.SolarSystem solarSystem,
        @WebParam(name = "from", targetNamespace = "")
        javax.xml.datatype.XMLGregorianCalendar from,
        @WebParam(name = "to", targetNamespace = "")
        javax.xml.datatype.XMLGregorianCalendar to
    ) throws NotARealSolarSystemException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getSystem", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.GetSystem")
    @WebMethod
    @ResponseWrapper(localName = "getSystemResponse", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.GetSystemResponse")
    public com.hael.wsClient.SolarSystem getSystem(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    ) throws IOException_Exception, NotARealSolarSystemException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "systemNameLookup", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.SystemNameLookup")
    @WebMethod
    @ResponseWrapper(localName = "systemNameLookupResponse", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.SystemNameLookupResponse")
    public java.util.List<java.lang.String> systemNameLookup(
        @WebParam(name = "string", targetNamespace = "")
        java.lang.String string
    ) throws IOException_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getPcKillsFor", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.GetPcKillsFor")
    @WebMethod
    @ResponseWrapper(localName = "getPcKillsForResponse", targetNamespace = "http://evetool.hael.com/", className = "com.hael.wsClient.GetPcKillsForResponse")
    public java.util.List<com.hael.wsClient.MapSolarSystemPcKillLog> getPcKillsFor(
        @WebParam(name = "solarSystem", targetNamespace = "")
        com.hael.wsClient.SolarSystem solarSystem,
        @WebParam(name = "from", targetNamespace = "")
        javax.xml.datatype.XMLGregorianCalendar from,
        @WebParam(name = "to", targetNamespace = "")
        javax.xml.datatype.XMLGregorianCalendar to
    ) throws NotARealSolarSystemException;
}
