package com.lnht.pojo;

import com.lnht.pojo.Binhluan;
import com.lnht.pojo.Loaituyensinh;
import com.lnht.pojo.Thongtin;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T15:45:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tintuyensinh.class)
public class Tintuyensinh_ { 

    public static volatile SetAttribute<Tintuyensinh, Binhluan> binhluanSet;
    public static volatile SingularAttribute<Tintuyensinh, Loaituyensinh> loaituyensinh;
    public static volatile SingularAttribute<Tintuyensinh, Integer> id;
    public static volatile SingularAttribute<Tintuyensinh, Thongtin> thongtin;

}