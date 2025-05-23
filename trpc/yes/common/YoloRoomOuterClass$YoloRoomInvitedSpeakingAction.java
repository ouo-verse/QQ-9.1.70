package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloRoomInvitedSpeakingAction extends MessageMicro<YoloRoomOuterClass$YoloRoomInvitedSpeakingAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"invite_user_id", "invited_user_id", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{null, null, 0L}, YoloRoomOuterClass$YoloRoomInvitedSpeakingAction.class);
    public CommonOuterClass$QQUserId invite_user_id = new CommonOuterClass$QQUserId();
    public CommonOuterClass$QQUserId invited_user_id = new CommonOuterClass$QQUserId();
    public final PBUInt64Field expire_time = PBField.initUInt64(0);
}
