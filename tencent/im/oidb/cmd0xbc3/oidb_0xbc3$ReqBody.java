package tencent.im.oidb.cmd0xbc3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbc3$ReqBody extends MessageMicro<oidb_0xbc3$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_from", "uint64_to", "uint32_topic_id", "uint32_is_confessor"}, new Object[]{0L, 0L, 0, 0}, oidb_0xbc3$ReqBody.class);
    public final PBUInt64Field uint64_from = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to = PBField.initUInt64(0);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_confessor = PBField.initUInt32(0);
}
