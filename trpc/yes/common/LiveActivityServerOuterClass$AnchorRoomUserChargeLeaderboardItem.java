package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$AnchorRoomUserChargeLeaderboardItem extends MessageMicro<LiveActivityServerOuterClass$AnchorRoomUserChargeLeaderboardItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uid", "charge_value"}, new Object[]{0L, 0L}, LiveActivityServerOuterClass$AnchorRoomUserChargeLeaderboardItem.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field charge_value = PBField.initUInt64(0);
}
