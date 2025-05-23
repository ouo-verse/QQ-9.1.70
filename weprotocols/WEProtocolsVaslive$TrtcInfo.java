package weprotocols;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class WEProtocolsVaslive$TrtcInfo extends MessageMicro<WEProtocolsVaslive$TrtcInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 34, 42}, new String[]{PreloadTRTCPlayerParams.KEY_SIG, "timeout", "businessInfo", "secStr"}, new Object[]{"", 0L, "", ""}, WEProtocolsVaslive$TrtcInfo.class);
    public final PBStringField sig = PBField.initString("");
    public final PBInt64Field timeout = PBField.initInt64(0);
    public final PBStringField businessInfo = PBField.initString("");
    public final PBStringField secStr = PBField.initString("");
}
