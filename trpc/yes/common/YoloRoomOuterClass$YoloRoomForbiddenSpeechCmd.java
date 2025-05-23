package trpc.yes.common;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd extends MessageMicro<YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uid", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "is_gm_forbidden", "user_id"}, new Object[]{0L, 0, Boolean.FALSE, null}, YoloRoomOuterClass$YoloRoomForbiddenSpeechCmd.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field second = PBField.initInt32(0);
    public final PBBoolField is_gm_forbidden = PBField.initBool(false);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
}
