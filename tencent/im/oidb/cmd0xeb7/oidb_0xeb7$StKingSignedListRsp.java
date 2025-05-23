package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$StKingSignedListRsp extends MessageMicro<oidb_0xeb7$StKingSignedListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"ret", "yesterdayFirst", "topSignedTotal", "topSignedContinue"}, new Object[]{null, null, null, null}, oidb_0xeb7$StKingSignedListRsp.class);
    public oidb_0xeb7$Ret ret = new oidb_0xeb7$Ret();
    public oidb_0xeb7$StKingSignedInfo yesterdayFirst = new oidb_0xeb7$StKingSignedInfo();
    public final PBRepeatMessageField<oidb_0xeb7$StKingSignedInfo> topSignedTotal = PBField.initRepeatMessage(oidb_0xeb7$StKingSignedInfo.class);
    public final PBRepeatMessageField<oidb_0xeb7$StKingSignedInfo> topSignedContinue = PBField.initRepeatMessage(oidb_0xeb7$StKingSignedInfo.class);
}
