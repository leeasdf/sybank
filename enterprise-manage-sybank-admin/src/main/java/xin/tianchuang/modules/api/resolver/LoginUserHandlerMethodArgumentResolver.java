//package xin.tianchuang.modules.api.resolver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.MethodParameter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.support.WebDataBinderFactory;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.ModelAndViewContainer;
//
//import xin.tianchuang.modules.app.annotation.LoginUser;
//import xin.tianchuang.modules.app.entity.UserEntity;
//import xin.tianchuang.modules.app.interceptor.JwtAuthorizationInterceptor;
//import xin.tianchuang.modules.sys.entity.SysUserEntity;
//import xin.tianchuang.modules.sys.service.SysUserService;
//
///**
// * 有@LoginUser注解的方法参数，注入当前登录用户
// * @author hui.deng
// * 
// * @date 2017-03-23 22:02
// */
//@Component
//public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
//    @Autowired
//    private SysUserService userService;
//
//    @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//        return parameter.getParameterType().isAssignableFrom(UserEntity.class) && parameter.hasParameterAnnotation(LoginUser.class);
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
//                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
//        //获取用户ID
//        Object object = request.getAttribute(TokenInterceptor.USER_KEY, RequestAttributes.SCOPE_REQUEST);
//        if(object == null){
//            return null;
//        }
//
//        //获取用户信息
//        SysUserEntity user = userService.selectById((Long)object);
//
//        return user;
//    }
//}
