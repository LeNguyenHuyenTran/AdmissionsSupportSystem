package com.lnht.pojo;

import com.lnht.pojo.Admin;
import com.lnht.pojo.Banner;
import com.lnht.pojo.Binhluan;
import com.lnht.pojo.Nguoituvan;
import com.lnht.pojo.Thisinh;
import com.lnht.pojo.Userrole;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T15:45:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Userrole> role;
    public static volatile SetAttribute<User, Binhluan> binhluanSet;
    public static volatile SingularAttribute<User, Nguoituvan> nguoituvan;
    public static volatile SingularAttribute<User, Admin> admin;
    public static volatile SingularAttribute<User, String> hoten;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SetAttribute<User, Banner> bannerSet;
    public static volatile SingularAttribute<User, Thisinh> thisinh;
    public static volatile SingularAttribute<User, String> username;

}