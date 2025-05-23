package tencent.im.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class bin_0x21$Body extends MessageMicro<bin_0x21$Body> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 58, 64, 74}, new String[]{"group_code", "group_type", "member_uid", "opt", "admin_uid", "admin_name_len", "admin_name", "encrypt_len", "encrypt"}, new Object[]{0L, 0L, "", 0L, "", 0L, "", 0L, ""}, bin_0x21$Body.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field group_type = PBField.initUInt64(0);
    public final PBStringField member_uid = PBField.initString("");
    public final PBUInt64Field opt = PBField.initUInt64(0);
    public final PBStringField admin_uid = PBField.initString("");
    public final PBUInt64Field admin_name_len = PBField.initUInt64(0);
    public final PBStringField admin_name = PBField.initString("");
    public final PBUInt64Field encrypt_len = PBField.initUInt64(0);
    public final PBStringField encrypt = PBField.initString("");
}
