package tencent.im.group_pro_proto.oidb0xf9c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$Guild extends MessageMicro<common$Guild> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58, 64, 74}, new String[]{"id", "code", "name", "profile", "type", "avatar", "cover", "verify", "join_sig"}, new Object[]{0L, 0L, "", "", 0, "", "", Boolean.FALSE, ByteStringMicro.EMPTY}, common$Guild.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f435947id = PBField.initUInt64(0);
    public final PBUInt64Field code = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField profile = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField cover = PBField.initString("");
    public final PBBoolField verify = PBField.initBool(false);
    public final PBBytesField join_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
