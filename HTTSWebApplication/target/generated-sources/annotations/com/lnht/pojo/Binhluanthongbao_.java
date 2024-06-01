package com.lnht.pojo;

import com.lnht.pojo.ThongBaoLivestream;
import com.lnht.pojo.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-01T15:07:47", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(BinhLuanThongBao.class)
public class BinhLuanThongBao_ { 

    public static volatile SingularAttribute<BinhLuanThongBao, Date> createdDate;
    public static volatile SingularAttribute<BinhLuanThongBao, ThongBaoLivestream> thongBaoLivestreamId;
    public static volatile SingularAttribute<BinhLuanThongBao, Integer> id;
    public static volatile SingularAttribute<BinhLuanThongBao, String> noiDung;
    public static volatile SingularAttribute<BinhLuanThongBao, User> userId;

}