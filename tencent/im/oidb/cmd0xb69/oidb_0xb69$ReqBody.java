package tencent.im.oidb.cmd0xb69;

import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb69$ReqBody extends MessageMicro<oidb_0xb69$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"group_id", "client_info", j.T0}, new Object[]{0L, null, null}, oidb_0xb69$ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public oidb_0xb69$ClientInfo client_info = new MessageMicro<oidb_0xb69$ClientInfo>() { // from class: tencent.im.oidb.cmd0xb69.oidb_0xb69$ClientInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"platform", "version"}, new Object[]{0, ""}, oidb_0xb69$ClientInfo.class);
        public final PBUInt32Field platform = PBField.initUInt32(0);
        public final PBStringField version = PBField.initString("");
    };
    public final PBRepeatMessageField<oidb_0xb69$AppInfo> app_info = PBField.initRepeatMessage(oidb_0xb69$AppInfo.class);
}
