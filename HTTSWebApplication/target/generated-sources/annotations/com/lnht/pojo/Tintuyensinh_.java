package com.lnht.pojo;

import com.lnht.pojo.BinhLuan;
import com.lnht.pojo.LoaiTuyenSinh;
import com.lnht.pojo.ThongTin;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T13:21:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(TinTuyenSinh.class)
public class TinTuyenSinh_ { 

    public static volatile SingularAttribute<TinTuyenSinh, Date> createdDate;
    public static volatile SingularAttribute<TinTuyenSinh, LoaiTuyenSinh> loaiTuyenSinhId;
    public static volatile SetAttribute<TinTuyenSinh, BinhLuan> binhLuanSet;
    public static volatile SingularAttribute<TinTuyenSinh, Integer> id;
    public static volatile SingularAttribute<TinTuyenSinh, ThongTin> thongTin;
    public static volatile SingularAttribute<TinTuyenSinh, String> tieuDe;

}