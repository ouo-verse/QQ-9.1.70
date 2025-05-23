package trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class ShopOuterClass$BuyAndGiveGiftReq extends MessageMicro<ShopOuterClass$BuyAndGiveGiftReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 58, 64, 72, 80}, new String[]{"recv_list", "gift_id", "total_num", "reason", "game_id", "is_just_bag", "scene_info", AudienceReportConst.ROOM_ID, "base_num", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{null, 0, 0, 0, 0, Boolean.FALSE, null, 0L, 0, 0}, ShopOuterClass$BuyAndGiveGiftReq.class);
    public final PBRepeatMessageField<CommonOuterClass$QQUserId> recv_list = PBField.initRepeatMessage(CommonOuterClass$QQUserId.class);
    public final PBUInt32Field gift_id = PBField.initUInt32(0);
    public final PBInt32Field total_num = PBField.initInt32(0);
    public final PBInt32Field reason = PBField.initInt32(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBBoolField is_just_bag = PBField.initBool(false);
    public ShopOuterClass$GiftSceneInfo scene_info = new ShopOuterClass$GiftSceneInfo();
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field base_num = PBField.initInt32(0);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
}
