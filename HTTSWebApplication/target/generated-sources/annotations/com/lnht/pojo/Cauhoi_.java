package com.lnht.pojo;

import com.lnht.pojo.Thisinh;
import com.lnht.pojo.Thongbaolivestream;
import com.lnht.pojo.Videolivestream;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T15:45:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Cauhoi.class)
public class Cauhoi_ { 

    public static volatile SingularAttribute<Cauhoi, Date> thoidiem;
    public static volatile SingularAttribute<Cauhoi, Integer> id;
    public static volatile SingularAttribute<Cauhoi, Thongbaolivestream> thongbaolivestream;
    public static volatile SingularAttribute<Cauhoi, Videolivestream> video;
    public static volatile SingularAttribute<Cauhoi, String> noidung;
    public static volatile SingularAttribute<Cauhoi, Thisinh> thisinh;

}