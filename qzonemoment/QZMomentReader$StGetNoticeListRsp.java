package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentReader$StGetNoticeListRsp extends MessageMicro<QZMomentReader$StGetNoticeListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"extInfo", "vecNotice", "totalNum", "isFinish", "feedAttchInfo"}, new Object[]{null, null, 0, 0, ""}, QZMomentReader$StGetNoticeListRsp.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBRepeatMessageField<QZMomentMeta$StNotice> vecNotice = PBField.initRepeatMessage(QZMomentMeta$StNotice.class);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");
}
