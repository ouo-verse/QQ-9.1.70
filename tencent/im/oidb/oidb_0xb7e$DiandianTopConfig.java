package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb7e$DiandianTopConfig extends MessageMicro<oidb_0xb7e$DiandianTopConfig> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url;
    public final PBBytesField bytes_pic_url;
    public final PBBytesField bytes_sub_title;
    public final PBBytesField bytes_sub_title_color;
    public final PBBytesField bytes_title;
    public final PBUInt32Field uint32_topic_id;
    public final PBUInt32Field uint32_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56}, new String[]{"bytes_jump_url", "bytes_title", "bytes_sub_title", "bytes_sub_title_color", "bytes_pic_url", "uint32_type", "uint32_topic_id"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, oidb_0xb7e$DiandianTopConfig.class);
    }

    public oidb_0xb7e$DiandianTopConfig() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_jump_url = PBField.initBytes(byteStringMicro);
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_sub_title = PBField.initBytes(byteStringMicro);
        this.bytes_sub_title_color = PBField.initBytes(byteStringMicro);
        this.bytes_pic_url = PBField.initBytes(byteStringMicro);
        this.uint32_type = PBField.initUInt32(0);
        this.uint32_topic_id = PBField.initUInt32(0);
    }
}
