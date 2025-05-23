package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class userinfo$Cell extends MessageMicro<userinfo$Cell> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint32_mcc", "uint32_mnc", "uint32_lac", "uint32_cellid", "int32_rssi"}, new Object[]{0, 0, 0, 0, 0}, userinfo$Cell.class);
    public final PBUInt32Field uint32_mcc = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mnc = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lac = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cellid = PBField.initUInt32(0);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
}
