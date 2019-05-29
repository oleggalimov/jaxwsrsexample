//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.oleggalimov.jaxwsexample.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "WSName") //переопределяет адрес сервиса
public class JaxWSService {
    public JaxWSService() {
    }
    @WebMethod(operationName = "TestOperationName"
    )
    public String testJaxWS() {
        return "This is WS!";
    }
}
