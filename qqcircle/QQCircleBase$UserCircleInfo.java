package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StShare;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleBase$UserCircleInfo extends MessageMicro<QQCircleBase$UserCircleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 66}, new String[]{"id", "name", "circleType", "circleTab", "logo", "shareInfo", "tagId", "circleJumpUrl"}, new Object[]{"", "", 0, 0, "", null, "", ""}, QQCircleBase$UserCircleInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429293id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field circleType = PBField.initInt32(0);
    public final PBInt32Field circleTab = PBField.initInt32(0);
    public final PBStringField logo = PBField.initString("");
    public FeedCloudMeta$StShare shareInfo = new FeedCloudMeta$StShare();
    public final PBStringField tagId = PBField.initString("");
    public final PBStringField circleJumpUrl = PBField.initString("");
}
