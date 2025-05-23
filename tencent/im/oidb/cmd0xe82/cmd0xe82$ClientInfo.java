package tencent.im.oidb.cmd0xe82;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe82$ClientInfo extends MessageMicro<cmd0xe82$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"platform", "version"}, new Object[]{0, ""}, cmd0xe82$ClientInfo.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
}
