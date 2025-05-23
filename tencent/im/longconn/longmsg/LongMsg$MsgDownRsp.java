package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class LongMsg$MsgDownRsp extends MessageMicro<LongMsg$MsgDownRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_content;
    public final PBBytesField bytes_msg_resid;
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "bytes_msg_resid", "bytes_msg_content"}, new Object[]{0, byteStringMicro, byteStringMicro}, LongMsg$MsgDownRsp.class);
    }

    public LongMsg$MsgDownRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_resid = PBField.initBytes(byteStringMicro);
        this.bytes_msg_content = PBField.initBytes(byteStringMicro);
    }
}
