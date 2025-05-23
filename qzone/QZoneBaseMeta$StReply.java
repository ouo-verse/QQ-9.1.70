package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StReply extends MessageMicro<QZoneBaseMeta$StReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58}, new String[]{"id", QCircleAlphaUserReporter.KEY_USER, "content", "time", "client_key", "target_user", "like"}, new Object[]{"", null, null, 0L, "", null, null}, QZoneBaseMeta$StReply.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430338id = PBField.initString("");
    public QZoneBaseMeta$StUser user = new QZoneBaseMeta$StUser();
    public final PBRepeatMessageField<QZoneBaseMeta$StRichMsg> content = PBField.initRepeatMessage(QZoneBaseMeta$StRichMsg.class);
    public final PBInt64Field time = PBField.initInt64(0);
    public final PBStringField client_key = PBField.initString("");
    public QZoneBaseMeta$StUser target_user = new QZoneBaseMeta$StUser();
    public QZoneBaseMeta$StLike like = new QZoneBaseMeta$StLike();
}
