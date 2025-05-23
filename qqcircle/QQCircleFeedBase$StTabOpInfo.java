package qqcircle;

import com.qzone.widget.u;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StTabOpInfo extends MessageMicro<QQCircleFeedBase$StTabOpInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 34, 42, 50, 58, 66, 74}, new String[]{u.COLUMN_TAB_ID, "tabIconInfo", "jumpUrlInfo", "tabPoolID", "tabReddotInfo", "effectiveTimeRange", "livingRoomID", "qliveSceneID"}, new Object[]{"", null, null, "", null, null, "", ""}, QQCircleFeedBase$StTabOpInfo.class);
    public final PBStringField tab_id = PBField.initString("");
    public QQCircleFeedBase$StTopTabIconInfo tabIconInfo = new QQCircleFeedBase$StTopTabIconInfo();
    public QQCircleFeedBase$StTabJumpUrlInfo jumpUrlInfo = new QQCircleFeedBase$StTabJumpUrlInfo();
    public final PBStringField tabPoolID = PBField.initString("");
    public QQCircleFeedBase$StTobTabReddotInfo tabReddotInfo = new QQCircleFeedBase$StTobTabReddotInfo();
    public final PBRepeatMessageField<QQCircleFeedBase$StTabEffectiveTimeRange> effectiveTimeRange = PBField.initRepeatMessage(QQCircleFeedBase$StTabEffectiveTimeRange.class);
    public final PBStringField livingRoomID = PBField.initString("");
    public final PBStringField qliveSceneID = PBField.initString("");
}
