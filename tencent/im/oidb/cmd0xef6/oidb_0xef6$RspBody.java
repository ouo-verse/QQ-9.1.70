package tencent.im.oidb.cmd0xef6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xef6$RspBody extends MessageMicro<oidb_0xef6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"idol_list"}, new Object[]{null}, oidb_0xef6$RspBody.class);
    public final PBRepeatMessageField<oidb_0xef6$IdolInfo> idol_list = PBField.initRepeatMessage(oidb_0xef6$IdolInfo.class);
}
