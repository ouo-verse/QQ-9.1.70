package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$GetShareQQFriendListReq extends MessageMicro<UserProxyCmdOuterClass$GetShareQQFriendListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin_list"}, new Object[]{0L}, UserProxyCmdOuterClass$GetShareQQFriendListReq.class);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
