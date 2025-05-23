package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetTroopAioTopAD$RspBody extends MessageMicro<GetTroopAioTopAD$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_res", "uint32_time_interval", "rpt_ad_info"}, new Object[]{0, 0, null}, GetTroopAioTopAD$RspBody.class);
    public final PBUInt32Field uint32_res = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_interval = PBField.initUInt32(0);
    public final PBRepeatMessageField<GetTroopAioTopAD$AdInfo> rpt_ad_info = PBField.initRepeatMessage(GetTroopAioTopAD$AdInfo.class);
}
