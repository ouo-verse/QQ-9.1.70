package tencent.im.oidb.cmd0x7ba;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x7ba$ReqBody extends MessageMicro<oidb_0x7ba$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88, 96}, new String[]{"uint64_uin", "uint32_start_index", "uint32_want_num"}, new Object[]{0L, 0, 0}, oidb_0x7ba$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want_num = PBField.initUInt32(0);
}
