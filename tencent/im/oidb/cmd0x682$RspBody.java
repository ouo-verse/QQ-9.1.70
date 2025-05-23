package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x682$RspBody extends MessageMicro<cmd0x682$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_chatinfo"}, new Object[]{null}, cmd0x682$RspBody.class);
    public final PBRepeatMessageField<cmd0x682$ChatInfo> rpt_msg_chatinfo = PBField.initRepeatMessage(cmd0x682$ChatInfo.class);
}
