package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$CheckArticleLikeRespond extends MessageMicro<ArticleComment$CheckArticleLikeRespond> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ret", "data"}, new Object[]{null, null}, ArticleComment$CheckArticleLikeRespond.class);
    public ArticleComment$RetInfo ret = new ArticleComment$RetInfo();
    public final PBRepeatMessageField<ArticleComment$LikeRet> data = PBField.initRepeatMessage(ArticleComment$LikeRet.class);
}
