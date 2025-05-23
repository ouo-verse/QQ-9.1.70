package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentWriter$StDeleteFeedRsp extends MessageMicro<QZMomentWriter$StDeleteFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 24}, new String[]{"extInfo", "nextPublishTime"}, new Object[]{null, 0L}, QZMomentWriter$StDeleteFeedRsp.class);
    public QZMomentCommon$StCommonExt extInfo = new QZMomentCommon$StCommonExt();
    public final PBUInt64Field nextPublishTime = PBField.initUInt64(0);
}
