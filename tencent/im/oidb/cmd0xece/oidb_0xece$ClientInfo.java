package tencent.im.oidb.cmd0xece;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xece$ClientInfo extends MessageMicro<oidb_0xece$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"platform", "version"}, new Object[]{0, ""}, oidb_0xece$ClientInfo.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
}
