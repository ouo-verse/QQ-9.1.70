package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$JoinedGuildInfo extends MessageMicro<UserProxyCmdOuterClass$JoinedGuildInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"guild_id", "join_time", "member_nick"}, new Object[]{0L, 0L, ""}, UserProxyCmdOuterClass$JoinedGuildInfo.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field join_time = PBField.initUInt64(0);
    public final PBStringField member_nick = PBField.initString("");
}
