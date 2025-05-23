package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction extends MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"room_speaking_pos_list", "speaking_pos_list_version"}, new Object[]{null, 0}, YoloRoomOuterClass$YoloRoomSpeakingPosListInitAction.class);
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
    public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
}
