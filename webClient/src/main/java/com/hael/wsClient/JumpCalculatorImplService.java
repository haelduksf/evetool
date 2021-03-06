package com.hael.wsClient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2012-11-03T12:11:27.828-04:00
 * Generated source version: 2.7.0
 * 
 */
@WebServiceClient(name = "JumpCalculatorImplService", 
                  wsdlLocation = "http://localhost:8080/web/JumpCalculator?wsdl",
                  targetNamespace = "http://evetool.hael.com/") 
public class JumpCalculatorImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://evetool.hael.com/", "JumpCalculatorImplService");
    public final static QName JumpCalculatorImplPort = new QName("http://evetool.hael.com/", "JumpCalculatorImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/web/JumpCalculator?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(JumpCalculatorImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/web/JumpCalculator?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public JumpCalculatorImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public JumpCalculatorImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public JumpCalculatorImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public JumpCalculatorImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public JumpCalculatorImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public JumpCalculatorImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns JumpCalculator
     */
    @WebEndpoint(name = "JumpCalculatorImplPort")
    public JumpCalculator getJumpCalculatorImplPort() {
        return super.getPort(JumpCalculatorImplPort, JumpCalculator.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns JumpCalculator
     */
    @WebEndpoint(name = "JumpCalculatorImplPort")
    public JumpCalculator getJumpCalculatorImplPort(WebServiceFeature... features) {
        return super.getPort(JumpCalculatorImplPort, JumpCalculator.class, features);
    }

}
