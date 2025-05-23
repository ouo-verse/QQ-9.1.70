package tencent.im.oidb.oidb_0xdc9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdc9$HonorList extends MessageMicro<oidb_0xdc9$HonorList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_id", "id", "is_gray"}, new Object[]{0L, 0, 0}, oidb_0xdc9$HonorList.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBRepeatField<Integer> f436016id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field is_gray = PBField.initUInt32(0);
}
