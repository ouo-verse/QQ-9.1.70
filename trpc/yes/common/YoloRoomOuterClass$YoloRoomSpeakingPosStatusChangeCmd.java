package trpc.yes.common;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd extends MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"op", c.G}, new Object[]{0, 0}, YoloRoomOuterClass$YoloRoomSpeakingPosStatusChangeCmd.class);

    /* renamed from: op, reason: collision with root package name */
    public final PBInt32Field f437264op = PBField.initInt32(0);
    public final PBUInt32Field pos = PBField.initUInt32(0);
}
