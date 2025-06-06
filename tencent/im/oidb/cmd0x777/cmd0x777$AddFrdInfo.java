package tencent.im.oidb.cmd0x777;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x777$AddFrdInfo extends MessageMicro<cmd0x777$AddFrdInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"uint64_uin", "bytes_remark", "uint32_allow_type", "uint32_send_req_flag", "uint32_send_req_result"}, new Object[]{0L, "", 0, 0, 0}, cmd0x777$AddFrdInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBStringField bytes_remark = PBField.initString("");
    public final PBUInt32Field uint32_allow_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_req_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_req_result = PBField.initUInt32(0);
}
