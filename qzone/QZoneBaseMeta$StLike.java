package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StLike extends MessageMicro<QZoneBaseMeta$StLike> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50}, new String[]{"id", "count", "status", "post_user", "owner_status", "like_mans"}, new Object[]{"", 0, 0, null, 0, null}, QZoneBaseMeta$StLike.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430336id = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public QZoneBaseMeta$StUser post_user = new QZoneBaseMeta$StUser();
    public final PBUInt32Field owner_status = PBField.initUInt32(0);
    public final PBRepeatMessageField<QZoneBaseMeta$StLikeMan> like_mans = PBField.initRepeatMessage(QZoneBaseMeta$StLikeMan.class);
}
