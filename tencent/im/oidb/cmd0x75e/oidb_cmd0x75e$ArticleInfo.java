package tencent.im.oidb.cmd0x75e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x75e$ArticleInfo extends MessageMicro<oidb_cmd0x75e$ArticleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_article_xml"}, new Object[]{ByteStringMicro.EMPTY}, oidb_cmd0x75e$ArticleInfo.class);
    public final PBBytesField bytes_article_xml = PBField.initBytes(ByteStringMicro.EMPTY);
}
