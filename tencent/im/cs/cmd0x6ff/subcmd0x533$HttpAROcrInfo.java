package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x533$HttpAROcrInfo extends MessageMicro<subcmd0x533$HttpAROcrInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26}, new String[]{"uint64_ocr_recog_type", "msg_sougou_req"}, new Object[]{0L, null}, subcmd0x533$HttpAROcrInfo.class);
    public final PBUInt64Field uint64_ocr_recog_type = PBField.initUInt64(0);
    public subcmd0x533$HttpClientRequestBodyV2 msg_sougou_req = new subcmd0x533$HttpClientRequestBodyV2();
}
