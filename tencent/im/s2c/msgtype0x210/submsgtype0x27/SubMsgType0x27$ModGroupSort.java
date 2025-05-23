package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$ModGroupSort extends MessageMicro<SubMsgType0x27$ModGroupSort> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_groupsort"}, new Object[]{null}, SubMsgType0x27$ModGroupSort.class);
    public final PBRepeatMessageField<SubMsgType0x27$GroupSort> rpt_msg_groupsort = PBField.initRepeatMessage(SubMsgType0x27$GroupSort.class);
}
