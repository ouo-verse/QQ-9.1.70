package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameOrder$OrderGame extends MessageMicro<QQGameOrder$OrderGame> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48}, new String[]{"app_id", "order_ts", "channel_id", "order_status", "king_card_auth", "wifi_switch_off"}, new Object[]{"", 0L, "", 0, 0, 0}, QQGameOrder$OrderGame.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBInt64Field order_ts = PBField.initInt64(0);
    public final PBStringField channel_id = PBField.initString("");
    public final PBEnumField order_status = PBField.initEnum(0);
    public final PBInt32Field king_card_auth = PBField.initInt32(0);
    public final PBInt32Field wifi_switch_off = PBField.initInt32(0);
}
