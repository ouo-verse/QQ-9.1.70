package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaRoomChangeEvent extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaRoomChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"change_type", "is_kickout", AegisLogger.ROOM_INFO}, new Object[]{0, 0, null}, YoloBattleSmobaOuterClass$YoloSmobaRoomChangeEvent.class);
    public final PBEnumField change_type = PBField.initEnum(0);
    public final PBInt32Field is_kickout = PBField.initInt32(0);
    public SmobaDataOuterClass$YoloBattleRoomInfo room_info = new SmobaDataOuterClass$YoloBattleRoomInfo();
}
