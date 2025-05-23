package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x85f$ReadFaceScoreReq extends MessageMicro<oidb_0x85f$ReadFaceScoreReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_user_id", "uint32_day", "uint32_range_min", "uint32_range_max"}, new Object[]{0L, 0, 0, 0}, oidb_0x85f$ReadFaceScoreReq.class);
    public final PBUInt64Field uint64_user_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_range_min = PBField.initUInt32(0);
    public final PBUInt32Field uint32_range_max = PBField.initUInt32(0);
}
