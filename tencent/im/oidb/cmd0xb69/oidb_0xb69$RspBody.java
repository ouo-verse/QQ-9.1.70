package tencent.im.oidb.cmd0xb69;

import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb69$RspBody extends MessageMicro<oidb_0xb69$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{j.T0}, new Object[]{null}, oidb_0xb69$RspBody.class);
    public final PBRepeatMessageField<oidb_0xb69$AppInfo> app_info = PBField.initRepeatMessage(oidb_0xb69$AppInfo.class);
}
