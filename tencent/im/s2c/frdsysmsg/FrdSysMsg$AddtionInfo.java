package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$AddtionInfo extends MessageMicro<FrdSysMsg$AddtionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"uint32_poke", "uint32_format", "str_entity_category", "str_entity_name", "str_entity_url"}, new Object[]{0, 0, "", "", ""}, FrdSysMsg$AddtionInfo.class);
    public final PBUInt32Field uint32_poke = PBField.initUInt32(0);
    public final PBUInt32Field uint32_format = PBField.initUInt32(0);
    public final PBStringField str_entity_category = PBField.initString("");
    public final PBStringField str_entity_name = PBField.initString("");
    public final PBStringField str_entity_url = PBField.initString("");
}
