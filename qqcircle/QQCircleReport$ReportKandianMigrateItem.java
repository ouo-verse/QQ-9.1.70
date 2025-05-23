package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleReport$ReportKandianMigrateItem extends MessageMicro<QQCircleReport$ReportKandianMigrateItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56}, new String[]{"feed_id", "feed_author_id", "comment_reply_num", "favor_num", "play_num", "share_num", "rocket_num"}, new Object[]{"", "", 0, 0, 0, 0, 0}, QQCircleReport$ReportKandianMigrateItem.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField feed_author_id = PBField.initString("");
    public final PBInt32Field comment_reply_num = PBField.initInt32(0);
    public final PBInt32Field favor_num = PBField.initInt32(0);
    public final PBInt32Field play_num = PBField.initInt32(0);
    public final PBInt32Field share_num = PBField.initInt32(0);
    public final PBInt32Field rocket_num = PBField.initInt32(0);
}
