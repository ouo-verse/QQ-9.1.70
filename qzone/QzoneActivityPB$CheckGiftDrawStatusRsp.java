package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$CheckGiftDrawStatusRsp extends MessageMicro<QzoneActivityPB$CheckGiftDrawStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"can_draw"}, new Object[]{Boolean.FALSE}, QzoneActivityPB$CheckGiftDrawStatusRsp.class);
    public final PBBoolField can_draw = PBField.initBool(false);
}
