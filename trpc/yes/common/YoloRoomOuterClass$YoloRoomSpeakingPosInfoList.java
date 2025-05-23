package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomSpeakingPosInfoList extends MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingPosInfoList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"room_speaking_pos_list"}, new Object[]{null}, YoloRoomOuterClass$YoloRoomSpeakingPosInfoList.class);
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
}
