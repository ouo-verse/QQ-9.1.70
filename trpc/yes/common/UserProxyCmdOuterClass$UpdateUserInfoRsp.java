package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$UpdateUserInfoRsp extends MessageMicro<UserProxyCmdOuterClass$UpdateUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_info"}, new Object[]{null}, UserProxyCmdOuterClass$UpdateUserInfoRsp.class);
    public UserProxyCmdOuterClass$QQUserInfo user_info = new UserProxyCmdOuterClass$QQUserInfo();
}
