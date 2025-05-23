package tencent.im.troop.findtroop;

import android.net.http.Headers;
import com.qzone.widget.u;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class TabRecommendPB$PersionParam extends MessageMicro<TabRecommendPB$PersionParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"filter_uins", "expected_uins", "undecide", Headers.ETAG, u.COLUMN_TAB_ID}, new Object[]{0L, 0L, 0, "", 0}, TabRecommendPB$PersionParam.class);
    public final PBStringField etag;
    public final PBRepeatField<Long> expected_uins;
    public final PBRepeatField<Long> filter_uins;
    public final PBUInt32Field tab_id;
    public final PBUInt32Field undecide;

    public TabRecommendPB$PersionParam() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.filter_uins = PBField.initRepeat(pBUInt64Field);
        this.expected_uins = PBField.initRepeat(pBUInt64Field);
        this.undecide = PBField.initUInt32(0);
        this.etag = PBField.initString("");
        this.tab_id = PBField.initUInt32(0);
    }
}
