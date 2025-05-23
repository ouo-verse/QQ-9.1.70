package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa28$ReqBody extends MessageMicro<oidb_0xa28$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_request_uin", "uint32_sourceID", "uint32_sourceSubID"}, new Object[]{0L, 0, 0}, oidb_0xa28$ReqBody.class);
    public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_sourceID = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourceSubID = PBField.initUInt32(0);
}
