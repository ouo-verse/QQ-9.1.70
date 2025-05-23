package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x87a$FSQInfo extends MessageMicro<oidb_0x87a$FSQInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fsq_sig;
    public final PBBytesField bytes_rand_str;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_fsq_sig", "bytes_rand_str"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_0x87a$FSQInfo.class);
    }

    public oidb_0x87a$FSQInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fsq_sig = PBField.initBytes(byteStringMicro);
        this.bytes_rand_str = PBField.initBytes(byteStringMicro);
    }
}
