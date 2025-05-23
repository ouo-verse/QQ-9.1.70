package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$WaterprofWallInfo extends MessageMicro<GatewayVerify$WaterprofWallInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_waterprof_wall_sig", "iframe_randstr", "iframe_sid"}, new Object[]{"", "", ""}, GatewayVerify$WaterprofWallInfo.class);
    public final PBStringField str_waterprof_wall_sig = PBField.initString("");
    public final PBStringField iframe_randstr = PBField.initString("");
    public final PBStringField iframe_sid = PBField.initString("");
}
