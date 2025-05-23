package tencent.im.oidb.cmd0xc16;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc16$ReqBody extends MessageMicro<oidb_cmd0xc16$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_topic_cover_pic_url;
    public final PBBytesField bytes_topic_desc;
    public final PBBytesField bytes_topic_pic_url;
    public final PBBytesField bytes_topic_title;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uint64_uin", "bytes_topic_title", "bytes_topic_desc", "bytes_topic_pic_url", "bytes_topic_cover_pic_url"}, new Object[]{0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_cmd0xc16$ReqBody.class);
    }

    public oidb_cmd0xc16$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_topic_title = PBField.initBytes(byteStringMicro);
        this.bytes_topic_desc = PBField.initBytes(byteStringMicro);
        this.bytes_topic_pic_url = PBField.initBytes(byteStringMicro);
        this.bytes_topic_cover_pic_url = PBField.initBytes(byteStringMicro);
    }
}
