package com.lnht.pojo;

import com.lnht.pojo.DiemTrungTuyen;
import com.lnht.pojo.Nganh;
import com.lnht.pojo.ThongTin;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T13:21:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Khoa.class)
public class Khoa_ { 

    public static volatile SingularAttribute<Khoa, String> tenKhoa;
    public static volatile SetAttribute<Khoa, DiemTrungTuyen> diemTrungTuyenSet;
    public static volatile SingularAttribute<Khoa, Integer> id;
    public static volatile SingularAttribute<Khoa, String> video;
    public static volatile SetAttribute<Khoa, Nganh> nganh;
    public static volatile SingularAttribute<Khoa, ThongTin> thongTin;

}