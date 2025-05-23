package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class ShopOuterClass$DoActiveLotteryRsp extends MessageMicro<ShopOuterClass$DoActiveLotteryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"lottery_info", "cusor_index", "current_lottery_ticket_num"}, new Object[]{null, 0, 0}, ShopOuterClass$DoActiveLotteryRsp.class);
    public ShopOuterClass$LotteryInfo lottery_info = new MessageMicro<ShopOuterClass$LotteryInfo>() { // from class: trpc.yes.common.ShopOuterClass$LotteryInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 56}, new String[]{"reward_type", "reward_num", "reward_name", "reward_img", "reward_tips_title", "reward_tips_text", "reward_index"}, new Object[]{0, 0, "", "", "", "", 0}, ShopOuterClass$LotteryInfo.class);
        public final PBInt32Field reward_type = PBField.initInt32(0);
        public final PBInt32Field reward_num = PBField.initInt32(0);
        public final PBStringField reward_name = PBField.initString("");
        public final PBStringField reward_img = PBField.initString("");
        public final PBStringField reward_tips_title = PBField.initString("");
        public final PBStringField reward_tips_text = PBField.initString("");
        public final PBInt32Field reward_index = PBField.initInt32(0);
    };
    public final PBInt32Field cusor_index = PBField.initInt32(0);
    public final PBInt32Field current_lottery_ticket_num = PBField.initInt32(0);
}
