package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TianShuQuantityLimit$AdStatus extends MessageMicro<TianShuQuantityLimit$AdStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"iAdId", "actionList"}, new Object[]{0, null}, TianShuQuantityLimit$AdStatus.class);
    public final PBUInt32Field iAdId = PBField.initUInt32(0);
    public final PBRepeatMessageField<TianShuQuantityLimit$UserAction> actionList = PBField.initRepeatMessage(TianShuQuantityLimit$UserAction.class);
}
