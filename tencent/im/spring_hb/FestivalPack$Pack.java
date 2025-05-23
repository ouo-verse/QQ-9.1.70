package tencent.im.spring_hb;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.luggage.wxa.fe.a;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;

/* loaded from: classes29.dex */
public final class FestivalPack$Pack extends MessageMicro<FestivalPack$Pack> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField pack_id = PBField.initString("");
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field ctime = PBField.initUInt32(0);
    public final PBUInt32Field money = PBField.initUInt32(0);
    public final PBStringField business_id = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field mtime = PBField.initUInt32(0);
    public final PBStringField order = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field send_uin = PBField.initUInt64(0);
    public final PBStringField wishing = PBField.initString("");
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBStringField req_id = PBField.initString("");
    public final PBStringField business_name = PBField.initString("");
    public final PBStringField business_logo = PBField.initString("");
    public final PBStringField business_cover = PBField.initString("");
    public final PBStringField business_video_cover = PBField.initString("");
    public final PBStringField business_video = PBField.initString("");
    public final PBStringField business_name_pic = PBField.initString("");
    public final PBStringField coupon_name = PBField.initString("");
    public final PBBoolField can_light = PBField.initBool(false);
    public final PBInt32Field prize_id = PBField.initInt32(0);
    public final PBStringField sub_title = PBField.initString("");
    public FestivalPack$FragmentCoupon fragment_coupon = new MessageMicro<FestivalPack$FragmentCoupon>() { // from class: tencent.im.spring_hb.FestivalPack$FragmentCoupon
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"fragment_coupon_id", "hit_num", "fragments"}, new Object[]{0L, 0L, null}, FestivalPack$FragmentCoupon.class);
        public final PBUInt64Field fragment_coupon_id = PBField.initUInt64(0);
        public final PBInt64Field hit_num = PBField.initInt64(0);
        public final PBRepeatMessageField<FestivalPack$Fragment> fragments = PBField.initRepeatMessage(FestivalPack$Fragment.class);
    };
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBUInt32Field lucky_score = PBField.initUInt32(0);
    public final PBStringField lucky_score_wording = PBField.initString("");
    public final PBBoolField h5_flag = PBField.initBool(false);
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field welfare_type = PBField.initUInt32(0);
    public final PBStringField business_jump_url = PBField.initString("");
    public final PBStringField business_jump_hint = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField business_list_logo = PBField.initString("");
    public final PBStringField alternative_sub_title = PBField.initString("");
    public final PBStringField warehouse_id = PBField.initString("");
    public final PBStringField qb_notice_cover = PBField.initString("");
    public final PBBoolField use_in_common = PBField.initBool(false);
    public final PBStringField warehouse_goods_id = PBField.initString("");
    public final PBRepeatMessageField<FestivalPack$BusinessJumpInfo> jump_info = PBField.initRepeatMessage(FestivalPack$BusinessJumpInfo.class);
    public final PBUInt32Field limit_platform = PBField.initUInt32(0);

    static {
        int[] iArr = {10, 16, 24, 32, 40, 50, 58, 66, 72, 82, 88, 96, 106, 112, 122, 130, 138, 146, 154, 162, 170, 178, 184, 192, 202, 210, 216, 224, 234, 240, 250, 256, 266, 274, FilterEnum.MIC_PTU_BAIXI, 290, 298, 306, 314, 320, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 338, a.CTRL_INDEX};
        String[] strArr = {"pack_id", "state", "type", "ctime", WidgetCacheConstellationData.MONEY, "business_id", "signature", "url", "mtime", "order", "uin", "send_uin", "wishing", "promotion_id", CheckForwardServlet.KEY_REQ_ID, "business_name", "business_logo", "business_cover", "business_video_cover", "business_video", "business_name_pic", "coupon_name", "can_light", "prize_id", "sub_title", "fragment_coupon", "flag", "lucky_score", "lucky_score_wording", "h5_flag", "content", "welfare_type", "business_jump_url", "business_jump_hint", "appid", "business_list_logo", "alternative_sub_title", "warehouse_id", "qb_notice_cover", "use_in_common", "warehouse_goods_id", "jump_info", "limit_platform"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{"", 0, 0, 0, 0, "", "", "", 0, "", 0L, 0L, "", 0, "", "", "", "", "", "", "", "", bool, 0, "", null, 0, 0, "", bool, "", 0, "", "", "", "", "", "", "", bool, "", null, 0}, FestivalPack$Pack.class);
    }
}
