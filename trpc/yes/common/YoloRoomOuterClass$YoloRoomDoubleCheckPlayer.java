package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomDoubleCheckPlayer extends MessageMicro<YoloRoomOuterClass$YoloRoomDoubleCheckPlayer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uid", "is_check", "user_id"}, new Object[]{0L, 0, null}, YoloRoomOuterClass$YoloRoomDoubleCheckPlayer.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field is_check = PBField.initInt32(0);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
}
