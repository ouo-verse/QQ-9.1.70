package trpc.yes.common;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomKickOutRoomCmd extends MessageMicro<YoloRoomOuterClass$YoloRoomKickOutRoomCmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uid", "is_close_pos", "reason", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "user_id"}, new Object[]{0L, 0, 0L, 0, null}, YoloRoomOuterClass$YoloRoomKickOutRoomCmd.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field is_close_pos = PBField.initInt32(0);
    public final PBUInt64Field reason = PBField.initUInt64(0);
    public final PBUInt32Field second = PBField.initUInt32(0);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
}
