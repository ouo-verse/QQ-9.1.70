package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomModifyInfoActionContent extends MessageMicro<YoloRoomOuterClass$YoloRoomModifyInfoActionContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "room_params", "smoba_room_params"}, new Object[]{0, null, null}, YoloRoomOuterClass$YoloRoomModifyInfoActionContent.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public YoloRoomOuterClass$YoloRoomParams room_params = new YoloRoomOuterClass$YoloRoomParams();
    public YoloRoomOuterClass$YoloSmobaRoomParams smoba_room_params = new YoloRoomOuterClass$YoloSmobaRoomParams();
}
