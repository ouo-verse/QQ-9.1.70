package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$GetShareQQFriendListRsp extends MessageMicro<UserProxyCmdOuterClass$GetShareQQFriendListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info_list"}, new Object[]{null}, UserProxyCmdOuterClass$GetShareQQFriendListRsp.class);
    public final PBRepeatMessageField<UserProxyCmdOuterClass$ShareFriendInfo> info_list = PBField.initRepeatMessage(UserProxyCmdOuterClass$ShareFriendInfo.class);
}
