package tencent.im.oidb.cmd0xa02;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xa02$TinyID2UserAccInfo extends MessageMicro<cmd0xa02$TinyID2UserAccInfo> {
    public static final int STR_USERACC_IDENTIFIER_FIELD_NUMBER = 4;
    public static final int UINT32_SDKAPPID_FIELD_NUMBER = 3;
    public static final int UINT32_USERACCTYPE_FIELD_NUMBER = 2;
    public static final int UINT64_TINYID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_tinyid", "uint32_useracctype", "uint32_sdkappid", "str_useracc_identifier"}, new Object[]{0L, 0, 0, ""}, cmd0xa02$TinyID2UserAccInfo.class);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBUInt32Field uint32_useracctype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sdkappid = PBField.initUInt32(0);
    public final PBStringField str_useracc_identifier = PBField.initString("");
}
