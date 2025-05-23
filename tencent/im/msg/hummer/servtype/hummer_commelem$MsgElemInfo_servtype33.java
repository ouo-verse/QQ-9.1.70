package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype33 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype33> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buf;
    public final PBBytesField bytes_compat;
    public final PBBytesField bytes_text;
    public final PBUInt32Field uint32_index = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_index", "bytes_text", "bytes_compat", "bytes_buf"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro}, hummer_commelem$MsgElemInfo_servtype33.class);
    }

    public hummer_commelem$MsgElemInfo_servtype33() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_text = PBField.initBytes(byteStringMicro);
        this.bytes_compat = PBField.initBytes(byteStringMicro);
        this.bytes_buf = PBField.initBytes(byteStringMicro);
    }
}
