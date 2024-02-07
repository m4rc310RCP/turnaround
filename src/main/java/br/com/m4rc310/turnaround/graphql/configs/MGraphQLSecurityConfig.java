package br.com.m4rc310.turnaround.graphql.configs;

import org.springframework.context.annotation.Configuration;

import br.com.m4rc310.gql.dto.MAuthToken;
import br.com.m4rc310.gql.dto.MEnumToken;
import br.com.m4rc310.gql.dto.MUser;
import br.com.m4rc310.gql.jwt.MGraphQLJwtService;
import br.com.m4rc310.gql.security.IMAuthUserProvider;

@Configuration
public class MGraphQLSecurityConfig implements IMAuthUserProvider {

	@Override
	public MUser authUser(String username, Object password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MUser getUserFromUsername(String username) {
		return null;
	}

	@Override
	public MUser loadUser(MGraphQLJwtService jwt, MEnumToken type, String token) throws Exception {
		MUser u ;

		switch (type) {
		case TEST:
			int i = token.indexOf(":");
			String username = token.substring(0, i);
			String password = token.substring(i + 1);
			u = new MUser();
			u.setUsername(username);
			u.setPassword(password);
			u.setCode(Long.getLong(password));
			u.setRoles("Admin".split(";"));
			
			return u;
		case BASIC:
		case BEARER:
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}

	}

	@Override
	public boolean isValidUser(MUser user) {
		if ("test".equals(user.getUsername())) {
			return true;
		}
		return false;
	}

	@Override
	public void validUserAccess(MAuthToken authToken, String[] roles) throws Exception {

	}

}
