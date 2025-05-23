package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$NotifyDataReq extends MessageMicro<QQCircleRankinglist$NotifyDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", "op", "data"}, new Object[]{null, 1, ByteStringMicro.EMPTY}, QQCircleRankinglist$NotifyDataReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();

    /* renamed from: op, reason: collision with root package name */
    public final PBEnumField f429311op = PBField.initEnum(1);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
}
