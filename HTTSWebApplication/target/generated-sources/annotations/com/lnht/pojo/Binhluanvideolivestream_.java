package com.lnht.pojo;

import com.lnht.pojo.User;
import com.lnht.pojo.Videolivestream;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-26T18:10:46", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Binhluanvideolivestream.class)
public class Binhluanvideolivestream_ { 

    public static volatile SingularAttribute<Binhluanvideolivestream, Date> createdDate;
    public static volatile SingularAttribute<Binhluanvideolivestream, Videolivestream> videoLivestream;
    public static volatile SingularAttribute<Binhluanvideolivestream, Integer> id;
    public static volatile SingularAttribute<Binhluanvideolivestream, String> noidung;
    public static volatile SingularAttribute<Binhluanvideolivestream, User> userId;

}