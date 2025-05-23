package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$QQGroupProUserInfo extends MessageMicro<UserProxyCmdOuterClass$QQGroupProUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"tinyid", "nick", "avatar", "full_age", "gender"}, new Object[]{0L, "", "", "", 0}, UserProxyCmdOuterClass$QQGroupProUserInfo.class);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField full_age = PBField.initString("");
    public final PBUInt32Field gender = PBField.initUInt32(0);
}
