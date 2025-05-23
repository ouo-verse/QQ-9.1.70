package tencent.im.oidb.cmd0xf34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf34$RspBody extends MessageMicro<oidb_cmd0xf34$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_num", "uint32_share_status"}, new Object[]{0L, 0}, oidb_cmd0xf34$RspBody.class);
    public final PBUInt64Field uint64_num = PBField.initUInt64(0);
    public final PBUInt32Field uint32_share_status = PBField.initUInt32(0);
}
