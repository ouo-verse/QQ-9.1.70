package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetStarRedDot$GetStarRedDotRsp extends MessageMicro<GetStarRedDot$GetStarRedDotRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField red_dot = PBField.initBool(false);
    public final PBUInt32Field polling_interval = PBField.initUInt32(0);
    public final PBUInt32Field star_cnt = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");
    public final PBBoolField is_full = PBField.initBool(false);
    public final PBBoolField is_allow_play = PBField.initBool(false);
    public final PBBoolField can_share_game_report = PBField.initBool(false);
    public final PBBoolField can_share_to_weibo = PBField.initBool(false);
    public final PBStringField bottom_wording = PBField.initString("");
    public final PBBoolField draw_prize_vibrate = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 56, 64, 74, 80}, new String[]{"red_dot", "polling_interval", "star_cnt", "wording", "is_full", "is_allow_play", "can_share_game_report", "can_share_to_weibo", "bottom_wording", "draw_prize_vibrate"}, new Object[]{bool, 0, 0, "", bool, bool, bool, bool, "", bool}, GetStarRedDot$GetStarRedDotRsp.class);
    }
}
