package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbcb$ReqBody extends MessageMicro<oidb_0xbcb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{72, 82}, new String[]{"not_use_cache", "check_url_req"}, new Object[]{0, null}, oidb_0xbcb$ReqBody.class);
    public final PBInt32Field not_use_cache = PBField.initInt32(0);
    public oidb_0xbcb$CheckUrlReq check_url_req = new oidb_0xbcb$CheckUrlReq();
}
