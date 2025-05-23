package tencent.im.group_pro_proto.oidb0xf9c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$Category extends MessageMicro<common$Category> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "name"}, new Object[]{0, ""}, common$Category.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f435946id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
}
