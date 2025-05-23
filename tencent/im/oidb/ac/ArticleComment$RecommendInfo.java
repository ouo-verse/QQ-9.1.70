package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$RecommendInfo extends MessageMicro<ArticleComment$RecommendInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField echo_info;
    public final PBBytesField rowkey;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rowkey", "echo_info"}, new Object[]{byteStringMicro, byteStringMicro}, ArticleComment$RecommendInfo.class);
    }

    public ArticleComment$RecommendInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.rowkey = PBField.initBytes(byteStringMicro);
        this.echo_info = PBField.initBytes(byteStringMicro);
    }
}
