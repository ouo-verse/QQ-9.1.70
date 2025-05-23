package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$CreateArticleCommentRespond extends MessageMicro<ArticleComment$CreateArticleCommentRespond> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ret", "comment_id"}, new Object[]{null, ByteStringMicro.EMPTY}, ArticleComment$CreateArticleCommentRespond.class);
    public ArticleComment$RetInfo ret = new ArticleComment$RetInfo();
    public final PBBytesField comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
