package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$MusicCategoryInfo extends MessageMicro<QQCircleSmartMatchMusic$MusicCategoryInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"categoryID", "categoryName", "categoryPicture"}, new Object[]{"", "", ""}, QQCircleSmartMatchMusic$MusicCategoryInfo.class);
    public final PBStringField categoryID = PBField.initString("");
    public final PBStringField categoryName = PBField.initString("");
    public final PBStringField categoryPicture = PBField.initString("");
}
