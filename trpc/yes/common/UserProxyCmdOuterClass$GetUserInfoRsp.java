package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$GetUserInfoRsp extends MessageMicro<UserProxyCmdOuterClass$GetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"user_info", "route_list"}, new Object[]{null, null}, UserProxyCmdOuterClass$GetUserInfoRsp.class);
    public UserProxyCmdOuterClass$QQUserInfo user_info = new UserProxyCmdOuterClass$QQUserInfo();
    public CommonOuterClass$OnlineRouteInfoList route_list = new CommonOuterClass$OnlineRouteInfoList();
}
