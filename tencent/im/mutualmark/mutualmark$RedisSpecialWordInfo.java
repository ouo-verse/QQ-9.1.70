package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$RedisSpecialWordInfo extends MessageMicro<mutualmark$RedisSpecialWordInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"claim_uin", "claim_time"}, new Object[]{0L, 0}, mutualmark$RedisSpecialWordInfo.class);
    public final PBUInt64Field claim_uin = PBField.initUInt64(0);
    public final PBUInt32Field claim_time = PBField.initUInt32(0);
}
