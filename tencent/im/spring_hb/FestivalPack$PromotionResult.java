package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class FestivalPack$PromotionResult extends MessageMicro<FestivalPack$PromotionResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"promotion_id", "open_luck_word_id", "star_id", "open_luck_title", "open_luck_desc", "open_luck_pic"}, new Object[]{0, 0, 0, "", "", ""}, FestivalPack$PromotionResult.class);
    public final PBInt32Field promotion_id = PBField.initInt32(0);
    public final PBInt32Field open_luck_word_id = PBField.initInt32(0);
    public final PBInt32Field star_id = PBField.initInt32(0);
    public final PBStringField open_luck_title = PBField.initString("");
    public final PBStringField open_luck_desc = PBField.initString("");
    public final PBStringField open_luck_pic = PBField.initString("");
}
