package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd extends MessageMicro<YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"leave_status", "user_game_data"}, new Object[]{0, null}, YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd.class);
    public final PBInt32Field leave_status = PBField.initInt32(0);
    public YoloRoomOuterClass$YoloUserGameData user_game_data = new YoloRoomOuterClass$YoloUserGameData();
}
