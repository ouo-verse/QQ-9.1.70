package trpc.yes.common;

import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomForbiddenSpeechInfo extends MessageMicro<YoloRoomOuterClass$YoloRoomForbiddenSpeechInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"end_time", "is_gm_forbidden", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND}, new Object[]{0, Boolean.FALSE, 0}, YoloRoomOuterClass$YoloRoomForbiddenSpeechInfo.class);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBBoolField is_gm_forbidden = PBField.initBool(false);
    public final PBInt32Field second = PBField.initInt32(0);
}
