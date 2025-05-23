package tencent.im.oidb.oidb_0x8da;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8da$ReqBody extends MessageMicro<oidb_0x8da$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_user_info"}, new Object[]{null}, oidb_0x8da$ReqBody.class);
    public final PBRepeatMessageField<oidb_0x8da$UserInfo> rpt_msg_user_info = PBField.initRepeatMessage(oidb_0x8da$UserInfo.class);
}
