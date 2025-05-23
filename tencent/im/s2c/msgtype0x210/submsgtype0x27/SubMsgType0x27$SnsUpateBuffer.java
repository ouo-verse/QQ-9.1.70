package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$SnsUpateBuffer extends MessageMicro<SubMsgType0x27$SnsUpateBuffer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 3202, 3208}, new String[]{"uint64_uin", "uint64_code", "uint32_result", "rpt_msg_sns_update_item", "rpt_uint32_idlist"}, new Object[]{0L, 0L, 0, null, 0}, SubMsgType0x27$SnsUpateBuffer.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBRepeatMessageField<SubMsgType0x27$SnsUpdateItem> rpt_msg_sns_update_item = PBField.initRepeatMessage(SubMsgType0x27$SnsUpdateItem.class);
    public final PBRepeatField<Integer> rpt_uint32_idlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
