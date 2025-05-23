package tencent.im.oidb.cmd0x10d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10d6$ClientInfo extends MessageMicro<oidb_0x10d6$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"platform", "version", "build_num"}, new Object[]{0, "", 0}, oidb_0x10d6$ClientInfo.class);
    public final PBEnumField platform = PBField.initEnum(0);
    public final PBStringField version = PBField.initString("");
    public final PBUInt32Field build_num = PBField.initUInt32(0);
}
