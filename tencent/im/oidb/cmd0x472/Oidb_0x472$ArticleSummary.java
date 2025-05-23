package tencent.im.oidb.cmd0x472;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x472$ArticleSummary extends MessageMicro<Oidb_0x472$ArticleSummary> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_content_url;
    public final PBBytesField bytes_article_summary;
    public final PBBytesField bytes_article_title;
    public final PBBytesField bytes_first_page_pic_url;
    public final PBBytesField bytes_original_url;
    public final PBBytesField bytes_recommend_reason;
    public final PBBytesField bytes_subscribe_id;
    public final PBBytesField bytes_subscribe_name;
    public final PBUInt32Field uint32_comment_count;
    public final PBUInt32Field uint32_show_big_picture;
    public final PBUInt64Field uint64_algorithm_id;
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_recommend_seq;
    public final PBUInt64Field uint64_recommend_time;
    public final PBUInt64Field uint64_time;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 88, 96, 104, 112, 122}, new String[]{"uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_original_url", "bytes_article_content_url", "uint64_time", "uint32_comment_count", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_recommend_time", "uint64_recommend_seq", "uint32_show_big_picture", "uint64_algorithm_id", "bytes_recommend_reason"}, new Object[]{0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0, byteStringMicro, byteStringMicro, 0L, 0L, 0, 0L, byteStringMicro}, Oidb_0x472$ArticleSummary.class);
    }

    public Oidb_0x472$ArticleSummary() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_article_title = PBField.initBytes(byteStringMicro);
        this.bytes_article_summary = PBField.initBytes(byteStringMicro);
        this.bytes_first_page_pic_url = PBField.initBytes(byteStringMicro);
        this.bytes_original_url = PBField.initBytes(byteStringMicro);
        this.bytes_article_content_url = PBField.initBytes(byteStringMicro);
        this.uint64_time = PBField.initUInt64(0L);
        this.uint32_comment_count = PBField.initUInt32(0);
        this.bytes_subscribe_id = PBField.initBytes(byteStringMicro);
        this.bytes_subscribe_name = PBField.initBytes(byteStringMicro);
        this.uint64_recommend_time = PBField.initUInt64(0L);
        this.uint64_recommend_seq = PBField.initUInt64(0L);
        this.uint32_show_big_picture = PBField.initUInt32(0);
        this.uint64_algorithm_id = PBField.initUInt64(0L);
        this.bytes_recommend_reason = PBField.initBytes(byteStringMicro);
    }
}
