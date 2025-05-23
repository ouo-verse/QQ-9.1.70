package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import cooperation.vip.tianshu.TianShuMMKVConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TianShuQuantityLimit$AdLicense extends MessageMicro<TianShuQuantityLimit$AdLicense> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW}, new Object[]{Boolean.FALSE}, TianShuQuantityLimit$AdLicense.class);
    public final PBBoolField canShow = PBField.initBool(false);
}
