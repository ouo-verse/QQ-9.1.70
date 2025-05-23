package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x74b$RspBody extends MessageMicro<oidb_0x74b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_uin_head_list"}, new Object[]{null}, oidb_0x74b$RspBody.class);
    public final PBRepeatMessageField<oidb_0x74b$OneUinHeadInfo> rpt_msg_uin_head_list = PBField.initRepeatMessage(oidb_0x74b$OneUinHeadInfo.class);
}
