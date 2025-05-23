package tencent.im.s2c.msgtype0x210.submsgtype0x28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x28$RspFollowList extends MessageMicro<SubMsgType0x28$RspFollowList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_followlist"}, new Object[]{null}, SubMsgType0x28$RspFollowList.class);
    public final PBRepeatMessageField<SubMsgType0x28$FollowList> rpt_msg_followlist = PBField.initRepeatMessage(SubMsgType0x28$FollowList.class);
}
