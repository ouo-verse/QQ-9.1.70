package tencent.im.oidb.cmd0x903;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x903$SubCmd0x2Req extends MessageMicro<cmd0x903$SubCmd0x2Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"opt_uint64_group_code", "uint64_req_start_time", "uint32_uin_num"}, new Object[]{0L, 0L, 0}, cmd0x903$SubCmd0x2Req.class);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_req_start_time = PBField.initUInt64(0);
    public final PBUInt32Field uint32_uin_num = PBField.initUInt32(0);
}
