package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$BusiData extends MessageMicro<oidb_0xc26$BusiData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", QAdVrReportParams.ParamKey.MEDIA, "extra"}, new Object[]{0, null, ByteStringMicro.EMPTY}, oidb_0xc26$BusiData.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBRepeatMessageField<oidb_0xc26$BusiMediaData> media = PBField.initRepeatMessage(oidb_0xc26$BusiMediaData.class);
    public final PBBytesField extra = PBField.initBytes(ByteStringMicro.EMPTY);
}
