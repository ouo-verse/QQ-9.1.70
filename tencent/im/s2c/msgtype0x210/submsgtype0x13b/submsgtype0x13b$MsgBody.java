package tencent.im.s2c.msgtype0x210.submsgtype0x13b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x13b$MsgBody extends MessageMicro<submsgtype0x13b$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"op", "uint64_mute_friend"}, new Object[]{2, 0L}, submsgtype0x13b$MsgBody.class);

    /* renamed from: op, reason: collision with root package name */
    public final PBEnumField f436050op = PBField.initEnum(2);
    public final PBUInt64Field uint64_mute_friend = PBField.initUInt64(0);
}
