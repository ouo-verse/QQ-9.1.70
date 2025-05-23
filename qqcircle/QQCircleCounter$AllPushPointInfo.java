package qqcircle;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleCounter$AllPushPointInfo extends MessageMicro<QQCircleCounter$AllPushPointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"wording", QQBrowserActivity.KEY_MSG_TYPE, "tabTipWording", "styleBottomTab"}, new Object[]{"", 0, "", null}, QQCircleCounter$AllPushPointInfo.class);
    public final PBStringField wording = PBField.initString("");
    public final PBUInt32Field msgType = PBField.initUInt32(0);
    public final PBStringField tabTipWording = PBField.initString("");
    public QQCircleCounterStyle$StyleTab styleBottomTab = new QQCircleCounterStyle$StyleTab();
}
