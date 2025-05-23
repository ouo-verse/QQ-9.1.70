package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbcb$UrlCheckResult extends MessageMicro<oidb_0xbcb$UrlCheckResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56, 64, 72, 80, 88}, new String[]{"url", "result", "jump_result", "jump_url", "uint32_level", "uint32_sub_level", "uint32_umrtype", "ret_from", "operation_bit", "url_rich", "target"}, new Object[]{"", 0, 0, "", 0, 0, 0, 0, 0L, 0, 0}, oidb_0xbcb$UrlCheckResult.class);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field jump_result = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_umrtype = PBField.initUInt32(0);
    public final PBUInt32Field ret_from = PBField.initUInt32(0);
    public final PBUInt64Field operation_bit = PBField.initUInt64(0);
    public final PBUInt32Field url_rich = PBField.initUInt32(0);
    public final PBUInt32Field target = PBField.initUInt32(0);
}
