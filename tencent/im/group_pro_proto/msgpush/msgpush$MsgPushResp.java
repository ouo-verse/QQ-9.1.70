package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class msgpush$MsgPushResp extends MessageMicro<msgpush$MsgPushResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"server_buf"}, new Object[]{ByteStringMicro.EMPTY}, msgpush$MsgPushResp.class);
    public final PBBytesField server_buf = PBField.initBytes(ByteStringMicro.EMPTY);
}
