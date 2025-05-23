package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFriendFeedMomentReader$SimpleFeed extends MessageMicro<QQCircleFriendFeedMomentReader$SimpleFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 82, 90}, new String[]{"id", "owner", "time", "cover", "play_param"}, new Object[]{"", 0L, 0L, "", ""}, QQCircleFriendFeedMomentReader$SimpleFeed.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429306id = PBField.initString("");
    public final PBUInt64Field owner = PBField.initUInt64(0);
    public final PBInt64Field time = PBField.initInt64(0);
    public final PBStringField cover = PBField.initString("");
    public final PBStringField play_param = PBField.initString("");
}
