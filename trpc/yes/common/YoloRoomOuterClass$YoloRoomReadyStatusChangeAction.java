package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomReadyStatusChangeAction extends MessageMicro<YoloRoomOuterClass$YoloRoomReadyStatusChangeAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"op", "room_speaking_pos", "speaking_pos_list_version"}, new Object[]{0, null, 0}, YoloRoomOuterClass$YoloRoomReadyStatusChangeAction.class);

    /* renamed from: op, reason: collision with root package name */
    public final PBInt32Field f437259op = PBField.initInt32(0);
    public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
    public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
}
