package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class ArticleComment$PhotoFirstItemInfo extends MessageMicro<ArticleComment$PhotoFirstItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField photo_author_name;
    public final PBBytesField photo_time;
    public final PBBytesField publicaccount_name;
    public final PBBytesField url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"url", "photo_time", "photo_author_name", "publicaccount_name"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, ArticleComment$PhotoFirstItemInfo.class);
    }

    public ArticleComment$PhotoFirstItemInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.url = PBField.initBytes(byteStringMicro);
        this.photo_time = PBField.initBytes(byteStringMicro);
        this.photo_author_name = PBField.initBytes(byteStringMicro);
        this.publicaccount_name = PBField.initBytes(byteStringMicro);
    }
}
