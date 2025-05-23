package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction extends MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"room_speaking_pos", "speaking_pos_list_version"}, new Object[]{null, 0}, YoloRoomOuterClass$YoloRoomSpeakingUserStatusUpdateAction.class);
    public YoloRoomOuterClass$YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass$YoloRoomSpeakingPosInfo();
    public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
}
