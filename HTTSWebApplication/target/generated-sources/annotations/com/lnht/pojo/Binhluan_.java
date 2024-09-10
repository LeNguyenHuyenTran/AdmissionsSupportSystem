package com.lnht.pojo;

import com.lnht.pojo.TinTuyenSinh;
import com.lnht.pojo.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T13:21:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(BinhLuan.class)
public class BinhLuan_ { 

    public static volatile SingularAttribute<BinhLuan, String> binhLuan;
    public static volatile SingularAttribute<BinhLuan, Date> createdDate;
    public static volatile SingularAttribute<BinhLuan, TinTuyenSinh> tinTuyenSinhId;
    public static volatile SingularAttribute<BinhLuan, Integer> id;
    public static volatile SingularAttribute<BinhLuan, User> userId;

}