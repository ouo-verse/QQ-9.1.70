package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$ArkMsgInfo extends MessageMicro<UserProxyCmdOuterClass$ArkMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"text_msg", "recv_info_list", "send_uin", "meta_json"}, new Object[]{"", null, 0L, ""}, UserProxyCmdOuterClass$ArkMsgInfo.class);
    public final PBStringField text_msg = PBField.initString("");
    public final PBRepeatMessageField<UserProxyCmdOuterClass$ArkMsgRecvInfo> recv_info_list = PBField.initRepeatMessage(UserProxyCmdOuterClass$ArkMsgRecvInfo.class);
    public final PBUInt64Field send_uin = PBField.initUInt64(0);
    public final PBStringField meta_json = PBField.initString("");
}
