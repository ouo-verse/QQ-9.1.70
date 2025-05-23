package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$GetCircleMemberReq extends MessageMicro<QQCircleRead$GetCircleMemberReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", "id", "count", "attachInfo"}, new Object[]{null, "", 0L, ""}, QQCircleRead$GetCircleMemberReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429313id = PBField.initString("");
    public final PBInt64Field count = PBField.initInt64(0);
    public final PBStringField attachInfo = PBField.initString("");
}
