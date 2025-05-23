package ufo;

import com.qzone.common.business.result.QZoneResult;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$BatchVerifyUgcRightReq extends MessageMicro<UgcRight$BatchVerifyUgcRightReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"vuins", QZoneResult.UGC_KEY}, new Object[]{"", null}, UgcRight$BatchVerifyUgcRightReq.class);
    public final PBRepeatField<String> vuins = PBField.initRepeat(PBStringField.__repeatHelper__);
    public UgcRight$UgcDataKey ugc_key = new UgcRight$UgcDataKey();
}
