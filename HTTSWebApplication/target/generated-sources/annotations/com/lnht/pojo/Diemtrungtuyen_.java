package com.lnht.pojo;

import com.lnht.pojo.ChuongTrinhDaoTao;
import com.lnht.pojo.DiemTrungTuyenPK;
import com.lnht.pojo.Khoa;
import com.lnht.pojo.Nganh;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T13:21:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(DiemTrungTuyen.class)
public class DiemTrungTuyen_ { 

    public static volatile SingularAttribute<DiemTrungTuyen, Nganh> nganh1;
    public static volatile SingularAttribute<DiemTrungTuyen, Double> diem;
    public static volatile SingularAttribute<DiemTrungTuyen, Khoa> khoa1;
    public static volatile SingularAttribute<DiemTrungTuyen, ChuongTrinhDaoTao> chuongTrinhDaoTao1;
    public static volatile SingularAttribute<DiemTrungTuyen, DiemTrungTuyenPK> diemTrungTuyenPK;
    public static volatile SingularAttribute<DiemTrungTuyen, Integer> namHoc;

}