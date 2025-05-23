package tencent.im.group_pro_proto.msg_responses_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgResponsesSvr$MsgId extends MessageMicro<MsgResponsesSvr$MsgId> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"msg_version", "msg_seq"}, new Object[]{0L, 0L}, MsgResponsesSvr$MsgId.class);
    public final PBUInt64Field msg_version = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
}
