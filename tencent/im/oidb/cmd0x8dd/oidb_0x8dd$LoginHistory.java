package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$LoginHistory extends MessageMicro<oidb_0x8dd$LoginHistory> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_login_info"}, new Object[]{null}, oidb_0x8dd$LoginHistory.class);
    public final PBRepeatMessageField<oidb_0x8dd$LoginInfo> rpt_msg_login_info = PBField.initRepeatMessage(oidb_0x8dd$LoginInfo.class);
}
