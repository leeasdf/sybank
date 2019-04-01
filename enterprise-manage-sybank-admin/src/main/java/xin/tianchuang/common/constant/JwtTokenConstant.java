package xin.tianchuang.common.constant;

import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 常量
 */
public final class JwtTokenConstant {
	public static final SignatureAlgorithm SIGN_ALGORITHM = SignatureAlgorithm.HS512;
	
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_AUTHORIZATION = "Authorization";
	public static final String HEADER_PARAM_TYP = "JWT";
}
