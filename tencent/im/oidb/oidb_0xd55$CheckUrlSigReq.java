package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd55$CheckUrlSigReq extends MessageMicro<oidb_0xd55$CheckUrlSigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_need_check_raw_url_sig"}, new Object[]{Boolean.FALSE}, oidb_0xd55$CheckUrlSigReq.class);
    public final PBBoolField is_need_check_raw_url_sig = PBField.initBool(false);
}
