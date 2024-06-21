package com.lnht.pojo;

import com.lnht.pojo.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-21T15:34:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Userrole.class)
public class Userrole_ { 

    public static volatile SingularAttribute<Userrole, String> role;
    public static volatile SingularAttribute<Userrole, Integer> id;
    public static volatile SetAttribute<Userrole, User> userSet;

}