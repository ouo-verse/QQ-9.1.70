package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MutualMarkCard$RspBody extends MessageMicro<MutualMarkCard$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"state", "guide", "total_count", "home_url"}, new Object[]{null, null, 0, ""}, MutualMarkCard$RspBody.class);
    public final PBRepeatMessageField<mutualmark$State> state = PBField.initRepeatMessage(mutualmark$State.class);
    public MutualMarkCard$Guide guide = new MutualMarkCard$Guide();
    public final PBUInt32Field total_count = PBField.initUInt32(0);
    public final PBStringField home_url = PBField.initString("");
}
