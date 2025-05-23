package tencent.nearby.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearby_now_anchor$RspBatchGetAnchorStatus extends MessageMicro<nearby_now_anchor$RspBatchGetAnchorStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "msg_anchor_stats"}, new Object[]{0, null}, nearby_now_anchor$RspBatchGetAnchorStatus.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBRepeatMessageField<nearby_now_anchor$AnchorStatus> msg_anchor_stats = PBField.initRepeatMessage(nearby_now_anchor$AnchorStatus.class);
}
