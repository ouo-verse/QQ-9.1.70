package tencent.im.oidb.cmd0xe6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe6b$ReqBody extends MessageMicro<oidb_0xe6b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_frd_uin", "uint32_last_query_time"}, new Object[]{0L, 0}, oidb_0xe6b$ReqBody.class);
    public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_last_query_time = PBField.initUInt32(0);
}
