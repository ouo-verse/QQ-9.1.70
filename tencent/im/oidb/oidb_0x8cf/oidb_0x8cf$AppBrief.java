package tencent.im.oidb.oidb_0x8cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8cf$AppBrief extends MessageMicro<oidb_0x8cf$AppBrief> {
    public static final int OPT_UINT32_TIME_STAMP_FIELD_NUMBER = 2;
    public static final int OPT_UINT64_APPID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"opt_uint64_appid", "opt_uint32_time_stamp"}, new Object[]{0L, 0}, oidb_0x8cf$AppBrief.class);
    public final PBUInt64Field opt_uint64_appid = PBField.initUInt64(0);
    public final PBUInt32Field opt_uint32_time_stamp = PBField.initUInt32(0);
}
