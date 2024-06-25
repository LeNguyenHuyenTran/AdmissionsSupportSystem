package com.lnht.pojo;

import com.lnht.pojo.Chuongtrinhdaotao;
import com.lnht.pojo.Khoa;
import com.lnht.pojo.Nganh;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T15:45:10", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Diemtrungtuyen.class)
public class Diemtrungtuyen_ { 

    public static volatile SingularAttribute<Diemtrungtuyen, Double> diem;
    public static volatile SingularAttribute<Diemtrungtuyen, Chuongtrinhdaotao> chuongtrinhdaotao;
    public static volatile SingularAttribute<Diemtrungtuyen, Integer> id;
    public static volatile SingularAttribute<Diemtrungtuyen, Nganh> nganh;
    public static volatile SingularAttribute<Diemtrungtuyen, Integer> namhoc;
    public static volatile SingularAttribute<Diemtrungtuyen, Khoa> khoa;

}