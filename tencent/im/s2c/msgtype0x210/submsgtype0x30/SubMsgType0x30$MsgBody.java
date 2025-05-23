package tencent.im.s2c.msgtype0x210.submsgtype0x30;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x30$MsgBody extends MessageMicro<SubMsgType0x30$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_sub_cmd", "msg_s2c_blocklist_notify"}, new Object[]{0, null}, SubMsgType0x30$MsgBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public SubMsgType0x30$BlockListNotify msg_s2c_blocklist_notify = new MessageMicro<SubMsgType0x30$BlockListNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30$BlockListNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_msg_block_uin_info", "rpt_uint64_del_uin"}, new Object[]{null, 0L}, SubMsgType0x30$BlockListNotify.class);
        public final PBRepeatMessageField<SubMsgType0x30$BlockUinInfo> rpt_msg_block_uin_info = PBField.initRepeatMessage(SubMsgType0x30$BlockUinInfo.class);
        public final PBRepeatField<Long> rpt_uint64_del_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
}
