
package fr.nmocs.library.webapp.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1-SNAPSHOT
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserService", targetNamespace = "http://webservice.library.nmocs.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserService {


    /**
     * 
     * @param parameters
     * @param token
     * @return
     *     returns fr.nmocs.library.webapp.webservice.FindByIdResponse
     * @throws LibraryWebserviceException_Exception
     */
    @WebMethod
    @WebResult(name = "findByIdResponse", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public FindByIdResponse findById(
        @WebParam(name = "findById", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
        FindById parameters,
        @WebParam(name = "token", targetNamespace = "http://webservice.library.nmocs.fr/", header = true, partName = "token")
        String token)
        throws LibraryWebserviceException_Exception
    ;

    /**
     * 
     * @param parameters
     * @param token
     * @return
     *     returns fr.nmocs.library.webapp.webservice.DowngradeAdminToBasicUserResponse
     * @throws LibraryWebserviceException_Exception
     */
    @WebMethod
    @WebResult(name = "downgradeAdminToBasicUserResponse", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public DowngradeAdminToBasicUserResponse downgradeAdminToBasicUser(
        @WebParam(name = "downgradeAdminToBasicUser", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
        DowngradeAdminToBasicUser parameters,
        @WebParam(name = "token", targetNamespace = "http://webservice.library.nmocs.fr/", header = true, partName = "token")
        String token)
        throws LibraryWebserviceException_Exception
    ;

    /**
     * 
     * @param parameters
     * @param token
     * @return
     *     returns fr.nmocs.library.webapp.webservice.FindByEmailResponse
     * @throws LibraryWebserviceException_Exception
     */
    @WebMethod
    @WebResult(name = "findByEmailResponse", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public FindByEmailResponse findByEmail(
        @WebParam(name = "findByEmail", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
        FindByEmail parameters,
        @WebParam(name = "token", targetNamespace = "http://webservice.library.nmocs.fr/", header = true, partName = "token")
        String token)
        throws LibraryWebserviceException_Exception
    ;

    /**
     * 
     * @param user
     * @return
     *     returns fr.nmocs.library.webapp.webservice.User
     * @throws LibraryWebserviceException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createUser", targetNamespace = "http://webservice.library.nmocs.fr/", className = "fr.nmocs.library.webapp.webservice.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://webservice.library.nmocs.fr/", className = "fr.nmocs.library.webapp.webservice.CreateUserResponse")
    public User createUser(
        @WebParam(name = "user", targetNamespace = "")
        User user)
        throws LibraryWebserviceException_Exception
    ;

    /**
     * 
     * @param parameters
     * @param token
     * @return
     *     returns fr.nmocs.library.webapp.webservice.FindByNameResponse
     * @throws LibraryWebserviceException_Exception
     */
    @WebMethod
    @WebResult(name = "findByNameResponse", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public FindByNameResponse findByName(
        @WebParam(name = "findByName", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
        FindByName parameters,
        @WebParam(name = "token", targetNamespace = "http://webservice.library.nmocs.fr/", header = true, partName = "token")
        String token)
        throws LibraryWebserviceException_Exception
    ;

    /**
     * 
     * @param parameters
     * @param token
     * @return
     *     returns fr.nmocs.library.webapp.webservice.GrantAdminRightsToUserResponse
     * @throws LibraryWebserviceException_Exception
     */
    @WebMethod
    @WebResult(name = "grantAdminRightsToUserResponse", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public GrantAdminRightsToUserResponse grantAdminRightsToUser(
        @WebParam(name = "grantAdminRightsToUser", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
        GrantAdminRightsToUser parameters,
        @WebParam(name = "token", targetNamespace = "http://webservice.library.nmocs.fr/", header = true, partName = "token")
        String token)
        throws LibraryWebserviceException_Exception
    ;

    /**
     * 
     * @param parameters
     * @param token
     * @return
     *     returns fr.nmocs.library.webapp.webservice.UpdateUserResponse
     * @throws LibraryWebserviceException_Exception
     */
    @WebMethod
    @WebResult(name = "updateUserResponse", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public UpdateUserResponse updateUser(
        @WebParam(name = "updateUser", targetNamespace = "http://webservice.library.nmocs.fr/", partName = "parameters")
        UpdateUser parameters,
        @WebParam(name = "token", targetNamespace = "http://webservice.library.nmocs.fr/", header = true, partName = "token")
        String token)
        throws LibraryWebserviceException_Exception
    ;

}
