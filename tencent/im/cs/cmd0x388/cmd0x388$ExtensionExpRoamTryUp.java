package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x388$ExtensionExpRoamTryUp extends MessageMicro<cmd0x388$ExtensionExpRoamTryUp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_msg_exproam_pic_info", "uint32_capacity_incr"}, new Object[]{null, 0}, cmd0x388$ExtensionExpRoamTryUp.class);
    public final PBRepeatMessageField<cmd0x388$ExpRoamPicInfo> rpt_msg_exproam_pic_info = PBField.initRepeatMessage(cmd0x388$ExpRoamPicInfo.class);
    public final PBUInt32Field uint32_capacity_incr = PBField.initUInt32(0);
    public final PBUInt32Field jump_id = PBField.initUInt32(0);
}
