package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$CircleFuelMedalQueryItem extends MessageMicro<QQCircleRankinglist$CircleFuelMedalQueryItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uid", "tidList"}, new Object[]{"", ""}, QQCircleRankinglist$CircleFuelMedalQueryItem.class);
    public final PBStringField uid = PBField.initString("");
    public final PBRepeatField<String> tidList = PBField.initRepeat(PBStringField.__repeatHelper__);
}
