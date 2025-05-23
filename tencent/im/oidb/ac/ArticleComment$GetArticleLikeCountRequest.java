package tencent.im.oidb.ac;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$GetArticleLikeCountRequest extends MessageMicro<ArticleComment$GetArticleLikeCountRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID}, new Object[]{ByteStringMicro.EMPTY}, ArticleComment$GetArticleLikeCountRequest.class);
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
