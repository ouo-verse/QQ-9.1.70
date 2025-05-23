package tencent.im.oidb.oidb_0xde7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xde7$ReqBody extends MessageMicro<oidb_0xde7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint64_longnick_uin", "str_longnick_id", "uint64_from_uin", "uint64_comment_id"}, new Object[]{0L, "", 0L, 0L}, oidb_0xde7$ReqBody.class);
    public final PBUInt64Field uint64_longnick_uin = PBField.initUInt64(0);
    public final PBStringField str_longnick_id = PBField.initString("");
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_comment_id = PBField.initUInt64(0);
}
