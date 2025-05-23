package tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$ResourceInfo extends MessageMicro<mutualmark$ResourceInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cartoon_md5;
    public final PBBytesField bytes_cartoon_url;
    public final PBBytesField bytes_dynamic_url;
    public final PBBytesField bytes_static_url;
    public final PBBytesField bytes_word;
    public final PBUInt32Field uint32_play_cartoon;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50}, new String[]{"bytes_dynamic_url", "bytes_static_url", "bytes_cartoon_url", "bytes_cartoon_md5", "uint32_play_cartoon", "bytes_word"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro}, mutualmark$ResourceInfo.class);
    }

    public mutualmark$ResourceInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_dynamic_url = PBField.initBytes(byteStringMicro);
        this.bytes_static_url = PBField.initBytes(byteStringMicro);
        this.bytes_cartoon_url = PBField.initBytes(byteStringMicro);
        this.bytes_cartoon_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_play_cartoon = PBField.initUInt32(0);
        this.bytes_word = PBField.initBytes(byteStringMicro);
    }
}
