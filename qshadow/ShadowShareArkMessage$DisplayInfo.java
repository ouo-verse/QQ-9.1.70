package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowShareArkMessage$DisplayInfo extends MessageMicro<ShadowShareArkMessage$DisplayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"title", "desc", "imageUrl", "iconName", "iconUrl"}, new Object[]{"", "", "", "", ""}, ShadowShareArkMessage$DisplayInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField imageUrl = PBField.initString("");
    public final PBStringField iconName = PBField.initString("");
    public final PBStringField iconUrl = PBField.initString("");
}
