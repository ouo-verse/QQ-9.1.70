package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StGetRankingListBusiReqData extends MessageMicro<QQCircleFeedBase$StGetRankingListBusiReqData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tagName"}, new Object[]{""}, QQCircleFeedBase$StGetRankingListBusiReqData.class);
    public final PBStringField tagName = PBField.initString("");
}
