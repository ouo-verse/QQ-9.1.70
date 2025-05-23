package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$CovenantLiteDialog;
import feedcloud.FeedCloudMeta$StMedalInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetUserExternalMedalWallRsp extends MessageMicro<QQCircleRankinglist$GetUserExternalMedalWallRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StMedalInfo> medalInfos = PBField.initRepeatMessage(FeedCloudMeta$StMedalInfo.class);
    public final PBBoolField needRedPoint = PBField.initBool(false);
    public final PBStringField medalWallJumpUrl = PBField.initString("");
    public final PBBoolField needShowEntrance = PBField.initBool(false);
    public FeedCloudMeta$CovenantLiteDialog liteDialog = new FeedCloudMeta$CovenantLiteDialog();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50}, new String[]{"extInfo", "medalInfos", "needRedPoint", "medalWallJumpUrl", "needShowEntrance", "liteDialog"}, new Object[]{null, null, bool, "", bool, null}, QQCircleRankinglist$GetUserExternalMedalWallRsp.class);
    }
}
