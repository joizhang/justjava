package com.joizhang.imooc.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Data
@NoArgsConstructor
@AllArgsConstructor
class BankCard implements Serializable {

    private static final long serialVersionUID = 61774758654560228L;

    @Id
    @NotNull
    private String cardNumber;

    @NotNull
    private String bankName;

    @NotNull
    private String accountHolder;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "userName")
    @Fetch(FetchMode.SELECT)
    private User user;

}