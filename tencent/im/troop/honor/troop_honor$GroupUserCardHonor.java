package tencent.im.troop.honor;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class troop_honor$GroupUserCardHonor extends MessageMicro<troop_honor$GroupUserCardHonor> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"id", "level"}, new Object[]{0, 0}, troop_honor$GroupUserCardHonor.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBRepeatField<Integer> f436061id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field level = PBField.initUInt32(0);
}
