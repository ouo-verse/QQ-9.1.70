package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xee$MsgBody extends MessageMicro<submsgtype0xee$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 90}, new String[]{"bytes_id", "uint64_seq", "uint32_bid", "rpt_msg_notify_list"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0, null}, submsgtype0xee$MsgBody.class);
    public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
    public final PBRepeatMessageField<submsgtype0xee$NotifyInfo> rpt_msg_notify_list = PBField.initRepeatMessage(submsgtype0xee$NotifyInfo.class);
}
