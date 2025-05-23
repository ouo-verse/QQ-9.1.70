package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$SimpleRankItem extends MessageMicro<QQCircleRankinglist$SimpleRankItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"rank", "listType", "rankTitle", "tagId"}, new Object[]{0, 0, "", ""}, QQCircleRankinglist$SimpleRankItem.class);
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBInt32Field listType = PBField.initInt32(0);
    public final PBStringField rankTitle = PBField.initString("");
    public final PBStringField tagId = PBField.initString("");
}
