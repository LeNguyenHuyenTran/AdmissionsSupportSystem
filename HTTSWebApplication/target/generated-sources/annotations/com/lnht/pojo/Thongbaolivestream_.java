package com.lnht.pojo;

import com.lnht.pojo.Binhluanthongbao;
import com.lnht.pojo.User;
import com.lnht.pojo.Videolivestream;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-26T18:10:46", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Thongbaolivestream.class)
public class Thongbaolivestream_ { 

    public static volatile SingularAttribute<Thongbaolivestream, Date> giolivestream;
    public static volatile SingularAttribute<Thongbaolivestream, Integer> id;
    public static volatile SingularAttribute<Thongbaolivestream, Videolivestream> videolivestream;
    public static volatile SingularAttribute<Thongbaolivestream, User> user;
    public static volatile SetAttribute<Thongbaolivestream, Binhluanthongbao> binhluanthongbaoSet;

}