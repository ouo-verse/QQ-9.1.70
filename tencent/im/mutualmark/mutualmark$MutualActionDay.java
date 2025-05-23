package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$MutualActionDay extends MessageMicro<mutualmark$MutualActionDay> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_type", "uint64_day", "uint64_time"}, new Object[]{0L, 0L, 0L}, mutualmark$MutualActionDay.class);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0);
    public final PBUInt64Field uint64_day = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
}
