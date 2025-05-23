package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$GetArkMsgBodyReq extends MessageMicro<UserProxyCmdOuterClass$GetArkMsgBodyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"type", "game_id", "uid", "qquserid"}, new Object[]{0, 0, 0L, null}, UserProxyCmdOuterClass$GetArkMsgBodyReq.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId qquserid = new CommonOuterClass$QQUserId();
}
