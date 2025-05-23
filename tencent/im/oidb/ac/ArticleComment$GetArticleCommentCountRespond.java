package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$GetArticleCommentCountRespond extends MessageMicro<ArticleComment$GetArticleCommentCountRespond> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ret", "count"}, new Object[]{null, 0}, ArticleComment$GetArticleCommentCountRespond.class);
    public ArticleComment$RetInfo ret = new ArticleComment$RetInfo();
    public final PBUInt32Field count = PBField.initUInt32(0);
}
