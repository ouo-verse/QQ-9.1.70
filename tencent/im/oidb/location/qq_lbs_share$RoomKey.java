package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qq_lbs_share$RoomKey extends MessageMicro<qq_lbs_share$RoomKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"aio_type", "id1", "id2"}, new Object[]{1, 0L, 0L}, qq_lbs_share$RoomKey.class);
    public final PBEnumField aio_type = PBField.initEnum(1);

    /* renamed from: id1, reason: collision with root package name */
    public final PBUInt64Field f436010id1 = PBField.initUInt64(0);

    /* renamed from: id2, reason: collision with root package name */
    public final PBUInt64Field f436011id2 = PBField.initUInt64(0);
}
