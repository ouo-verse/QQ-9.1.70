package tencent.im.mobileqq.configpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DomainIp$ServerList extends MessageMicro<DomainIp$ServerList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"string_IP", "uint32_Port"}, new Object[]{"", 0}, DomainIp$ServerList.class);
    public final PBStringField string_IP = PBField.initString("");
    public final PBUInt32Field uint32_Port = PBField.initUInt32(0);
}
