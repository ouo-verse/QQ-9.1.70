package tencent.im.oidb.cmd0x439;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x439$ArticleInfo extends MessageMicro<oidb_cmd0x439$ArticleInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_subject;
    public final PBBytesField bytes_article_sum_pic;
    public final PBBytesField bytes_article_url;
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint64_article_id", "bytes_article_subject", "bytes_article_url", "bytes_article_sum_pic"}, new Object[]{0L, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_cmd0x439$ArticleInfo.class);
    }

    public oidb_cmd0x439$ArticleInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_article_subject = PBField.initBytes(byteStringMicro);
        this.bytes_article_url = PBField.initBytes(byteStringMicro);
        this.bytes_article_sum_pic = PBField.initBytes(byteStringMicro);
    }
}
