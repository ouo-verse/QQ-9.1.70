package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetRecommendWords$Classify extends MessageMicro<GetRecommendWords$Classify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "items"}, new Object[]{"", null}, GetRecommendWords$Classify.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<GetRecommendWords$ClassifyItem> items = PBField.initRepeatMessage(GetRecommendWords$ClassifyItem.class);
}
