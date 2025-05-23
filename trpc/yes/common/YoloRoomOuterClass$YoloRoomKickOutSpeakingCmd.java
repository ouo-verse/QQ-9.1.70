package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd extends MessageMicro<YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 808}, new String[]{"uid", "is_close_pos", "user_id", "no_action"}, new Object[]{0L, 0, null, 0}, YoloRoomOuterClass$YoloRoomKickOutSpeakingCmd.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field is_close_pos = PBField.initInt32(0);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBInt32Field no_action = PBField.initInt32(0);
}
