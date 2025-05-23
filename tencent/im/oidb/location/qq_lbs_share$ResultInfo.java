package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qq_lbs_share$ResultInfo extends MessageMicro<qq_lbs_share$ResultInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_result", "bytes_errmsg", "uint64_svr_time"}, new Object[]{0, ByteStringMicro.EMPTY, 0L}, qq_lbs_share$ResultInfo.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_svr_time = PBField.initUInt64(0);
}
