package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Common$SeatsInfo extends MessageMicro<Common$SeatsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_seat_flag", "uint64_guest_uin", "uint32_seat_id", "uint32_seat_seq"}, new Object[]{0, 0L, 0, 0}, Common$SeatsInfo.class);
    public final PBUInt32Field uint32_seat_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_guest_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_seat_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seat_seq = PBField.initUInt32(0);
}
