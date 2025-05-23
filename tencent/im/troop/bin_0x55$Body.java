package tencent.im.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class bin_0x55$Body extends MessageMicro<bin_0x55$Body> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 66}, new String[]{"group_code", "group_type", "member_uid", "msg_len", "msg", "encrypt_len", "encrypt", "auth_gen_time"}, new Object[]{0L, 0L, "", 0L, "", "", "", ""}, bin_0x55$Body.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field group_type = PBField.initUInt64(0);
    public final PBStringField member_uid = PBField.initString("");
    public final PBUInt64Field msg_len = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436054msg = PBField.initString("");
    public final PBStringField encrypt_len = PBField.initString("");
    public final PBStringField encrypt = PBField.initString("");
    public final PBStringField auth_gen_time = PBField.initString("");
}
