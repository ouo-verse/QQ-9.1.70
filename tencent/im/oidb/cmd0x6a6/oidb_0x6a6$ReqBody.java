package tencent.im.oidb.cmd0x6a6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6a6$ReqBody extends MessageMicro<oidb_0x6a6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_id;
    public final PBInt32Field int32_init_read_count;
    public final PBBytesField rowkey;
    public final PBUInt32Field uint32_article_type;
    public final PBUInt32Field uint32_platform_type;
    public final PBUInt32Field uint32_req_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50}, new String[]{"bytes_article_id", "uint32_req_type", "uint32_article_type", "uint32_platform_type", "int32_init_read_count", "rowkey"}, new Object[]{byteStringMicro, 0, 0, 0, 0, byteStringMicro}, oidb_0x6a6$ReqBody.class);
    }

    public oidb_0x6a6$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_article_id = PBField.initBytes(byteStringMicro);
        this.uint32_req_type = PBField.initUInt32(0);
        this.uint32_article_type = PBField.initUInt32(0);
        this.uint32_platform_type = PBField.initUInt32(0);
        this.int32_init_read_count = PBField.initInt32(0);
        this.rowkey = PBField.initBytes(byteStringMicro);
    }
}
