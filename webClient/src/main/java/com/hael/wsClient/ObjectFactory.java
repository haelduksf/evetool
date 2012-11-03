
package com.hael.wsClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hael.wsClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SystemNameLookup_QNAME = new QName("http://evetool.hael.com/", "systemNameLookup");
    private final static QName _GetPcKillsForResponse_QNAME = new QName("http://evetool.hael.com/", "getPcKillsForResponse");
    private final static QName _ShortestRoute_QNAME = new QName("http://evetool.hael.com/", "shortestRoute");
    private final static QName _ShortestRouteResponse_QNAME = new QName("http://evetool.hael.com/", "shortestRouteResponse");
    private final static QName _GetJumpsForResponse_QNAME = new QName("http://evetool.hael.com/", "getJumpsForResponse");
    private final static QName _SystemNameLookupResponse_QNAME = new QName("http://evetool.hael.com/", "systemNameLookupResponse");
    private final static QName _GetSystemResponse_QNAME = new QName("http://evetool.hael.com/", "getSystemResponse");
    private final static QName _GetNpcKillsForResponse_QNAME = new QName("http://evetool.hael.com/", "getNpcKillsForResponse");
    private final static QName _GetNpcKillsFor_QNAME = new QName("http://evetool.hael.com/", "getNpcKillsFor");
    private final static QName _NotEnoughArguments_QNAME = new QName("http://evetool.hael.com/", "NotEnoughArguments");
    private final static QName _GetJumpsFor_QNAME = new QName("http://evetool.hael.com/", "getJumpsFor");
    private final static QName _GetPcKillsFor_QNAME = new QName("http://evetool.hael.com/", "getPcKillsFor");
    private final static QName _NotARealSolarSystem_QNAME = new QName("http://evetool.hael.com/", "NotARealSolarSystem");
    private final static QName _NoPathExistsException_QNAME = new QName("http://evetool.hael.com/", "NoPathExistsException");
    private final static QName _IOException_QNAME = new QName("http://evetool.hael.com/", "IOException");
    private final static QName _GetSystem_QNAME = new QName("http://evetool.hael.com/", "getSystem");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hael.wsClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetJumpsFor }
     * 
     */
    public GetJumpsFor createGetJumpsFor() {
        return new GetJumpsFor();
    }

    /**
     * Create an instance of {@link GetPcKillsFor }
     * 
     */
    public GetPcKillsFor createGetPcKillsFor() {
        return new GetPcKillsFor();
    }

    /**
     * Create an instance of {@link NoPathExistsException }
     * 
     */
    public NoPathExistsException createNoPathExistsException() {
        return new NoPathExistsException();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link GetSystem }
     * 
     */
    public GetSystem createGetSystem() {
        return new GetSystem();
    }

    /**
     * Create an instance of {@link NotARealSolarSystem }
     * 
     */
    public NotARealSolarSystem createNotARealSolarSystem() {
        return new NotARealSolarSystem();
    }

    /**
     * Create an instance of {@link GetNpcKillsForResponse }
     * 
     */
    public GetNpcKillsForResponse createGetNpcKillsForResponse() {
        return new GetNpcKillsForResponse();
    }

    /**
     * Create an instance of {@link NotEnoughArguments }
     * 
     */
    public NotEnoughArguments createNotEnoughArguments() {
        return new NotEnoughArguments();
    }

    /**
     * Create an instance of {@link GetNpcKillsFor }
     * 
     */
    public GetNpcKillsFor createGetNpcKillsFor() {
        return new GetNpcKillsFor();
    }

    /**
     * Create an instance of {@link GetJumpsForResponse }
     * 
     */
    public GetJumpsForResponse createGetJumpsForResponse() {
        return new GetJumpsForResponse();
    }

    /**
     * Create an instance of {@link SystemNameLookupResponse }
     * 
     */
    public SystemNameLookupResponse createSystemNameLookupResponse() {
        return new SystemNameLookupResponse();
    }

    /**
     * Create an instance of {@link GetSystemResponse }
     * 
     */
    public GetSystemResponse createGetSystemResponse() {
        return new GetSystemResponse();
    }

    /**
     * Create an instance of {@link SystemNameLookup }
     * 
     */
    public SystemNameLookup createSystemNameLookup() {
        return new SystemNameLookup();
    }

    /**
     * Create an instance of {@link GetPcKillsForResponse }
     * 
     */
    public GetPcKillsForResponse createGetPcKillsForResponse() {
        return new GetPcKillsForResponse();
    }

    /**
     * Create an instance of {@link ShortestRouteResponse }
     * 
     */
    public ShortestRouteResponse createShortestRouteResponse() {
        return new ShortestRouteResponse();
    }

    /**
     * Create an instance of {@link ShortestRoute }
     * 
     */
    public ShortestRoute createShortestRoute() {
        return new ShortestRoute();
    }

    /**
     * Create an instance of {@link MapSolarSystemNpcKillLog }
     * 
     */
    public MapSolarSystemNpcKillLog createMapSolarSystemNpcKillLog() {
        return new MapSolarSystemNpcKillLog();
    }

    /**
     * Create an instance of {@link MapSolarSystemJumpLog }
     * 
     */
    public MapSolarSystemJumpLog createMapSolarSystemJumpLog() {
        return new MapSolarSystemJumpLog();
    }

    /**
     * Create an instance of {@link SolarSystem }
     * 
     */
    public SolarSystem createSolarSystem() {
        return new SolarSystem();
    }

    /**
     * Create an instance of {@link MapSolarSystemPcKillLog }
     * 
     */
    public MapSolarSystemPcKillLog createMapSolarSystemPcKillLog() {
        return new MapSolarSystemPcKillLog();
    }

    /**
     * Create an instance of {@link ActivityLogPK }
     * 
     */
    public ActivityLogPK createActivityLogPK() {
        return new ActivityLogPK();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemNameLookup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "systemNameLookup")
    public JAXBElement<SystemNameLookup> createSystemNameLookup(SystemNameLookup value) {
        return new JAXBElement<SystemNameLookup>(_SystemNameLookup_QNAME, SystemNameLookup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPcKillsForResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "getPcKillsForResponse")
    public JAXBElement<GetPcKillsForResponse> createGetPcKillsForResponse(GetPcKillsForResponse value) {
        return new JAXBElement<GetPcKillsForResponse>(_GetPcKillsForResponse_QNAME, GetPcKillsForResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShortestRoute }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "shortestRoute")
    public JAXBElement<ShortestRoute> createShortestRoute(ShortestRoute value) {
        return new JAXBElement<ShortestRoute>(_ShortestRoute_QNAME, ShortestRoute.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShortestRouteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "shortestRouteResponse")
    public JAXBElement<ShortestRouteResponse> createShortestRouteResponse(ShortestRouteResponse value) {
        return new JAXBElement<ShortestRouteResponse>(_ShortestRouteResponse_QNAME, ShortestRouteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJumpsForResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "getJumpsForResponse")
    public JAXBElement<GetJumpsForResponse> createGetJumpsForResponse(GetJumpsForResponse value) {
        return new JAXBElement<GetJumpsForResponse>(_GetJumpsForResponse_QNAME, GetJumpsForResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemNameLookupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "systemNameLookupResponse")
    public JAXBElement<SystemNameLookupResponse> createSystemNameLookupResponse(SystemNameLookupResponse value) {
        return new JAXBElement<SystemNameLookupResponse>(_SystemNameLookupResponse_QNAME, SystemNameLookupResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSystemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "getSystemResponse")
    public JAXBElement<GetSystemResponse> createGetSystemResponse(GetSystemResponse value) {
        return new JAXBElement<GetSystemResponse>(_GetSystemResponse_QNAME, GetSystemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNpcKillsForResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "getNpcKillsForResponse")
    public JAXBElement<GetNpcKillsForResponse> createGetNpcKillsForResponse(GetNpcKillsForResponse value) {
        return new JAXBElement<GetNpcKillsForResponse>(_GetNpcKillsForResponse_QNAME, GetNpcKillsForResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNpcKillsFor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "getNpcKillsFor")
    public JAXBElement<GetNpcKillsFor> createGetNpcKillsFor(GetNpcKillsFor value) {
        return new JAXBElement<GetNpcKillsFor>(_GetNpcKillsFor_QNAME, GetNpcKillsFor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotEnoughArguments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "NotEnoughArguments")
    public JAXBElement<NotEnoughArguments> createNotEnoughArguments(NotEnoughArguments value) {
        return new JAXBElement<NotEnoughArguments>(_NotEnoughArguments_QNAME, NotEnoughArguments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJumpsFor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "getJumpsFor")
    public JAXBElement<GetJumpsFor> createGetJumpsFor(GetJumpsFor value) {
        return new JAXBElement<GetJumpsFor>(_GetJumpsFor_QNAME, GetJumpsFor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPcKillsFor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "getPcKillsFor")
    public JAXBElement<GetPcKillsFor> createGetPcKillsFor(GetPcKillsFor value) {
        return new JAXBElement<GetPcKillsFor>(_GetPcKillsFor_QNAME, GetPcKillsFor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotARealSolarSystem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "NotARealSolarSystem")
    public JAXBElement<NotARealSolarSystem> createNotARealSolarSystem(NotARealSolarSystem value) {
        return new JAXBElement<NotARealSolarSystem>(_NotARealSolarSystem_QNAME, NotARealSolarSystem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoPathExistsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "NoPathExistsException")
    public JAXBElement<NoPathExistsException> createNoPathExistsException(NoPathExistsException value) {
        return new JAXBElement<NoPathExistsException>(_NoPathExistsException_QNAME, NoPathExistsException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSystem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://evetool.hael.com/", name = "getSystem")
    public JAXBElement<GetSystem> createGetSystem(GetSystem value) {
        return new JAXBElement<GetSystem>(_GetSystem_QNAME, GetSystem.class, null, value);
    }

}
