package tencent.im.oidb.cmd0xdad;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xdad$ReqBody extends MessageMicro<cmd0xdad$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66}, new String[]{"client", ReportDataBuilder.KEY_PRODUCT_ID, "amount", "to_uin", "gc", "ip", "vsersion", PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{0L, 0L, 0L, 0L, 0L, "", "", null}, cmd0xdad$ReqBody.class);
    public final PBInt64Field client = PBField.initInt64(0);
    public final PBInt64Field product_id = PBField.initInt64(0);
    public final PBInt64Field amount = PBField.initInt64(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);

    /* renamed from: gc, reason: collision with root package name */
    public final PBUInt64Field f435991gc = PBField.initUInt64(0);

    /* renamed from: ip, reason: collision with root package name */
    public final PBStringField f435992ip = PBField.initString("");
    public final PBStringField vsersion = PBField.initString("");
    public cmd0xdad$LoginSig sig = new MessageMicro<cmd0xdad$LoginSig>() { // from class: tencent.im.oidb.cmd0xdad.cmd0xdad$LoginSig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_type", "bytes_sig", "uint32_appid"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, cmd0xdad$LoginSig.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    };
}
