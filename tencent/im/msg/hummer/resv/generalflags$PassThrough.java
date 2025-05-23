package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class generalflags$PassThrough extends MessageMicro<generalflags$PassThrough> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_av_terminate_ext;
    public final PBBytesField bytes_qqconnect_message_ext;
    public final PBBytesField bytes_qqconnect_tag_name;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_av_terminate_ext", "bytes_qqconnect_tag_name", "bytes_qqconnect_message_ext"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, generalflags$PassThrough.class);
    }

    public generalflags$PassThrough() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_av_terminate_ext = PBField.initBytes(byteStringMicro);
        this.bytes_qqconnect_tag_name = PBField.initBytes(byteStringMicro);
        this.bytes_qqconnect_message_ext = PBField.initBytes(byteStringMicro);
    }
}
