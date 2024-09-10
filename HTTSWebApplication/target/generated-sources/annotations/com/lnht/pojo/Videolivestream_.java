package com.lnht.pojo;

import com.lnht.pojo.BinhLuanVideoLivestream;
import com.lnht.pojo.ThongBaoLivestream;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T13:21:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(VideoLivestream.class)
public class VideoLivestream_ { 

    public static volatile SetAttribute<VideoLivestream, BinhLuanVideoLivestream> binhLuanVideoLivestreamSet;
    public static volatile SingularAttribute<VideoLivestream, Integer> id;
    public static volatile SingularAttribute<VideoLivestream, String> video;
    public static volatile SingularAttribute<VideoLivestream, String> tieuDe;
    public static volatile SetAttribute<VideoLivestream, ThongBaoLivestream> thongBaoLivestreamSet;

}