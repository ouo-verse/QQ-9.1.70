package tencent.im.oidb.cmd0xee9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xee9$RspBody extends MessageMicro<oidb_cmd0xee9$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_user_info"}, new Object[]{null}, oidb_cmd0xee9$RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xee9$UserInfoItem> rpt_msg_user_info = PBField.initRepeatMessage(oidb_cmd0xee9$UserInfoItem.class);
}
