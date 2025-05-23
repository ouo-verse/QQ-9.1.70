package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class gallery$ExtTag extends MessageMicro<gallery$ExtTag> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon;
    public final PBBytesField bytes_tag_id;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"bytes_tag_id", "bytes_title", "bytes_icon", "bytes_url"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, gallery$ExtTag.class);
    }

    public gallery$ExtTag() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_tag_id = PBField.initBytes(byteStringMicro);
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_icon = PBField.initBytes(byteStringMicro);
        this.bytes_url = PBField.initBytes(byteStringMicro);
    }
}
