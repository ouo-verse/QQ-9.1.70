package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetUserIntimateSpaceInfoReq extends MessageMicro<QZIntimateSpaceReader$GetUserIntimateSpaceInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"opmask_to_check"}, new Object[]{1}, QZIntimateSpaceReader$GetUserIntimateSpaceInfoReq.class);
    public final PBRepeatField<Integer> opmask_to_check = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
