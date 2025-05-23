package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x43c$CardInfo extends MessageMicro<Oidb_0x43c$CardInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 64, 72, 80, 90, 98, 106, 114}, new String[]{"card_id", "pic_url", "name", IProfileProtocolConst.KEY_COMPANY, "uins", "mobiles", "descs", "bind_uin", "card_src", DeviceProfileManager.KEY_LAST_UPDATE_TIME, "ocr_info", "mobile_info", "uin_info", "bind_mbl"}, new Object[]{ByteStringMicro.EMPTY, "", "", "", 0L, "", "", 0L, 1, 0, null, null, null, ""}, Oidb_0x43c$CardInfo.class);
    public final PBStringField bind_mbl;
    public final PBUInt64Field bind_uin;
    public final PBEnumField card_src;
    public final PBRepeatField<String> descs;
    public final PBUInt32Field last_update_time;
    public final PBRepeatMessageField<Oidb_0x43c$MobileInfo> mobile_info;
    public final PBRepeatField<String> mobiles;
    public Oidb_0x43c$OCRInfo ocr_info;
    public final PBRepeatMessageField<Oidb_0x43c$UinInfo> uin_info;
    public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField pic_url = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField company = PBField.initString("");
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);

    public Oidb_0x43c$CardInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.mobiles = PBField.initRepeat(pBStringField);
        this.descs = PBField.initRepeat(pBStringField);
        this.bind_uin = PBField.initUInt64(0L);
        this.card_src = PBField.initEnum(1);
        this.last_update_time = PBField.initUInt32(0);
        this.ocr_info = new Oidb_0x43c$OCRInfo();
        this.mobile_info = PBField.initRepeatMessage(Oidb_0x43c$MobileInfo.class);
        this.uin_info = PBField.initRepeatMessage(Oidb_0x43c$UinInfo.class);
        this.bind_mbl = PBField.initString("");
    }
}
