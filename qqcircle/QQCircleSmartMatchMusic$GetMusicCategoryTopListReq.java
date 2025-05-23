package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$GetMusicCategoryTopListReq extends MessageMicro<QQCircleSmartMatchMusic$GetMusicCategoryTopListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"categoryID", "attachInfo"}, new Object[]{"", ""}, QQCircleSmartMatchMusic$GetMusicCategoryTopListReq.class);
    public final PBStringField categoryID = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
}
