package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe07$ReqBody extends MessageMicro<cmd0xe07$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 82}, new String[]{"version", "client", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "ocrReqBody"}, new Object[]{1, 0, 0, null}, cmd0xe07$ReqBody.class);
    public final PBUInt32Field version = PBField.initUInt32(1);
    public final PBEnumField client = PBField.initEnum(0);
    public final PBEnumField entrance = PBField.initEnum(0);
    public cmd0xe07$OCRReqBody ocrReqBody = new cmd0xe07$OCRReqBody();
}
