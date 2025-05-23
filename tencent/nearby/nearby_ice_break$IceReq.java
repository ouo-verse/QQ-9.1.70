package tencent.nearby;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearby_ice_break$IceReq extends MessageMicro<nearby_ice_break$IceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "tinyid"}, new Object[]{0L, ""}, nearby_ice_break$IceReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField tinyid = PBField.initString("");
}
