package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomUserData extends MessageMicro<YoloRoomOuterClass$YoloRoomUserData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{34, 42, 48}, new String[]{"user_id", "yolo_room_user_white_list", "is_need_update_tips"}, new Object[]{null, null, Boolean.FALSE}, YoloRoomOuterClass$YoloRoomUserData.class);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public YoloRoomOuterClass$YoloRoomUserWhiteList yolo_room_user_white_list = new YoloRoomOuterClass$YoloRoomUserWhiteList();
    public final PBBoolField is_need_update_tips = PBField.initBool(false);
}
