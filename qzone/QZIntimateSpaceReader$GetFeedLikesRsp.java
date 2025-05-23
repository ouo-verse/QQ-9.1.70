package qzone;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetFeedLikesRsp extends MessageMicro<QZIntimateSpaceReader$GetFeedLikesRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"ext", PictureConst.KEY_HAS_MORE, "list", "total_num", "friend_num"}, new Object[]{null, Boolean.FALSE, null, 0, 0}, QZIntimateSpaceReader$GetFeedLikesRsp.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBRepeatMessageField<QZoneBaseMeta$StLikeMan> list = PBField.initRepeatMessage(QZoneBaseMeta$StLikeMan.class);
    public final PBUInt32Field total_num = PBField.initUInt32(0);
    public final PBUInt32Field friend_num = PBField.initUInt32(0);
}
