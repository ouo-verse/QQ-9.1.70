package tencent.im.oidb.cmd0xf57;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xf57$MedalInfo extends MessageMicro<cmd0xf57$MedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"icon_url", "name", VasQQSettingMeImpl.EXPIRE_TIME, "official_medalInfo_ext"}, new Object[]{"", ByteStringMicro.EMPTY, 0L, null}, cmd0xf57$MedalInfo.class);
    public final PBStringField icon_url = PBField.initString("");
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field expire_time = PBField.initUInt64(0);
    public cmd0xf57$OfficialMedalInfoExt official_medalInfo_ext = new cmd0xf57$OfficialMedalInfoExt();
}
