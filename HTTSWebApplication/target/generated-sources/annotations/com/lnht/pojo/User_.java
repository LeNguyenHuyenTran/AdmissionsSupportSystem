package com.lnht.pojo;

import com.lnht.pojo.Banner;
import com.lnht.pojo.BinhLuan;
import com.lnht.pojo.BinhLuanThongBao;
import com.lnht.pojo.BinhLuanVideoLivestream;
import com.lnht.pojo.ThongBaoLivestream;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-01T15:07:47", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> role;
    public static volatile SetAttribute<User, BinhLuanVideoLivestream> binhLuanVideoLivestreamSet;
    public static volatile SetAttribute<User, BinhLuan> binhLuanSet;
    public static volatile SingularAttribute<User, String> fullName;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SetAttribute<User, BinhLuanThongBao> binhLuanThongBaoSet;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SetAttribute<User, Banner> bannerSet;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SetAttribute<User, ThongBaoLivestream> thongBaoLivestreamSet;
    public static volatile SingularAttribute<User, String> username;

}