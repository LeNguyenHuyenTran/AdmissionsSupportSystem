package com.lnht.pojo;

import com.lnht.pojo.Cauhoi;
import com.lnht.pojo.Nguoituvan;
import com.lnht.pojo.Videolivestream;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-21T15:34:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Thongbaolivestream.class)
public class Thongbaolivestream_ { 

    public static volatile SetAttribute<Thongbaolivestream, Cauhoi> cauhoiSet;
    public static volatile SingularAttribute<Thongbaolivestream, Nguoituvan> nguoidangthongbao;
    public static volatile SingularAttribute<Thongbaolivestream, Date> giolivestream;
    public static volatile SingularAttribute<Thongbaolivestream, Integer> id;
    public static volatile SingularAttribute<Thongbaolivestream, Videolivestream> videolivestream;

}