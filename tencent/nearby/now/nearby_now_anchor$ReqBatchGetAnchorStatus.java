package tencent.nearby.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearby_now_anchor$ReqBatchGetAnchorStatus extends MessageMicro<nearby_now_anchor$ReqBatchGetAnchorStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_uin"}, new Object[]{0L}, nearby_now_anchor$ReqBatchGetAnchorStatus.class);
    public final PBRepeatField<Long> uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
