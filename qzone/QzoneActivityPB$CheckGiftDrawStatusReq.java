package qzone;

import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$CheckGiftDrawStatusReq extends MessageMicro<QzoneActivityPB$CheckGiftDrawStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{AdParam.ACTID, "uin"}, new Object[]{0L, 0L}, QzoneActivityPB$CheckGiftDrawStatusReq.class);
    public final PBInt64Field actid = PBField.initInt64(0);
    public final PBInt64Field uin = PBField.initInt64(0);
}
