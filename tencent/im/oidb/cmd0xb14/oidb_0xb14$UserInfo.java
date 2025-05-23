package tencent.im.oidb.cmd0xb14;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb14$UserInfo extends MessageMicro<oidb_0xb14$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uin", "id", "course", "name"}, new Object[]{0L, 0, "", ""}, oidb_0xb14$UserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f435983id = PBField.initUInt32(0);
    public final PBStringField course = PBField.initString("");
    public final PBStringField name = PBField.initString("");
}
