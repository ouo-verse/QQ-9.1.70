package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$RelationIcon extends MessageMicro<QZIntimateSpaceReader$RelationIcon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"relation_icon", "icon_description", "memberUid"}, new Object[]{"", "", ""}, QZIntimateSpaceReader$RelationIcon.class);
    public final PBStringField relation_icon = PBField.initString("");
    public final PBStringField icon_description = PBField.initString("");
    public final PBStringField memberUid = PBField.initString("");
}
