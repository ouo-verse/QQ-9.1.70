package tencent.im.oidb.submsgtype0x138;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x138$MsgBody extends MessageMicro<Submsgtype0x138$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_bussi_type", "bytes_msg_data"}, new Object[]{0, ByteStringMicro.EMPTY}, Submsgtype0x138$MsgBody.class);
    public final PBUInt32Field uint32_bussi_type = PBField.initUInt32(0);
    public final PBBytesField bytes_msg_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
