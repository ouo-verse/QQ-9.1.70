package tencent.qun.group_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_activity$ReqBody extends MessageMicro<group_activity$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_act_id"}, new Object[]{0}, group_activity$ReqBody.class);
    public final PBRepeatField<Integer> uint32_act_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
