package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$ChatContinueDegradeInfo extends MessageMicro<mutualmark$ChatContinueDegradeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_degrade_time", "uint64_level", "uint64_sub_level"}, new Object[]{0L, 0L, 0L}, mutualmark$ChatContinueDegradeInfo.class);
    public final PBUInt64Field uint64_degrade_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_level = PBField.initUInt64(0);
    public final PBUInt64Field uint64_sub_level = PBField.initUInt64(0);
}
