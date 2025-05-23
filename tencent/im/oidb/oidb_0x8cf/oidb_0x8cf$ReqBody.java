package tencent.im.oidb.oidb_0x8cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8cf$ReqBody extends MessageMicro<oidb_0x8cf$ReqBody> {
    public static final int OPT_UINT32_NEED_MOBILE_SYSAPPS_FIELD_NUMBER = 2;
    public static final int OPT_UINT64_GROUPCODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"opt_uint64_groupcode", "opt_uint32_need_mobile_sysapps"}, new Object[]{0L, 0}, oidb_0x8cf$ReqBody.class);
    public final PBUInt64Field opt_uint64_groupcode = PBField.initUInt64(0);
    public final PBUInt32Field opt_uint32_need_mobile_sysapps = PBField.initUInt32(0);
}
