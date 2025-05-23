package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$FreqLimitInfo extends MessageMicro<common$FreqLimitInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"is_limited", "left_count", "limit_timestamp"}, new Object[]{0, 0, 0L}, common$FreqLimitInfo.class);
    public final PBUInt32Field is_limited = PBField.initUInt32(0);
    public final PBUInt32Field left_count = PBField.initUInt32(0);
    public final PBUInt64Field limit_timestamp = PBField.initUInt64(0);
}
