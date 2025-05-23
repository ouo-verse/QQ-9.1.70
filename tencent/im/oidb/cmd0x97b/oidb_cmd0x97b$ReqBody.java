package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x97b$ReqBody extends MessageMicro<oidb_cmd0x97b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"uint64_uin", "uint32_req_ctrl_bits", "uint32_like_total", "uint32_publish_feeds_total", "uint32_sign_in", "uint32_medal", "uint32_column_info"}, new Object[]{0L, 0, 0, 0, 0, 0, 0}, oidb_cmd0x97b$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_req_ctrl_bits = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_publish_feeds_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sign_in = PBField.initUInt32(0);
    public final PBUInt32Field uint32_medal = PBField.initUInt32(0);
    public final PBUInt32Field uint32_column_info = PBField.initUInt32(0);
}
