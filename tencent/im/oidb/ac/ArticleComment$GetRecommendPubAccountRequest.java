package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ArticleComment$GetRecommendPubAccountRequest extends MessageMicro<ArticleComment$GetRecommendPubAccountRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"version", "cuin", "count"}, new Object[]{"", 0L, 0}, ArticleComment$GetRecommendPubAccountRequest.class);
    public final PBStringField version = PBField.initString("");
    public final PBUInt64Field cuin = PBField.initUInt64(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
}
