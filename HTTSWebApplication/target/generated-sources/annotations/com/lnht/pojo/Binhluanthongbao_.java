package com.lnht.pojo;

import com.lnht.pojo.Thongbaolivestream;
import com.lnht.pojo.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-26T18:55:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Binhluanthongbao.class)
public class Binhluanthongbao_ { 

    public static volatile SingularAttribute<Binhluanthongbao, Date> createdDate;
    public static volatile SingularAttribute<Binhluanthongbao, Integer> id;
    public static volatile SingularAttribute<Binhluanthongbao, Thongbaolivestream> thongbaolivestream;
    public static volatile SingularAttribute<Binhluanthongbao, String> noidung;
    public static volatile SingularAttribute<Binhluanthongbao, User> userId;

}