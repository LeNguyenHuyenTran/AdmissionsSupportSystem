package com.lnht.pojo;

import com.lnht.pojo.Diemtrungtuyen;
import com.lnht.pojo.Khoa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-26T18:10:46", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Nganh.class)
public class Nganh_ { 

    public static volatile SetAttribute<Nganh, Diemtrungtuyen> diemtrungtuyenSet;
    public static volatile SingularAttribute<Nganh, Integer> id;
    public static volatile SingularAttribute<Nganh, String> ten;
    public static volatile SingularAttribute<Nganh, Khoa> khoa;

}