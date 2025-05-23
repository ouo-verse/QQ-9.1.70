package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class ArticleComment$PhotoItemInfo extends MessageMicro<ArticleComment$PhotoItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField content;
    public final PBUInt32Field height;
    public final PBBytesField static_url;
    public final PBBytesField url;
    public final PBUInt32Field width;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"url", "content", "static_url", "width", "height"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, ArticleComment$PhotoItemInfo.class);
    }

    public ArticleComment$PhotoItemInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.url = PBField.initBytes(byteStringMicro);
        this.content = PBField.initBytes(byteStringMicro);
        this.static_url = PBField.initBytes(byteStringMicro);
        this.width = PBField.initUInt32(0);
        this.height = PBField.initUInt32(0);
    }
}
