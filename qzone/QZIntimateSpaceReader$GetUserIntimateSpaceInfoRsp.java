package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetUserIntimateSpaceInfoRsp extends MessageMicro<QZIntimateSpaceReader$GetUserIntimateSpaceInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"opmask"}, new Object[]{1}, QZIntimateSpaceReader$GetUserIntimateSpaceInfoRsp.class);
    public final PBRepeatField<Integer> opmask = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
