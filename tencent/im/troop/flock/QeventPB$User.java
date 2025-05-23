package tencent.im.troop.flock;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QeventPB$User extends MessageMicro<QeventPB$User> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 56}, new String[]{"id", "nick", "icon", "sex", "age", "location", "frd_state"}, new Object[]{"", "", null, 0, 0L, "", 0}, QeventPB$User.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f436060id = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public QeventPB$IconInfo icon = new QeventPB$IconInfo();
    public final PBUInt32Field sex = PBField.initUInt32(0);
    public final PBUInt64Field age = PBField.initUInt64(0);
    public final PBStringField location = PBField.initString("");
    public final PBUInt32Field frd_state = PBField.initUInt32(0);
}
