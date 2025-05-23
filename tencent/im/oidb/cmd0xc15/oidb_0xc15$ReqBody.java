package tencent.im.oidb.cmd0xc15;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc15$ReqBody extends MessageMicro<oidb_0xc15$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_common_data;
    public final PBBytesField bytes_cookie;
    public final PBBytesField bytes_puin;
    public final PBBytesField bytes_rowkey;
    public final PBUInt32Field uint32_want_count;
    public final PBUInt64Field uint64_article_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50}, new String[]{"bytes_cookie", "uint64_article_id", "bytes_rowkey", "bytes_common_data", "uint32_want_count", "bytes_puin"}, new Object[]{byteStringMicro, 0L, byteStringMicro, byteStringMicro, 0, byteStringMicro}, oidb_0xc15$ReqBody.class);
    }

    public oidb_0xc15$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_cookie = PBField.initBytes(byteStringMicro);
        this.uint64_article_id = PBField.initUInt64(0L);
        this.bytes_rowkey = PBField.initBytes(byteStringMicro);
        this.bytes_common_data = PBField.initBytes(byteStringMicro);
        this.uint32_want_count = PBField.initUInt32(0);
        this.bytes_puin = PBField.initBytes(byteStringMicro);
    }
}
