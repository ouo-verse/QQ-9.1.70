package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QWalletPubAdReport$QueryRsp extends MessageMicro<QWalletPubAdReport$QueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 72}, new String[]{"ret", "msg", "uin", "pv_flag", "pv_timestamp", "uv_flag", "uv_day_freq", "uv_week_freq", "uv_mon_freq"}, new Object[]{0, "", "", 0, 0L, 0, 0, 0, 0}, QWalletPubAdReport$QueryRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f436044msg = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
    public final PBInt32Field pv_flag = PBField.initInt32(0);
    public final PBInt64Field pv_timestamp = PBField.initInt64(0);
    public final PBInt32Field uv_flag = PBField.initInt32(0);
    public final PBInt32Field uv_day_freq = PBField.initInt32(0);
    public final PBInt32Field uv_week_freq = PBField.initInt32(0);
    public final PBInt32Field uv_mon_freq = PBField.initInt32(0);
}
