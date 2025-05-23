package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$OIDBGetSessionIDReq extends MessageMicro<GetLocalPhone$OIDBGetSessionIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_new_device_check_sig"}, new Object[]{""}, GetLocalPhone$OIDBGetSessionIDReq.class);
    public final PBStringField str_new_device_check_sig = PBField.initString("");
}
