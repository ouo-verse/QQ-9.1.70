package tencent.im.oidb.cmd0xe71;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xe71$RspBody extends MessageMicro<oidb_cmd0xe71$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_result", "account_status"}, new Object[]{0, 0}, oidb_cmd0xe71$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field account_status = PBField.initUInt32(0);
}
