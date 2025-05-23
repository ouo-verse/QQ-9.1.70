package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCountergroup$GetGroupCountReq extends MessageMicro<QQCircleCountergroup$GetGroupCountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", QCircleRelationGroupRequest.GROUP_ID}, new Object[]{null, 0L}, QQCircleCountergroup$GetGroupCountReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt64Field gid = PBField.initInt64(0);
}
