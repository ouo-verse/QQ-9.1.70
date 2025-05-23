package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomEnterAction extends MessageMicro<YoloRoomOuterClass$YoloRoomEnterAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"user_id", "enter_room_text"}, new Object[]{null, ""}, YoloRoomOuterClass$YoloRoomEnterAction.class);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBStringField enter_room_text = PBField.initString("");
}
