package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x76$MemorialDayNotify extends MessageMicro<SubMsgType0x76$MemorialDayNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_anniversary_info"}, new Object[]{null}, SubMsgType0x76$MemorialDayNotify.class);
    public final PBRepeatMessageField<SubMsgType0x76$OneMemorialDayInfo> rpt_anniversary_info = PBField.initRepeatMessage(SubMsgType0x76$OneMemorialDayInfo.class);
}
