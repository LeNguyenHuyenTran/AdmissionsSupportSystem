package com.lnht.pojo;

import com.lnht.pojo.Khoa;
import com.lnht.pojo.Tintuyensinh;
import com.lnht.pojo.Truong;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-28T18:40:17", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Thongtin.class)
public class Thongtin_ { 

    public static volatile SingularAttribute<Thongtin, Integer> id;
    public static volatile SingularAttribute<Thongtin, String> noidung;
    public static volatile SingularAttribute<Thongtin, Khoa> khoa;
    public static volatile SingularAttribute<Thongtin, Tintuyensinh> tintuyensinh;
    public static volatile SingularAttribute<Thongtin, Truong> truong;

}