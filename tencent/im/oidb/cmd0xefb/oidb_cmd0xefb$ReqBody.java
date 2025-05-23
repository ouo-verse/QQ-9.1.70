package tencent.im.oidb.cmd0xefb;

import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xefb$ReqBody extends MessageMicro<oidb_cmd0xefb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "timestamp", MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL}, new Object[]{0L, 0L, 0}, oidb_cmd0xefb$ReqBody.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBUInt32Field timeInterval = PBField.initUInt32(0);
}
