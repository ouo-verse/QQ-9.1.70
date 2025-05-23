package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$OIDBGetSessionIDRsp extends MessageMicro<GetLocalPhone$OIDBGetSessionIDRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_session_id"}, new Object[]{""}, GetLocalPhone$OIDBGetSessionIDRsp.class);
    public final PBStringField str_session_id = PBField.initString("");
}
