package tencent.im.troop.flock;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QeventPB$JoinInfo extends MessageMicro<QeventPB$JoinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"id", "count", "user_list", "status"}, new Object[]{"", 0, null, 0}, QeventPB$JoinInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f436059id = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBRepeatMessageField<QeventPB$User> user_list = PBField.initRepeatMessage(QeventPB$User.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
}
