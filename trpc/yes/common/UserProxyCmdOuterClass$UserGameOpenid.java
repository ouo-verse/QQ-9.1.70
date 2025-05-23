package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$UserGameOpenid extends MessageMicro<UserProxyCmdOuterClass$UserGameOpenid> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"smoba_openid"}, new Object[]{""}, UserProxyCmdOuterClass$UserGameOpenid.class);
    public final PBStringField smoba_openid = PBField.initString("");
}
