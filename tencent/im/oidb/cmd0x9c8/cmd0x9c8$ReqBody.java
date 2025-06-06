package tencent.im.oidb.cmd0x9c8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c8$ReqBody extends MessageMicro<cmd0x9c8$ReqBody> {
    public static final int STR_KEYWORD_FIELD_NUMBER = 1;
    public static final int UINT32_FETCH_COUNT_FIELD_NUMBER = 4;
    public static final int UINT32_FETCH_START_FIELD_NUMBER = 3;
    public static final int UINT32_MATCH_OP_FIELD_NUMBER = 5;
    public static final int UINT32_PERSONAL_INFO_FLAG_FIELD_NUMBER = 6;
    public static final int UINT32_TAG_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48}, new String[]{"str_keyword", "uint32_tag_type", "uint32_fetch_start", "uint32_fetch_count", "uint32_match_op", "uint32_personal_info_flag"}, new Object[]{"", 0, 0, 0, 0, 0}, cmd0x9c8$ReqBody.class);
    public final PBStringField str_keyword = PBField.initString("");
    public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fetch_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fetch_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_match_op = PBField.initUInt32(0);
    public final PBUInt32Field uint32_personal_info_flag = PBField.initUInt32(0);
}
