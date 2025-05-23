package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TianShuQuantityLimit$GetAdLicenseReq extends MessageMicro<TianShuQuantityLimit$GetAdLicenseReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"stComminfo", "adList"}, new Object[]{null, null}, TianShuQuantityLimit$GetAdLicenseReq.class);
    public TianShuQuantityLimit$CommInfo stComminfo = new TianShuQuantityLimit$CommInfo();
    public final PBRepeatMessageField<TianShuQuantityLimit$AdStatus> adList = PBField.initRepeatMessage(TianShuQuantityLimit$AdStatus.class);
}
