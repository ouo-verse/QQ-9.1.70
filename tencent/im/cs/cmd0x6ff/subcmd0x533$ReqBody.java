package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x533$ReqBody extends MessageMicro<subcmd0x533$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 40, 48, 90, 106}, new String[]{"string_session_id", "uint64_req_recog_type", "uint32_business_type", "string_clt_version", "msg_ocr_info"}, new Object[]{"", 0L, 0, "", null}, subcmd0x533$ReqBody.class);
    public final PBStringField string_session_id = PBField.initString("");
    public final PBUInt64Field uint64_req_recog_type = PBField.initUInt64(0);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBStringField string_clt_version = PBField.initString("");
    public subcmd0x533$HttpAROcrInfo msg_ocr_info = new subcmd0x533$HttpAROcrInfo();
}
