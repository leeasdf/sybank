package xin.tianchuang.modules.sys.oauth2;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 *
 * @author hui.deng
 * 
 * @date 2017-05-20 13:22
 */
public class OAuthTwoToken implements AuthenticationToken {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1898309934055964814L;
	private String token;

    public OAuthTwoToken(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
