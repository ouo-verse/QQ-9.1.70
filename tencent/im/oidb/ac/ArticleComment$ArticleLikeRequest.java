package tencent.im.oidb.ac;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$ArticleLikeRequest extends MessageMicro<ArticleComment$ArticleLikeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{AppConstants.Key.SHARE_REQ_ARTICLE_ID, "uin", "like", "pin"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0, 0}, ArticleComment$ArticleLikeRequest.class);
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field like = PBField.initUInt32(0);
    public final PBUInt32Field pin = PBField.initUInt32(0);
}
