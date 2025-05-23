package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StComment extends MessageMicro<QZoneBaseMeta$StComment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 58, 66, 74}, new String[]{"id", QCircleAlphaUserReporter.KEY_USER, "content", "time", "replys", "reply_num", "client_key", "media_items", "like"}, new Object[]{"", null, null, 0L, null, 0L, "", null, null}, QZoneBaseMeta$StComment.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430334id = PBField.initString("");
    public QZoneBaseMeta$StUser user = new QZoneBaseMeta$StUser();
    public final PBRepeatMessageField<QZoneBaseMeta$StRichMsg> content = PBField.initRepeatMessage(QZoneBaseMeta$StRichMsg.class);
    public final PBInt64Field time = PBField.initInt64(0);
    public final PBRepeatMessageField<QZoneBaseMeta$StReply> replys = PBField.initRepeatMessage(QZoneBaseMeta$StReply.class);
    public final PBInt64Field reply_num = PBField.initInt64(0);
    public final PBStringField client_key = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StMedia> media_items = PBField.initRepeatMessage(QZoneBaseMeta$StMedia.class);
    public QZoneBaseMeta$StLike like = new QZoneBaseMeta$StLike();
}
