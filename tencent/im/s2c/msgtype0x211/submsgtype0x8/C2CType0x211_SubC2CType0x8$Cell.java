package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class C2CType0x211_SubC2CType0x8$Cell extends MessageMicro<C2CType0x211_SubC2CType0x8$Cell> {
    public static final int INT32_CELLID_FIELD_NUMBER = 4;
    public static final int INT32_LAC_FIELD_NUMBER = 3;
    public static final int INT32_MCC_FIELD_NUMBER = 1;
    public static final int INT32_MNC_FIELD_NUMBER = 2;
    public static final int INT32_RSSI_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"int32_mcc", "int32_mnc", "int32_lac", "int32_cellid", "int32_rssi"}, new Object[]{-1, -1, -1, -1, 0}, C2CType0x211_SubC2CType0x8$Cell.class);
    public final PBInt32Field int32_mcc = PBField.initInt32(-1);
    public final PBInt32Field int32_mnc = PBField.initInt32(-1);
    public final PBInt32Field int32_lac = PBField.initInt32(-1);
    public final PBInt32Field int32_cellid = PBField.initInt32(-1);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
}
