package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$GetFollowTagListRsp extends MessageMicro<QQCircleRead$GetFollowTagListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "tagList", "attachInfo", "hasNext"}, new Object[]{null, null, "", 0}, QQCircleRead$GetFollowTagListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleRead$TagItem> tagList = PBField.initRepeatMessage(QQCircleRead$TagItem.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBUInt32Field hasNext = PBField.initUInt32(0);
}
