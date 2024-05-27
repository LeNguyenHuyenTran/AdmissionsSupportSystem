package com.lnht.pojo;

import com.lnht.pojo.Diemtrungtuyen;
import com.lnht.pojo.Nganh;
import com.lnht.pojo.Thongtin;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-27T17:02:30", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Khoa.class)
public class Khoa_ { 

    public static volatile SingularAttribute<Khoa, String> tenkhoa;
    public static volatile SetAttribute<Khoa, Diemtrungtuyen> diemtrungtuyenSet;
    public static volatile SetAttribute<Khoa, Nganh> nganhSet;
    public static volatile SingularAttribute<Khoa, Integer> id;
    public static volatile SingularAttribute<Khoa, String> video;
    public static volatile SingularAttribute<Khoa, Thongtin> thongtin;

}