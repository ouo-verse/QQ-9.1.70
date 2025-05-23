package tencent.im.oidb.cmd0x5cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5cf$DelDecideInfo extends MessageMicro<Oidb_0x5cf$DelDecideInfo> {
    public static final int UINT32_REQ_TYPE_FIELD_NUMBER = 3;
    public static final int UINT32_TIME_FIELD_NUMBER = 2;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint32_time", "uint32_req_type"}, new Object[]{0L, 0, 0}, Oidb_0x5cf$DelDecideInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
}
