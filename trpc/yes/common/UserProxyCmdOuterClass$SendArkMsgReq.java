package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$SendArkMsgReq extends MessageMicro<UserProxyCmdOuterClass$SendArkMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"type", "info", "game_id"}, new Object[]{0, null, 0}, UserProxyCmdOuterClass$SendArkMsgReq.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public UserProxyCmdOuterClass$ArkMsgInfo info = new UserProxyCmdOuterClass$ArkMsgInfo();
    public final PBInt32Field game_id = PBField.initInt32(0);
}
