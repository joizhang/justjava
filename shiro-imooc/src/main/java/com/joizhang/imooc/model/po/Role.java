package com.joizhang.imooc.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 6177417435897400228L;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    private Long id;
    @NotNull
    private String name;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "User_Role",
            joinColumns = {@JoinColumn(name = "RoleId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "UserName", referencedColumnName = "userName")})
    private List<User> userList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Role_Permission",
            joinColumns = {@JoinColumn(name = "RoleId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "PermissionId", referencedColumnName = "id")})
    private List<Permission> permissionList;

}