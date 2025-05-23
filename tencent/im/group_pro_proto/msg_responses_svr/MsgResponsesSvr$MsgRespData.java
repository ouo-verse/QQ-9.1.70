package tencent.im.group_pro_proto.msg_responses_svr;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgResponsesSvr$MsgRespData extends MessageMicro<MsgResponsesSvr$MsgRespData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_id", "msg_cnt"}, new Object[]{null, ByteStringMicro.EMPTY}, MsgResponsesSvr$MsgRespData.class);
    public MsgResponsesSvr$MsgId msg_id = new MsgResponsesSvr$MsgId();
    public final PBBytesField msg_cnt = PBField.initBytes(ByteStringMicro.EMPTY);
}
