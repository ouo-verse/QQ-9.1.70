package tencent.im.mobileqq.configpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DomainIp$SubCmd_name_Rsp extends MessageMicro<DomainIp$SubCmd_name_Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_uip", "uint32_qq", "iplistInfo", "iplistInfoV6"}, new Object[]{0, 0, null, null}, DomainIp$SubCmd_name_Rsp.class);
    public final PBUInt32Field uint32_uip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qq = PBField.initUInt32(0);
    public final PBRepeatMessageField<DomainIp$iplistInfo> iplistInfo = PBField.initRepeatMessage(DomainIp$iplistInfo.class);
    public final PBRepeatMessageField<DomainIp$iplistInfo> iplistInfoV6 = PBField.initRepeatMessage(DomainIp$iplistInfo.class);
}
