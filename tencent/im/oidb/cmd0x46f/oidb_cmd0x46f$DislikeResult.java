package tencent.im.oidb.cmd0x46f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x46f$DislikeResult extends MessageMicro<oidb_cmd0x46f$DislikeResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_articleid", "uint32_result", "str_message"}, new Object[]{0L, 0, ""}, oidb_cmd0x46f$DislikeResult.class);
    public final PBUInt64Field uint64_articleid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBStringField str_message = PBField.initString("");
}
