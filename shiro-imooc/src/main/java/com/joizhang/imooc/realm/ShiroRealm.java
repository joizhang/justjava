package com.joizhang.imooc.realm;

import com.joizhang.imooc.model.po.Permission;
import com.joizhang.imooc.model.po.Role;
import com.joizhang.imooc.model.po.User;
import com.joizhang.imooc.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权访问
     * {@link SimpleAuthorizationInfo SimpleAuthorizationInfo}, as it is suitable in most cases.
     *
     * @param principals the primary identifying principals of the AuthorizationInfo that should be retrieved.
     * @return the AuthorizationInfo associated with this principals.
     * @see SimpleAuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String userName = (String) super.getAvailablePrincipal(principals);

        //保存角色
        List<String> roles = new ArrayList<>();
        //保存权限
        List<String> permissions = new ArrayList<>();
        //拿到当前登陆的用户
        User user = userService.getById(userName);
        if (user != null) {
            List<Role> userRoleList = user.getRoleList();
            if (userRoleList != null && !userRoleList.isEmpty()) {
                for (Role role : userRoleList) {
                    roles.add(role.getName());
                    List<Permission> rolePermissionList = role.getPermissionList();
                    if (rolePermissionList!= null && !rolePermissionList.isEmpty()) {
                        permissions.addAll(rolePermissionList.stream()
                                        //.filter(permission -> !StringUtils.isEmpty(permission.getPermission()))// permission 不可为空
                                        .map(Permission::getPermission)
                                        .collect(Collectors.toList())
                        );
                    }
                }
            }
        } else {
            throw new AuthorizationException();
        }
        //给当前用户设置角色
        info.addRoles(roles);
        //给当前用户设置权限
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 登录认证
     * <p/>
     * For most dataSources, this means just 'pulling' authentication data for an associated subject/user and nothing
     * more and letting Shiro do the rest.  But in some systems, this method could actually perform EIS specific
     * log-in logic in addition to just retrieving data - it is up to the Realm implementation.
     * <p/>
     * A {@code null} return value means that no account could be associated with the specified token.
     *
     * @param authToken the authentication token containing the user's principal and credentials.
     * @return an {@link AuthenticationInfo} object containing account data resulting from the
     * authentication ONLY if the lookup is successful (i.e. account exists and is valid, etc.)
     * @throws AuthenticationException if there is an error acquiring data or performing
     *                                 realm-specific authentication logic for the specified <tt>token</tt>
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
        User user = userService.getById(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassWord(), user.toString());
        } else {
            return null;
        }
    }

}
