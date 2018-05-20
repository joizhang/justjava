package com.joizhang.imooc.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Table
@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {
    private static final long serialVersionUID = 2683590474689747957L;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    private Long id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private String permission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Permission parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Permission> childrenList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "permissionList")
    private List<Role> roleList;

    public Permission(String name, String description, String permission, Permission parent, List<Permission> childrenList, List<Role> roleList) {
        this.name = name;
        this.description = description;
        this.permission = permission;
        this.parent = parent;
        this.childrenList = childrenList;
        this.roleList = roleList;
    }

}
