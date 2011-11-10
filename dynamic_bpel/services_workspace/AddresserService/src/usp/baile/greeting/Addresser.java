package usp.baile.greeting;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Addresser {
	
	@WebMethod
	String getServiceEndpoint();
	
	@WebMethod
	void setLanguage(String language);

}