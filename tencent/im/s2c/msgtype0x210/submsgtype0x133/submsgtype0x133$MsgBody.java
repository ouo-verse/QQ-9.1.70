package tencent.im.s2c.msgtype0x210.submsgtype0x133;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x133$MsgBody extends MessageMicro<submsgtype0x133$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_uin", "rpt_msg_friends", "str_session_id"}, new Object[]{0L, null, ""}, submsgtype0x133$MsgBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<submsgtype0x133$FaceFriend> rpt_msg_friends = PBField.initRepeatMessage(submsgtype0x133$FaceFriend.class);
    public final PBStringField str_session_id = PBField.initString("");
}
