package qqcircle;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudMeta$StRelationInfo;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$RankingItem extends MessageMicro<QQCircleRankinglist$RankingItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58}, new String[]{QCircleAlphaUserReporter.KEY_USER, "relation", LocalPhotoFaceInfo.SCORE, "grade", "rankNo", "inTopicList", "scoreName"}, new Object[]{null, null, 0L, 0, 0, 0, ""}, QQCircleRankinglist$RankingItem.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public FeedCloudMeta$StRelationInfo relation = new FeedCloudMeta$StRelationInfo();
    public final PBInt64Field score = PBField.initInt64(0);
    public final PBInt32Field grade = PBField.initInt32(0);
    public final PBInt32Field rankNo = PBField.initInt32(0);
    public final PBInt32Field inTopicList = PBField.initInt32(0);
    public final PBStringField scoreName = PBField.initString("");
}
