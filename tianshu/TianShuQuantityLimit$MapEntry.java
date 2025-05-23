package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TianShuQuantityLimit$MapEntry extends MessageMicro<TianShuQuantityLimit$MapEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"key", "license"}, new Object[]{0, null}, TianShuQuantityLimit$MapEntry.class);
    public final PBUInt32Field key = PBField.initUInt32(0);
    public TianShuQuantityLimit$AdLicense license = new TianShuQuantityLimit$AdLicense();
}
