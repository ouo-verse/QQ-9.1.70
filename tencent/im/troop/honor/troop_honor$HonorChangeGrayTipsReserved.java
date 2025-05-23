package tencent.im.troop.honor;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class troop_honor$HonorChangeGrayTipsReserved extends MessageMicro<troop_honor$HonorChangeGrayTipsReserved> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_honor"}, new Object[]{null}, troop_honor$HonorChangeGrayTipsReserved.class);
    public final PBRepeatMessageField<troop_honor$UserHonor> user_honor = PBField.initRepeatMessage(troop_honor$UserHonor.class);
}
