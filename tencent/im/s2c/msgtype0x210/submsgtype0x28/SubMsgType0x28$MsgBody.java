package tencent.im.s2c.msgtype0x210.submsgtype0x28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x28$MsgBody extends MessageMicro<SubMsgType0x28$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_sub_cmd", "msg_rsp_followlist", "msg_rsp_typelist"}, new Object[]{0, null, null}, SubMsgType0x28$MsgBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public SubMsgType0x28$RspFollowList msg_rsp_followlist = new SubMsgType0x28$RspFollowList();
    public SubMsgType0x28$RspTypeList msg_rsp_typelist = new MessageMicro<SubMsgType0x28$RspTypeList>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28$RspTypeList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_typelist"}, new Object[]{null}, SubMsgType0x28$RspTypeList.class);
        public final PBRepeatMessageField<SubMsgType0x28$TypeList> rpt_msg_typelist = PBField.initRepeatMessage(SubMsgType0x28$TypeList.class);
    };
}
