package qqcircle;

import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleCounter$MergePsvRedPointsReq extends MessageMicro<QQCircleCounter$MergePsvRedPointsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48}, new String[]{"userVideoBoxfeedIDs", "pages", "from", "extInfo", IVideoFilterTools.CATEGORYS, "mergePsvPageType"}, new Object[]{"", 0, 0, null, null, 0}, QQCircleCounter$MergePsvRedPointsReq.class);
    public final PBRepeatField<String> userVideoBoxfeedIDs = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<Integer> pages = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBEnumField from = PBField.initEnum(0);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleCounter$Categorys> categorys = PBField.initRepeatMessage(QQCircleCounter$Categorys.class);
    public final PBEnumField mergePsvPageType = PBField.initEnum(0);
}
