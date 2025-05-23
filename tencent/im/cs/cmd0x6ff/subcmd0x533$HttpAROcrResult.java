package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x533$HttpAROcrResult extends MessageMicro<subcmd0x533$HttpAROcrResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26}, new String[]{"uint64_ocr_recog_type", "msg_sougou_rsp"}, new Object[]{0L, null}, subcmd0x533$HttpAROcrResult.class);
    public final PBUInt64Field uint64_ocr_recog_type = PBField.initUInt64(0);
    public subcmd0x533$HttpServerResponseBodyV2 msg_sougou_rsp = new subcmd0x533$HttpServerResponseBodyV2();
}
