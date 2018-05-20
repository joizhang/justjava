package com.joizhang.imooc.model.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joizhang.imooc.constants.AuthorityType;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@ToString(exclude = {"bankCard", "roleList"})
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 895922977663522702L;

    @Id
    @NotNull
    @Getter
    @Setter
    private String userName;


    @NotNull
    @Setter
    private String passWord;

    //@NotNull
    @Getter
    @Setter
    private AuthorityType authorityType;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", optional = true, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @Getter
    @Setter
    private BankCard bankCard;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "userList", fetch = FetchType.LAZY)
    @JsonIgnore
    @Setter
    private List<Role> roleList;


    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String passWord, AuthorityType authorityType) {
        this.userName = userName;
        this.passWord = passWord;
        this.authorityType = authorityType;
    }

    public User(String userName, String passWord, List<Role> roleList) {
        this.userName = userName;
        this.passWord = passWord;
        this.roleList = roleList;
    }

    @JsonIgnore    //生成json不包含此字段,必须打在Getter上面
    public String getPassWord() {
        return passWord;
    }

    @JsonIgnore    //生成json不包含此字段
    public List<Role> getRoleList() {
        return roleList;
    }

}
