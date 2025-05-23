package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DomainIp$MobRouteSSOList extends MessageMicro<DomainIp$MobRouteSSOList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_timeout", "vec_tcplist", "vec_httplist"}, new Object[]{0, null, null}, DomainIp$MobRouteSSOList.class);
    public final PBUInt32Field uint32_timeout = PBField.initUInt32(0);
    public final PBRepeatMessageField<DomainIp$MobRouteSSOListInfo> vec_tcplist = PBField.initRepeatMessage(DomainIp$MobRouteSSOListInfo.class);
    public final PBRepeatMessageField<DomainIp$MobRouteSSOListInfo> vec_httplist = PBField.initRepeatMessage(DomainIp$MobRouteSSOListInfo.class);
}
