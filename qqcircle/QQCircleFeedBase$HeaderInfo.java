package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StImage;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$HeaderInfo extends MessageMicro<QQCircleFeedBase$HeaderInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"is_default", "img", "title", "condition_text", "img_type", "jump_url"}, new Object[]{Boolean.FALSE, null, "", "", "", ""}, QQCircleFeedBase$HeaderInfo.class);
    public final PBBoolField is_default = PBField.initBool(false);
    public FeedCloudMeta$StImage img = new FeedCloudMeta$StImage();
    public final PBStringField title = PBField.initString("");
    public final PBStringField condition_text = PBField.initString("");
    public final PBStringField img_type = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
