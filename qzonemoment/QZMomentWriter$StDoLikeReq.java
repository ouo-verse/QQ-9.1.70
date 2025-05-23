package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentWriter$StDoLikeReq extends MessageMicro<QZMomentWriter$StDoLikeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"extInfo", "likeType", "like", "feed"}, new Object[]{null, 0, null, null}, QZMomentWriter$StDoLikeReq.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBUInt32Field likeType = PBField.initUInt32(0);
    public QZMomentMeta$StLike like = new QZMomentMeta$StLike();
    public QZMomentMeta$StFeed feed = new QZMomentMeta$StFeed();
}
