package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TianShuQuantityLimit$UserAction extends MessageMicro<TianShuQuantityLimit$UserAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"action_id", "action_time", "action_value"}, new Object[]{0, 0L, 0L}, TianShuQuantityLimit$UserAction.class);
    public final PBEnumField action_id = PBField.initEnum(0);
    public final PBInt64Field action_time = PBField.initInt64(0);
    public final PBInt64Field action_value = PBField.initInt64(0);
}
