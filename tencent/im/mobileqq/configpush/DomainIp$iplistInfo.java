package tencent.im.mobileqq.configpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DomainIp$iplistInfo extends MessageMicro<DomainIp$iplistInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"int32_result", "string_dname", "uint32_type", "uint32_ttl", "ServerList_data"}, new Object[]{0, "", 0, 0, null}, DomainIp$iplistInfo.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBStringField string_dname = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
    public final PBRepeatMessageField<DomainIp$ServerList> ServerList_data = PBField.initRepeatMessage(DomainIp$ServerList.class);
}
