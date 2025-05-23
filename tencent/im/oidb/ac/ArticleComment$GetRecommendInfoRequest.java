package tencent.im.oidb.ac;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ArticleComment$GetRecommendInfoRequest extends MessageMicro<ArticleComment$GetRecommendInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"versionInfo", "cuin", AppConstants.Key.SHARE_REQ_ARTICLE_ID}, new Object[]{"", 0L, ByteStringMicro.EMPTY}, ArticleComment$GetRecommendInfoRequest.class);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBUInt64Field cuin = PBField.initUInt64(0);
    public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
