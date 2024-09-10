package com.lnht.pojo;

import com.lnht.pojo.BinhLuanThongBao;
import com.lnht.pojo.ThongTin;
import com.lnht.pojo.User;
import com.lnht.pojo.VideoLivestream;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T13:21:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(ThongBaoLivestream.class)
public class ThongBaoLivestream_ { 

    public static volatile SingularAttribute<ThongBaoLivestream, VideoLivestream> videoLivestreamId;
    public static volatile SingularAttribute<ThongBaoLivestream, User> nguoiDangThongBaoId;
    public static volatile SingularAttribute<ThongBaoLivestream, Integer> id;
    public static volatile SingularAttribute<ThongBaoLivestream, Date> gioLivestream;
    public static volatile SetAttribute<ThongBaoLivestream, BinhLuanThongBao> binhLuanThongBaoSet;
    public static volatile SingularAttribute<ThongBaoLivestream, ThongTin> thongTin;

}