package tencent.im.oidb.oidb_0xdc9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdc9$HonorInfo extends MessageMicro<oidb_0xdc9$HonorInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"id", "achieve", "day_count"}, new Object[]{0, 0, 0}, oidb_0xdc9$HonorInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f436015id = PBField.initUInt32(0);
    public final PBUInt32Field achieve = PBField.initUInt32(0);
    public final PBUInt32Field day_count = PBField.initUInt32(0);
}
