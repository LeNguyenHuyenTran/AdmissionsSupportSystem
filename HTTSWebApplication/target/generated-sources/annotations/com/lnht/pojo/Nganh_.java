package com.lnht.pojo;

import com.lnht.pojo.DiemTrungTuyen;
import com.lnht.pojo.Khoa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-01T15:07:47", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Nganh.class)
public class Nganh_ { 

    public static volatile SetAttribute<Nganh, DiemTrungTuyen> diemTrungTuyenSet;
    public static volatile SingularAttribute<Nganh, Integer> id;
    public static volatile SingularAttribute<Nganh, String> ten;
    public static volatile SingularAttribute<Nganh, Khoa> khoa;

}