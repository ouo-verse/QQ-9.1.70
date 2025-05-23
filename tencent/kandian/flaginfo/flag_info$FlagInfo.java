package tencent.kandian.flaginfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class flag_info$FlagInfo extends MessageMicro<flag_info$FlagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 88, 96}, new String[]{"uint64_uin", "int64_update_time", "uint64_private_flag", "uint32_teenager_flag"}, new Object[]{0L, 0L, 0L, 0}, flag_info$FlagInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBInt64Field int64_update_time = PBField.initInt64(0);
    public final PBUInt64Field uint64_private_flag = PBField.initUInt64(0);
    public final PBUInt32Field uint32_teenager_flag = PBField.initUInt32(0);
}
