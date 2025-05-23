package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StHotCommentReportInfo extends MessageMicro<QQCircleFeedBase$StHotCommentReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"reportID", "reportData"}, new Object[]{"", ""}, QQCircleFeedBase$StHotCommentReportInfo.class);
    public final PBStringField reportID = PBField.initString("");
    public final PBStringField reportData = PBField.initString("");
}
