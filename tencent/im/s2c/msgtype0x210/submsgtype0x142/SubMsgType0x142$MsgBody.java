package tencent.im.s2c.msgtype0x210.submsgtype0x142;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x142$MsgBody extends MessageMicro<SubMsgType0x142$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"int32_push_cmd", "bytes_push_body"}, new Object[]{0, ByteStringMicro.EMPTY}, SubMsgType0x142$MsgBody.class);
    public final PBInt32Field int32_push_cmd = PBField.initInt32(0);
    public final PBBytesField bytes_push_body = PBField.initBytes(ByteStringMicro.EMPTY);
}
