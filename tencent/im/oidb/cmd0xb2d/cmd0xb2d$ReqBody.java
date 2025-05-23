package tencent.im.oidb.cmd0xb2d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xb2d$ReqBody extends MessageMicro<cmd0xb2d$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_context;
    public final PBBytesField bytes_gallery_rowkey;
    public final PBRepeatField<ByteStringMicro> bytes_gallery_rowkey_list;
    public final PBInt32Field int32_source;
    public cmd0xb2d$PageReq msg_page_req;
    public final PBUInt32Field uint32_need_attch_comments;
    public final PBUInt32Field uint32_need_social_info;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 56}, new String[]{"bytes_gallery_rowkey", "bytes_gallery_rowkey_list", "int32_source", "msg_page_req", "bytes_context", "uint32_need_social_info", "uint32_need_attch_comments"}, new Object[]{byteStringMicro, byteStringMicro, 0, null, byteStringMicro, 0, 0}, cmd0xb2d$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [tencent.im.oidb.cmd0xb2d.cmd0xb2d$PageReq] */
    public cmd0xb2d$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_gallery_rowkey = PBField.initBytes(byteStringMicro);
        this.bytes_gallery_rowkey_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.int32_source = PBField.initInt32(0);
        this.msg_page_req = new MessageMicro<cmd0xb2d$PageReq>() { // from class: tencent.im.oidb.cmd0xb2d.cmd0xb2d$PageReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_size", "bytes_cookies"}, new Object[]{0, ByteStringMicro.EMPTY}, cmd0xb2d$PageReq.class);
            public final PBUInt32Field uint32_size = PBField.initUInt32(0);
            public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        this.bytes_context = PBField.initBytes(byteStringMicro);
        this.uint32_need_social_info = PBField.initUInt32(0);
        this.uint32_need_attch_comments = PBField.initUInt32(0);
    }
}
