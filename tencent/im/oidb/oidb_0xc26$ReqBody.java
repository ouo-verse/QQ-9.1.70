package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$ReqBody extends MessageMicro<oidb_0xc26$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookies;
    public final PBBytesField bytes_group_id;
    public final PBEnumField em_entry;
    public final PBUInt32Field enabled_contact;
    public final PBUInt32Field not_req_pymk;
    public final PBRepeatField<Long> rpt_expected_uins;
    public final PBRepeatField<Long> rpt_filter_uins;
    public final PBBytesField trace_id;
    public final PBStringField trans_info;
    public final PBUInt32Field uin32_undecide;
    public final PBUInt32Field uint32_fetch_rgroup;
    public final PBUInt32Field uint32_phone_book;
    public final PBUInt32Field uint32_tab_id;
    public final PBUInt32Field uint32_want;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72, 82, 90, 98, 104, 112}, new String[]{"rpt_filter_uins", "uint32_phone_book", "rpt_expected_uins", "em_entry", "uint32_fetch_rgroup", "uint32_tab_id", "uint32_want", "bytes_cookies", "uin32_undecide", "bytes_group_id", "trace_id", "trans_info", "enabled_contact", "not_req_pymk"}, new Object[]{0L, 0, 0L, 1, 0, 0, 80, byteStringMicro, 0, byteStringMicro, byteStringMicro, "", 0, 0}, oidb_0xc26$ReqBody.class);
    }

    public oidb_0xc26$ReqBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_filter_uins = PBField.initRepeat(pBUInt64Field);
        this.uint32_phone_book = PBField.initUInt32(0);
        this.rpt_expected_uins = PBField.initRepeat(pBUInt64Field);
        this.em_entry = PBField.initEnum(1);
        this.uint32_fetch_rgroup = PBField.initUInt32(0);
        this.uint32_tab_id = PBField.initUInt32(0);
        this.uint32_want = PBField.initUInt32(80);
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_cookies = PBField.initBytes(byteStringMicro);
        this.uin32_undecide = PBField.initUInt32(0);
        this.bytes_group_id = PBField.initBytes(byteStringMicro);
        this.trace_id = PBField.initBytes(byteStringMicro);
        this.trans_info = PBField.initString("");
        this.enabled_contact = PBField.initUInt32(0);
        this.not_req_pymk = PBField.initUInt32(0);
    }
}
