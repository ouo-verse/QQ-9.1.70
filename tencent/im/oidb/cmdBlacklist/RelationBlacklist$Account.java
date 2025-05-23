package tencent.im.oidb.cmdBlacklist;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RelationBlacklist$Account extends MessageMicro<RelationBlacklist$Account> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"type", "encrypted", "uin", "phone", "openid"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, "", ""}, RelationBlacklist$Account.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBBytesField encrypted = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField phone = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
}
