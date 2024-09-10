package com.lnht.pojo;

import com.lnht.pojo.User;
import com.lnht.pojo.VideoLivestream;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T13:21:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(BinhLuanVideoLivestream.class)
public class BinhLuanVideoLivestream_ { 

    public static volatile SingularAttribute<BinhLuanVideoLivestream, Date> createdDate;
    public static volatile SingularAttribute<BinhLuanVideoLivestream, VideoLivestream> videoLivestreamId;
    public static volatile SingularAttribute<BinhLuanVideoLivestream, Integer> id;
    public static volatile SingularAttribute<BinhLuanVideoLivestream, String> noiDung;
    public static volatile SingularAttribute<BinhLuanVideoLivestream, User> userId;

}