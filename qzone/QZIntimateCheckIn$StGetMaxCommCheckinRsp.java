package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$StGetMaxCommCheckinRsp extends MessageMicro<QZIntimateCheckIn$StGetMaxCommCheckinRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"days"}, new Object[]{0}, QZIntimateCheckIn$StGetMaxCommCheckinRsp.class);
    public final PBUInt32Field days = PBField.initUInt32(0);
}
