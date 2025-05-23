package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x6f$MCardNotificationLike extends MessageMicro<SubMsgType0x6f$MCardNotificationLike> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_from_uin", "uint32_counter_total", "uint32_counter_new", "str_wording"}, new Object[]{0L, 0, 0, ""}, SubMsgType0x6f$MCardNotificationLike.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_counter_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_counter_new = PBField.initUInt32(0);
    public final PBStringField str_wording = PBField.initString("");
}
