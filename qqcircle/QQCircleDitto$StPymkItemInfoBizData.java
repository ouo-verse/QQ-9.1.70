package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StUser;

/* loaded from: classes29.dex */
public final class QQCircleDitto$StPymkItemInfoBizData extends MessageMicro<QQCircleDitto$StPymkItemInfoBizData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"recomUser", "isNew", "backupContent", "newUserPageMoreButton"}, new Object[]{null, Boolean.FALSE, "", null}, QQCircleDitto$StPymkItemInfoBizData.class);
    public FeedCloudMeta$StUser recomUser = new FeedCloudMeta$StUser();
    public final PBBoolField isNew = PBField.initBool(false);
    public final PBStringField backupContent = PBField.initString("");
    public QQCircleDitto$StButton newUserPageMoreButton = new QQCircleDitto$StButton();
}
