package tencent.im.mobileqq.configpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DomainIp$NameReqBody extends MessageMicro<DomainIp$NameReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"SubCmd_name_Req"}, new Object[]{null}, DomainIp$NameReqBody.class);
    public DomainIp$SubCmd_name_Req SubCmd_name_Req = new MessageMicro<DomainIp$SubCmd_name_Req>() { // from class: tencent.im.mobileqq.configpush.DomainIp$SubCmd_name_Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_uip", "uint32_qq", "dnameInfo"}, new Object[]{0, 0, null}, DomainIp$SubCmd_name_Req.class);
        public final PBUInt32Field uint32_uip = PBField.initUInt32(0);
        public final PBUInt32Field uint32_qq = PBField.initUInt32(0);
        public final PBRepeatMessageField<DomainIp$dnameInfo> dnameInfo = PBField.initRepeatMessage(DomainIp$dnameInfo.class);
    };
}
