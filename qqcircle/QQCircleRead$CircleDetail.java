package qqcircle;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$CircleDetail extends MessageMicro<QQCircleRead$CircleDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 58}, new String[]{"id", "name", "circleType", "memberCount", PhotoCategorySummaryInfo.AVATAR_URL}, new Object[]{"", "", 0, 0L, ""}, QQCircleRead$CircleDetail.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429312id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field circleType = PBField.initInt32(0);
    public final PBInt64Field memberCount = PBField.initInt64(0);
    public final PBStringField avatarUrl = PBField.initString("");
}
