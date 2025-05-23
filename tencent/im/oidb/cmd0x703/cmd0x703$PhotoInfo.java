package tencent.im.oidb.cmd0x703;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class cmd0x703$PhotoInfo extends MessageMicro<cmd0x703$PhotoInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 34, 40}, new String[]{"uint32_id", "uint32_is_invalid", "str_url", "uint32_timestamp"}, new Object[]{0, 0, "", 0}, cmd0x703$PhotoInfo.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_invalid = PBField.initUInt32(0);
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
}
