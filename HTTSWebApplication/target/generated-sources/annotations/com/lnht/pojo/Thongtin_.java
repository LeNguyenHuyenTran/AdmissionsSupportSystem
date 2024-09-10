package com.lnht.pojo;

import com.lnht.pojo.Khoa;
import com.lnht.pojo.ThongBaoLivestream;
import com.lnht.pojo.TinTuyenSinh;
import com.lnht.pojo.Truong;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T13:21:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(ThongTin.class)
public class ThongTin_ { 

    public static volatile SingularAttribute<ThongTin, TinTuyenSinh> tinTuyenSinh;
    public static volatile SingularAttribute<ThongTin, Integer> id;
    public static volatile SingularAttribute<ThongTin, ThongBaoLivestream> thongBaoLivestream;
    public static volatile SingularAttribute<ThongTin, String> noiDung;
    public static volatile SingularAttribute<ThongTin, Khoa> khoa;
    public static volatile SingularAttribute<ThongTin, Truong> truong;

}