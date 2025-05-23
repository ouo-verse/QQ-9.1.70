package tencent.im.mobileqq.configpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DomainIp$dnameInfo extends MessageMicro<DomainIp$dnameInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24}, new String[]{"string_dname", "uint32_type"}, new Object[]{"", 0}, DomainIp$dnameInfo.class);
    public final PBStringField string_dname = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}
