package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloGameRoomSettleGiftNoticeAction extends MessageMicro<YoloRoomOuterClass$YoloGameRoomSettleGiftNoticeAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"settle_user_id_list", "unsettle_user_id_list"}, new Object[]{null, null}, YoloRoomOuterClass$YoloGameRoomSettleGiftNoticeAction.class);
    public final PBRepeatMessageField<CommonOuterClass$QQUserId> settle_user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
    public final PBRepeatMessageField<CommonOuterClass$QQUserId> unsettle_user_id_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
}
