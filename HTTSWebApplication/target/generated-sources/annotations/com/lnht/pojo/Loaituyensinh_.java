package com.lnht.pojo;

import com.lnht.pojo.Tintuyensinh;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T15:45:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Loaituyensinh.class)
public class Loaituyensinh_ { 

    public static volatile SingularAttribute<Loaituyensinh, Integer> id;
    public static volatile SingularAttribute<Loaituyensinh, String> ten;
    public static volatile SingularAttribute<Loaituyensinh, String> mota;
    public static volatile SetAttribute<Loaituyensinh, Tintuyensinh> tintuyensinhSet;

}