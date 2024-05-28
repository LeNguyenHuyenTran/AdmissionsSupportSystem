package com.lnht.pojo;

import com.lnht.pojo.Binhluanvideolivestream;
import com.lnht.pojo.Thongbaolivestream;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-28T18:40:18", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Videolivestream.class)
public class Videolivestream_ { 

    public static volatile SetAttribute<Videolivestream, Binhluanvideolivestream> binhluanvideolivestreamSet;
    public static volatile SetAttribute<Videolivestream, Thongbaolivestream> thongbaolivestreamSet;
    public static volatile SingularAttribute<Videolivestream, Integer> id;
    public static volatile SingularAttribute<Videolivestream, String> video;
    public static volatile SingularAttribute<Videolivestream, String> tieude;

}