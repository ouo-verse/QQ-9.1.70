package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentReader$StGetCommentListRsp extends MessageMicro<QZMomentReader$StGetCommentListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"extInfo", "vecComment", "totalNum", "isFinish", "feedAttchInfo", "permissionText"}, new Object[]{null, null, 0, 0, "", ""}, QZMomentReader$StGetCommentListRsp.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBRepeatMessageField<QZMomentMeta$StComment> vecComment = PBField.initRepeatMessage(QZMomentMeta$StComment.class);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");
    public final PBStringField permissionText = PBField.initString("");
}
