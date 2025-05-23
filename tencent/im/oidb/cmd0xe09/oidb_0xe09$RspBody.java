package tencent.im.oidb.cmd0xe09;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe09$RspBody extends MessageMicro<oidb_0xe09$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{"rpt_online_info"}, new Object[]{null}, oidb_0xe09$RspBody.class);
    public final PBRepeatMessageField<oidb_0xe09$OnlineInfo> rpt_online_info = PBField.initRepeatMessage(oidb_0xe09$OnlineInfo.class);
}
