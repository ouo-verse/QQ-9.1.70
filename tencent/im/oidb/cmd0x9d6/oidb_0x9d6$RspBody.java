package tencent.im.oidb.cmd0x9d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9d6$RspBody extends MessageMicro<oidb_0x9d6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_error_tips", "uint32_praise_count"}, new Object[]{"", 0}, oidb_0x9d6$RspBody.class);
    public final PBStringField str_error_tips = PBField.initString("");
    public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
}
