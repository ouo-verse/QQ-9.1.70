package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StRewardData extends MessageMicro<QQCircleFeedBase$StRewardData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"myMoney", "myMoneyWithDraw"}, new Object[]{0L, 0L}, QQCircleFeedBase$StRewardData.class);
    public final PBInt64Field myMoney = PBField.initInt64(0);
    public final PBInt64Field myMoneyWithDraw = PBField.initInt64(0);
}
