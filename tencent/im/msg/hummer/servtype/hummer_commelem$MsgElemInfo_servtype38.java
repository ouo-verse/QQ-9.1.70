package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype38 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype38> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_react_data;
    public final PBBytesField bytes_reply_data;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_react_data", "bytes_reply_data"}, new Object[]{byteStringMicro, byteStringMicro}, hummer_commelem$MsgElemInfo_servtype38.class);
    }

    public hummer_commelem$MsgElemInfo_servtype38() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_react_data = PBField.initBytes(byteStringMicro);
        this.bytes_reply_data = PBField.initBytes(byteStringMicro);
    }
}
