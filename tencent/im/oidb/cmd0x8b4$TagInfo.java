package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8b4$TagInfo extends MessageMicro<cmd0x8b4$TagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_dst_uin", "uint32_start", "uint32_cnt", "uint32_timestamp", "uint32_0x7dd_seq"}, new Object[]{0L, 0, 0, 0, 0}, cmd0x8b4$TagInfo.class);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cnt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_0x7dd_seq = PBField.initUInt32(0);
}
