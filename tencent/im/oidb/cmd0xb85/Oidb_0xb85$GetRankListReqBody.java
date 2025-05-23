package tencent.im.oidb.cmd0xb85;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xb85$GetRankListReqBody extends MessageMicro<Oidb_0xb85$GetRankListReqBody> {
    public static final int RANK_CUR_VAL = 0;
    public static final int RANK_MAX_VAL = 1;
    public static final int RANK_MIN_VAL = 2;
    public static final int RANK_ORDER_ASC = 1;
    public static final int RANK_ORDER_DESC = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"ranklist_id", "top_count", "rank_key", "rank_value_type", "rank_order_type"}, new Object[]{0, 10, "", 0, 0}, Oidb_0xb85$GetRankListReqBody.class);
    public final PBInt32Field ranklist_id = PBField.initInt32(0);
    public final PBInt32Field top_count = PBField.initInt32(10);
    public final PBStringField rank_key = PBField.initString("");
    public final PBInt32Field rank_value_type = PBField.initInt32(0);
    public final PBInt32Field rank_order_type = PBField.initInt32(0);
}
