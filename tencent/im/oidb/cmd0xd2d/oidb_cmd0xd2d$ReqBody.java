package tencent.im.oidb.cmd0xd2d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd2d$ReqBody extends MessageMicro<oidb_cmd0xd2d$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_req_uin", "uint32_req_category"}, new Object[]{0L, 0}, oidb_cmd0xd2d$ReqBody.class);
    public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_req_category = PBField.initUInt32(0);
}
