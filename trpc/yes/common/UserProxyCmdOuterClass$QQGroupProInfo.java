package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$QQGroupProInfo extends MessageMicro<UserProxyCmdOuterClass$QQGroupProInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"joined_guild_info_list", "group_pro_user_info"}, new Object[]{null, null}, UserProxyCmdOuterClass$QQGroupProInfo.class);
    public final PBRepeatMessageField<UserProxyCmdOuterClass$JoinedGuildInfo> joined_guild_info_list = PBField.initRepeatMessage(UserProxyCmdOuterClass$JoinedGuildInfo.class);
    public UserProxyCmdOuterClass$QQGroupProUserInfo group_pro_user_info = new UserProxyCmdOuterClass$QQGroupProUserInfo();
}
