package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomCommunityConf extends MessageMicro<YoloRoomOuterClass$YoloRoomCommunityConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"wuji_yolo_room_community_conf", "add_friend_tips_text_list"}, new Object[]{null, ""}, YoloRoomOuterClass$YoloRoomCommunityConf.class);
    public WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf wuji_yolo_room_community_conf = new WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf();
    public final PBRepeatField<String> add_friend_tips_text_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}
