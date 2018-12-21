package fr.nmocs.library.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.nmocs.library.model.Loan;
import fr.nmocs.library.webservice.error.WebserviceException;

@WebService(name = "LoanService", serviceName = "LoanService")
public interface LoanService {

	Loan createLoan(@WebParam(name = "loan") Loan loan) throws WebserviceException;

	Loan updateLoan(@WebParam(name = "loan") Loan loan) throws WebserviceException;

	Loan findLoanById(@WebParam(name = "id") Integer id);

	List<Loan> findByUserId(@WebParam(name = "userId") Integer userId);

	List<Loan> findNotReturned();
}