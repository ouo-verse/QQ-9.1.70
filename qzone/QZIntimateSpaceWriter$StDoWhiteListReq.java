package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StDoWhiteListReq extends MessageMicro<QZIntimateSpaceWriter$StDoWhiteListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uids"}, new Object[]{""}, QZIntimateSpaceWriter$StDoWhiteListReq.class);
    public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
