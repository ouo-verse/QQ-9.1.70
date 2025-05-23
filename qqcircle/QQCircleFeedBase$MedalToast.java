package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$MedalToast extends MessageMicro<QQCircleFeedBase$MedalToast> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58}, new String[]{"content", "leftButtonName", "rightButtonName", "leftButtonJumpUrl", "leftButtonAction", "rightButtonAction", "title"}, new Object[]{"", "", "", "", 1, 1, ""}, QQCircleFeedBase$MedalToast.class);
    public final PBStringField content = PBField.initString("");
    public final PBStringField leftButtonName = PBField.initString("");
    public final PBStringField rightButtonName = PBField.initString("");
    public final PBStringField leftButtonJumpUrl = PBField.initString("");
    public final PBEnumField leftButtonAction = PBField.initEnum(1);
    public final PBEnumField rightButtonAction = PBField.initEnum(1);
    public final PBStringField title = PBField.initString("");
}
