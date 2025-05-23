package tencent.im.troop.honor;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class troop_honor$UserHonor extends MessageMicro<troop_honor$UserHonor> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uin", "id", "level", "rich_flag"}, new Object[]{0L, 0, 0, 0}, troop_honor$UserHonor.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBRepeatField<Integer> f436062id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBUInt32Field rich_flag = PBField.initUInt32(0);
}
