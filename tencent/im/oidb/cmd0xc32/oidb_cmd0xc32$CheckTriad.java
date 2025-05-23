package tencent.im.oidb.cmd0xc32;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc32$CheckTriad extends MessageMicro<oidb_cmd0xc32$CheckTriad> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_feeds_id", "uint64_uin", "uint32_visible"}, new Object[]{0L, 0L, 0}, oidb_cmd0xc32$CheckTriad.class);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_visible = PBField.initUInt32(0);
}
