package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$Wear extends MessageMicro<mutualmark$Wear> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"id", "modify_time"}, new Object[]{0L, 0L}, mutualmark$Wear.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBRepeatField<Long> f435959id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field modify_time = PBField.initUInt64(0);
}
