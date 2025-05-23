package tencent.im.oidb.ac;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$CheckArticleLikeRequest extends MessageMicro<ArticleComment$CheckArticleLikeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "uins"}, new Object[]{ByteStringMicro.EMPTY, 0L}, ArticleComment$CheckArticleLikeRequest.class);
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
