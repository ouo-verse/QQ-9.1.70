package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleCounter$PreRecommendFeedInfo extends MessageMicro<QQCircleCounter$PreRecommendFeedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40}, new String[]{"feedId", "createTs", "feedAuthor", "opUser", "opTs"}, new Object[]{"", 0L, "", "", 0L}, QQCircleCounter$PreRecommendFeedInfo.class);
    public final PBStringField feedId = PBField.initString("");
    public final PBInt64Field createTs = PBField.initInt64(0);
    public final PBStringField feedAuthor = PBField.initString("");
    public final PBStringField opUser = PBField.initString("");
    public final PBInt64Field opTs = PBField.initInt64(0);
}
