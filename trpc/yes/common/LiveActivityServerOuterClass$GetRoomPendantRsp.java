package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$GetRoomPendantRsp extends MessageMicro<LiveActivityServerOuterClass$GetRoomPendantRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pendant_list", "user_redpacket"}, new Object[]{null, null}, LiveActivityServerOuterClass$GetRoomPendantRsp.class);
    public final PBRepeatMessageField<PendantOuterClass$PendantMsg> pendant_list = PBField.initRepeatMessage(PendantOuterClass$PendantMsg.class);
    public LiveActivityServerOuterClass$UserRedpacket user_redpacket = new LiveActivityServerOuterClass$UserRedpacket();
}
