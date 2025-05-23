package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentReader$StGetLightInteractListRsp extends MessageMicro<QZMomentReader$StGetLightInteractListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"extInfo", "attachInfo", "listInfo", "isFinish", "totalCount"}, new Object[]{null, "", null, 0, 0}, QZMomentReader$StGetLightInteractListRsp.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBStringField attachInfo = PBField.initString("");
    public final PBRepeatMessageField<QZMomentMeta$StLightInteractInfo> listInfo = PBField.initRepeatMessage(QZMomentMeta$StLightInteractInfo.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field totalCount = PBField.initUInt32(0);
}
