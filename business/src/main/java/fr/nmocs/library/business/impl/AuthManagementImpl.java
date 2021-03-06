package fr.nmocs.library.business.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import fr.nmocs.library.business.AuthManagement;
import fr.nmocs.library.business.UserManagement;
import fr.nmocs.library.model.Admin;
import fr.nmocs.library.model.User;
import fr.nmocs.library.model.constants.UserStatus;
import fr.nmocs.library.model.error.ErrorCode;
import fr.nmocs.library.model.error.LibraryBusinessException;
import fr.nmocs.library.model.error.LibraryException;
import fr.nmocs.library.model.error.LibraryTechnicalException;

@Service
public class AuthManagementImpl implements AuthManagement {

	// ===== CONSTANTS
	private static final Integer HOUR_DURATION = 6;

	private static final String SECRET_KEY = "{7w,}]X.CgknjL6qD&ryBE+zjkyA";

	private static final String ISSUER = "Library";

	private static final String USER_KEY = "user";

	private static final String ADMIN_KEY = "isAdmin";

	private static final Algorithm ALGO = Algorithm.HMAC256(SECRET_KEY);

	// ===== DEPENDENCIES

	@Autowired
	private UserManagement userMgmt;

	// ===== MAIN METHODS
	/**
	 * 
	 * @param userEmail
	 * @param userPassword
	 * @return
	 * @throws LibraryException
	 */
	@Override
	public String getToken(String userEmail, String userPassword) throws LibraryException {
		User user;

		try {
			user = userMgmt.findByEmail(userEmail);
		} catch (LibraryTechnicalException e) {
			user = null;
		}

		if (user == null || !StringUtils.equals(user.getPassword(), userPassword)) {
			throw new LibraryBusinessException(ErrorCode.PASSWORD_DOESNT_MATCH);
		}
		if (!StringUtils.equals(user.getStatus(), UserStatus.ACTIVE.getValue())) {
			throw new LibraryBusinessException(ErrorCode.USER_NOT_ACTIVE);
		}

		return JWT.create().withIssuer(ISSUER).withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + (HOUR_DURATION * 3600 * 1000)))
				.withSubject(user.getId().toString())
				.withClaim(USER_KEY, user.getFirstName() + " " + user.getLastName())
				.withClaim(ADMIN_KEY, user instanceof Admin).sign(ALGO);
	}

	/**
	 * 
	 * @param token
	 * @throws LibraryBusinessException
	 */
	@Override
	public void verifyToken(String token) throws LibraryBusinessException {
		try {
			JWT.require(ALGO).withIssuer(ISSUER).build().verify(token);
		} catch (JWTVerificationException e) {
			throw new LibraryBusinessException(ErrorCode.TOKEN_NOT_VALID);
		}
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	@Override
	public User getUser(String token) {
		try {
			verifyToken(token);
			DecodedJWT jwt = JWT.decode(token);
			return userMgmt.findById(Integer.parseInt(jwt.getSubject()));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	public Integer getUserId(String token) {
		try {
			verifyToken(token);
			DecodedJWT jwt = JWT.decode(token);
			return Integer.parseInt(jwt.getSubject());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	@Override
	public Boolean isAdmin(String token) {
		User user = getUser(token);
		return user != null && user instanceof Admin;
	}

}
