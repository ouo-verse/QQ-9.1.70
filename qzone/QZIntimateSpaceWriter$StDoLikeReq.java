package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.state.square.detail.BaseDetailFragmentConfig;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StDoLikeReq extends MessageMicro<QZIntimateSpaceWriter$StDoLikeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"ext_info", BaseDetailFragmentConfig.LIKE_TYPE, "like", "feed"}, new Object[]{null, 0, null, null}, QZIntimateSpaceWriter$StDoLikeReq.class);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
    public final PBUInt32Field like_type = PBField.initUInt32(0);
    public QZoneBaseMeta$StLike like = new QZoneBaseMeta$StLike();
    public QZoneBaseMeta$StFeed feed = new QZoneBaseMeta$StFeed();
}
