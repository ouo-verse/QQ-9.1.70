package tencent.im.oidb.cmd0x6f6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x6f6$ReqBody extends MessageMicro<oidb_cmd0x6f6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_group_info"}, new Object[]{null}, oidb_cmd0x6f6$ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0x6f6$GroupInfo> rpt_msg_group_info = PBField.initRepeatMessage(oidb_cmd0x6f6$GroupInfo.class);
}
