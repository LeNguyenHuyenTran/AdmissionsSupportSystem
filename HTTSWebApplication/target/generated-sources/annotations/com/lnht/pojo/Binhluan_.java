package com.lnht.pojo;

import com.lnht.pojo.Tintuyensinh;
import com.lnht.pojo.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T15:45:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Binhluan.class)
public class Binhluan_ { 

    public static volatile SingularAttribute<Binhluan, String> binhluan;
    public static volatile SingularAttribute<Binhluan, User> nguoibinhluan;
    public static volatile SingularAttribute<Binhluan, Integer> id;
    public static volatile SingularAttribute<Binhluan, Tintuyensinh> tintuyensinh;

}