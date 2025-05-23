package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0x88d$GroupHeadPortrait extends MessageMicro<oidb_0x88d$GroupHeadPortrait> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"uint32_pic_cnt", "rpt_msg_info", "uint32_default_id", "uint32_verifying_pic_cnt", "rpt_msg_verifyingpic_info"}, new Object[]{0, null, 0, 0, null}, oidb_0x88d$GroupHeadPortrait.class);
    public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x88d$GroupHeadPortraitInfo> rpt_msg_info = PBField.initRepeatMessage(oidb_0x88d$GroupHeadPortraitInfo.class);
    public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_verifying_pic_cnt = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x88d$GroupHeadPortraitInfo> rpt_msg_verifyingpic_info = PBField.initRepeatMessage(oidb_0x88d$GroupHeadPortraitInfo.class);
}
