package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StShare;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StUnifiedTagPageData extends MessageMicro<QQCircleFeedBase$StUnifiedTagPageData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50}, new String[]{"title", "pageIcon", "desc", "publishSchema", "is_collected", "shareInfo"}, new Object[]{"", null, "", "", Boolean.FALSE, null}, QQCircleFeedBase$StUnifiedTagPageData.class);
    public final PBStringField title = PBField.initString("");
    public FeedCloudMeta$StImage pageIcon = new FeedCloudMeta$StImage();
    public final PBStringField desc = PBField.initString("");
    public final PBStringField publishSchema = PBField.initString("");
    public final PBBoolField is_collected = PBField.initBool(false);
    public FeedCloudMeta$StShare shareInfo = new FeedCloudMeta$StShare();
}
