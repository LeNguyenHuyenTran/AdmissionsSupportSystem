package com.lnht.pojo;

import com.lnht.pojo.Cauhoi;
import com.lnht.pojo.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-21T15:34:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Thisinh.class)
public class Thisinh_ { 

    public static volatile SetAttribute<Thisinh, Cauhoi> cauhoiSet;
    public static volatile SingularAttribute<Thisinh, Integer> id;
    public static volatile SingularAttribute<Thisinh, String> avatar;
    public static volatile SingularAttribute<Thisinh, User> user;

}