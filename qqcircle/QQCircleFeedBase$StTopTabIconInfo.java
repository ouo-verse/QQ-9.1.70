package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StTopTabIconInfo extends MessageMicro<QQCircleFeedBase$StTopTabIconInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56}, new String[]{"IconType", "text", "lightIconUrl", "lightIconSelectedUrl", "darkIconUrl", "darkIconSelectedUrl", "effectOnPageIcons"}, new Object[]{0, "", "", "", "", "", 0}, QQCircleFeedBase$StTopTabIconInfo.class);
    public final PBEnumField IconType = PBField.initEnum(0);
    public final PBStringField text = PBField.initString("");
    public final PBStringField lightIconUrl = PBField.initString("");
    public final PBStringField lightIconSelectedUrl = PBField.initString("");
    public final PBStringField darkIconUrl = PBField.initString("");
    public final PBStringField darkIconSelectedUrl = PBField.initString("");
    public final PBEnumField effectOnPageIcons = PBField.initEnum(0);
}
