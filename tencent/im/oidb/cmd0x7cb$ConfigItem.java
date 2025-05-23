package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7cb$ConfigItem extends MessageMicro<cmd0x7cb$ConfigItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_id", "str_config"}, new Object[]{0, ""}, cmd0x7cb$ConfigItem.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBStringField str_config = PBField.initString("");
}
